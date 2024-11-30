async function updateHeaderUsername() {
    try {
        const response = await fetch("/users/current-user", {
            method: "GET",
        });
        if (response.ok) {
            const username = await response.text();
            document.getElementById("username").textContent = username;
        } else {
            document.getElementById("username").textContent = "Guest";
        }
    } catch (error) {
        console.error("Hiba történt a felhasználói név lekérdezésekor:", error);
        document.getElementById("username").textContent = "Guest";
    }
}

// Meghívás az oldal betöltésekor
document.addEventListener("DOMContentLoaded", updateHeaderUsername);
