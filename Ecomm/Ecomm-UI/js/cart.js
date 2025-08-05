let cart = JSON.parse(localStorage.getItem("cart") || "[]");

function loadCart() {
    let cartItems = document.getElementById("cart-items");
    let totalAmount = 0;
    cartItems.innerHTML = "";

    cart.forEach((item, index) => {
        let itemTotal = item.price * item.quantity;
        totalAmount += itemTotal;

        cartItems.innerHTML += `
        <tr>
            <td><img src="${item.imageUrl}" width="50"></td>
            <td>${item.name}</td>
            <td>₹${item.price}</td>
            <td>
                <button class="btn btn-sm btn-secondary" onclick="changeQuantity(${index}, -1)">-</button>
                ${item.quantity}
                <button class="btn btn-sm btn-secondary" onclick="changeQuantity(${index}, 1)">+</button>
            </td>
            <td>₹${itemTotal}</td>
            <td><button class="btn btn-sm btn-danger" onclick="removeItem(${index})">🗑</button></td>
        </tr>`;
    });

    document.getElementById("total-amount").innerText = `₹${totalAmount}`;
}

function addToCart(id, name, price, imageUrl, btn) {
    console.log("Adding product to cart:", id, name, price, imageUrl);
    price = parseFloat(price);

    let itemIndex = cart.findIndex((item) => item.id === id);
    if (itemIndex !== -1) {
        cart[itemIndex].quantity += 1;
    } else {
        cart.push({
            id,
            name,
            price,
            imageUrl,
            quantity: 1
        });
    }

    localStorage.setItem("cart", JSON.stringify(cart));
    updateCartCounter();

    // ✅ Change button text to "Added"
    btn.innerText = "Added";
    btn.disabled = true; // optional: prevent clicking again
}

// Optional: update quantity
function changeQuantity(index, delta) {
    cart[index].quantity += delta;

    if (cart[index].quantity <= 0) {
        cart.splice(index, 1);
    }

    localStorage.setItem("cart", JSON.stringify(cart));
    loadCart();
    updateCartCounter();
}

// Optional: remove item directly
function removeItem(index) {
    cart.splice(index, 1);
    localStorage.setItem("cart", JSON.stringify(cart));
    loadCart();
    updateCartCounter();
}

// Optional: update cart badge count
function updateCartCounter() {
    document.querySelector(".cart-badge").innerText=cart.length;
}

document.addEventListener("DOMContentLoaded",loadCart)
