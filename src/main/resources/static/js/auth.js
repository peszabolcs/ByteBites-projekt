document.querySelector("form").addEventListener("submit", async function (e) {
    e.preventDefault(); // Az alapértelmezett form-küldés megakadályozása

    const formData = new FormData(this);
    const email = formData.get("email");
    const password = formData.get("password");

    try {
        const response = await fetch("/login", {
            method: "POST",
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
            body: new URLSearchParams({ email, password }),
        });

        if (response.ok) {
            const message = await response.text();
            alert("Sikeres bejelentkezés: " + message);
            window.location.href = "/"; // Átirányítás a főoldalra
        } else {
            const errorMessage = await response.text();
            document.querySelector(".error-message").style.display = "block";
            document.querySelector(".error-message").textContent = errorMessage;
        }
    } catch (error) {
        console.error("Hiba történt:", error);
        alert("Hálózati hiba. Próbáld újra később.");
    }
});