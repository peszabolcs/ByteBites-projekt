function addToCart(button) {
    const dishId = button.getAttribute("data-dish-id");
    console.log("Kattintott gomb:", button);
    console.log("Küldött dishId:", dishId);

    fetch(`/cart/add?userId=1&dishId=${dishId}`, {
        method: "POST",
    })
        .then(response => {
            console.log("Fetch válasz státusz:", response.status);
            if (!response.ok) {
                return response.text().then(error => {
                    console.log("Fetch válasz hiba:", error);
                    throw new Error(error);
                });
            }
            return response.text();
        })
        .then(data => {
            console.log("Sikeres válasz:", data);
            alert("Étel hozzáadva a kosárhoz!");
        })
        .catch(error => {
            console.error("Hiba történt:", error.message);
            alert(`Nem sikerült hozzáadni a kosárhoz: ${error.message}`);
        });
}


document.querySelectorAll(".add-button").forEach((button, index) => {
    console.log(`Gomb index: ${index}, dishId attribútum: ${button.getAttribute("data-dish-id")}`);
});

