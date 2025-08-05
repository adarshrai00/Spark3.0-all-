// API Configuration
const API_BASE_URL = 'http://localhost:8080';

// DOM Elements
const searchForm = document.getElementById('searchForm');
const sourceInput = document.getElementById('source');
const destinationInput = document.getElementById('destination');
const swapBtn = document.getElementById('swapBtn');
const searchBtn = document.getElementById('searchBtn');
const resultsDiv = document.getElementById('results');

// Event Listeners
document.addEventListener('DOMContentLoaded', initializeApp);

function initializeApp() {
    // Swap functionality
    swapBtn.addEventListener('click', swapStations);
    
    // Form submission
    searchForm.addEventListener('submit', handleFormSubmit);
    
    // Auto-uppercase input
    setupInputFormatting();
}

function swapStations() {
    const sourceValue = sourceInput.value;
    const destinationValue = destinationInput.value;
    
    sourceInput.value = destinationValue;
    destinationInput.value = sourceValue;
}

async function handleFormSubmit(e) {
    e.preventDefault();
    
    const sourceCode = sourceInput.value.trim().toUpperCase();
    const destinationCode = destinationInput.value.trim().toUpperCase();
    
    if (!validateInput(sourceCode, destinationCode)) {
        return;
    }

    await searchTrains(sourceCode, destinationCode);
}

function validateInput(sourceCode, destinationCode) {
    if (!sourceCode || !destinationCode) {
        showError('Please enter both source and destination station codes');
        return false;
    }

    if (sourceCode === destinationCode) {
        showError('Source and destination cannot be the same');
        return false;
    }

    return true;
}

async function searchTrains(sourceCode, destinationCode) {
    showLoading();
    
    try {
        const response = await fetch(`${API_BASE_URL}/search/by-code?sourcecode=${sourceCode}&destinationcode=${destinationCode}`);
        
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        
        const trains = await response.json();
        displayResults(trains);
        
    } catch (error) {
        console.error('Error fetching trains:', error);
        showError('Failed to search trains. Please check your connection and try again.');
    }
}

function showLoading() {
    searchBtn.disabled = true;
    searchBtn.textContent = 'Searching...';
    
    resultsDiv.innerHTML = `
        <div class="loading">
            <div class="spinner"></div>
            <p>Searching for trains...</p>
        </div>
    `;
}

function displayResults(trains) {
    resetSearchButton();
    
    if (!trains || trains.length === 0) {
        showNoResults();
        return;
    }

    const resultsHTML = generateResultsHTML(trains);
    resultsDiv.innerHTML = `
        <h2 style="margin-bottom: 20px; color: #1f2937; font-size: 1.5rem;">
            Found ${trains.length} train${trains.length > 1 ? 's' : ''}
        </h2>
        ${resultsHTML}
    `;
}

function generateResultsHTML(trains) {
    return trains.map(train => `
        <div class="train-card">
            <div class="train-header">
                <div class="train-details">
                    <div class="train-number">${train.train.trainnumber}</div>
                    <div class="train-name">${train.train.trainname}</div>
                </div>
            </div>
            <div class="train-info">
                <div class="station-info">
                    <div class="station-name">${train.source.stationName}</div>
                    <div class="station-code">${train.source.stationCode}</div>
                </div>
                
                <div class="time-info">
                    <div class="time">${train.departureTime}</div>
                    <div class="time-label">Departure</div>
                </div>
                
                <div class="journey-line"></div>
                
                <div class="time-info">
                    <div class="time">${train.arrivalTime}</div>
                    <div class="time-label">Arrival</div>
                </div>
                
                <div class="station-info">
                    <div class="station-name">${train.destination.stationName}</div>
                    <div class="station-code">${train.destination.stationCode}</div>
                </div>
            </div>
        </div>
    `).join('');
}

function showNoResults() {
    resultsDiv.innerHTML = `
        <div class="no-results">
            <div class="no-results-icon">🚫</div>
            <h3>No trains found</h3>
            <p>No trains available for the selected route. Please try different stations.</p>
        </div>
    `;
}

function showError(message) {
    resetSearchButton();
    
    resultsDiv.innerHTML = `
        <div class="error">
            <strong>Error:</strong> ${message}
        </div>
    `;
}

function resetSearchButton() {
    searchBtn.disabled = false;
    searchBtn.textContent = 'Search Trains';
}

function setupInputFormatting() {
    [sourceInput, destinationInput].forEach(input => {
        input.addEventListener('input', (e) => {
            e.target.value = e.target.value.toUpperCase();
        });
    });
}