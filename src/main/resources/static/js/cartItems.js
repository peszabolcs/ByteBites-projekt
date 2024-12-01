document.addEventListener('DOMContentLoaded', function() {
    fetch('/cart/items')
        .then(response => response.text()) // JSON helyett szövegként olvasd be
        .then(text => {
            console.log('Kapott válasz:', text); // Nézd meg, mi érkezik
            return JSON.parse(text); // Ez dob hibát, ha a JSON nem érvényes
        })
        .then(data => {
            const cartItemsContainer = document.querySelector('.cart-items');
            cartItemsContainer.innerHTML = '';

            data.forEach(item => {
                const cartItem = document.createElement('div');
                cartItem.classList.add('cart-item');
                cartItem.innerHTML = `
                    <img src="/img/elsodleges/" alt="${item.dish.name}" />
                    <div class="item-details">
                        <strong>${item.dish.name}</strong>
<!--                        <p>${item.dish.restaurantName}</p>-->
                    </div>
                    <div class="item-quantity">
                        <button>-</button>
                        <input type="number" value="${item.quantity}" />
                        <button>+</button>
                    </div>
                    <div class="item-price">${item.price} Ft</div>
                    <button class="remove-item">✖</button>
                `;
                cartItemsContainer.appendChild(cartItem);
            });
        })
        .catch(error => console.error(error));
});
