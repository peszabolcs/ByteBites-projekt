document.addEventListener('DOMContentLoaded', function() {
    const addButtons = document.querySelectorAll('.add-button');
    console.log(addButtons);
    addButtons.forEach(button => {
        button.addEventListener('click', function() {
            console.log('Add button clicked');
            const dishElement = this.closest('.menu-item');
            const dishName = dishElement.querySelector('h5').innerText;
            const dishPrice = dishElement.querySelector('p').innerText;
            const dish = {
                name: dishName,
                price: parseFloat(dishPrice)
            };
            addToCart(dish);
        });
    });
});

function addToCart(itemId) {
    fetch('http://localhost:8080/api/cart/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem('token') // Include the token in the request headers
        },
        body: JSON.stringify({ itemId: itemId })
    })
        .then(response => {
            if (response.status === 403) {
                alert('You must be logged in to add items to the cart.');
                window.location.href = '/login'; // Redirect to login page
            } else if (response.ok) {
                return response.json();
            } else {
                throw new Error('Failed to add item to cart');
            }
        })
        .then(data => {
            console.log('Item added to cart:', data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}