const BASE_URL = "http://localhost:8080";

async function loadProduct() {
  console.log("loadProduct function called");
  try {
    console.log("Making API call to:", `${BASE_URL}/products`);
    const response = await fetch(`${BASE_URL}/products`);
    
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    
    const products = await response.json();
    console.log("Products data:", products);

    let trendinglist = document.getElementById("trending-products");
    let clothinglist = document.getElementById("clothing-products");
    let electronicslist = document.getElementById("electronics-products");

    trendinglist.innerHTML = "";
    clothinglist.innerHTML = "";
    electronicslist.innerHTML = "";

    products.forEach((product) => {
      let productCard = `
        <div class="col-lg-4 col-md-6 mb-4">
          <div class="card h-100">
            <img src="${product.imageUrl}" class="card-img-top" alt="${product.name}" style="height: 200px; object-fit: cover;"/>
            <div class="card-body d-flex flex-column">
              <h5 class="card-title">${product.name}</h5>
              <p class="card-text">${product.description}</p>
              <p class="price"><strong>₹${product.price}</strong></p>
              <button class="btn btn-primary mt-auto"
  onclick="addToCart(${product.id}, '${product.name}', ${product.price}, '${product.imageUrl}', this)">
  Add to Cart
</button>

            </div>
          </div>
        </div>
      `;

      if (product.category === 'Clothing') {
        clothinglist.innerHTML += productCard;
      } else if (product.category === 'Electronics') {
        electronicslist.innerHTML += productCard;
      } else {
        trendinglist.innerHTML += productCard;
      }
    });
  } catch (error) {
    console.error("Error loading products:", error);
  }
}