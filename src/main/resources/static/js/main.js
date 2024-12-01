document.addEventListener("DOMContentLoaded", function () {
  const adminLink = document.getElementById("admin-link");
  const adminMenu = document.getElementById("admin-menu");
  const usernameBtn = document.getElementById("username");
  const dropdownMenu = document.querySelector(".dropdown");

  // Toggle admin menu
  adminLink.addEventListener("click", function (event) {
    event.stopPropagation();
    adminMenu.classList.toggle("visible");
  });

  // Toggle user dropdown menu
  usernameBtn.addEventListener("click", function (event) {
    event.stopPropagation();
    dropdownMenu.classList.toggle("visible");
  });

  // Hide menus when clicking outside
  document.addEventListener("click", function (event) {
    if (!adminMenu.contains(event.target) && event.target !== adminLink) {
      adminMenu.classList.remove("visible");
    }
    if (!dropdownMenu.contains(event.target) && event.target !== usernameBtn) {
      dropdownMenu.classList.remove("visible");
    }
  });
});

async function checkSession() {
  try {
    const response = await fetch("/users/session", {
      method: "GET",
    });

    console.log("HTTP válasz státusz:", response.status);

    if (response.ok) {
      const userData = await response.json();
      console.log("Bejelentkezett felhasználó:", userData);
      return userData;
    } else if (response.status === 401) {
      console.warn("Nincs aktív session. Bejelentkezés szükséges.");
      return null;
    } else if (response.status === 500) {
      const errorMessage = await response.text();
      console.error("Szerverhiba történt:", errorMessage);
      alert("Szerverhiba történt: " + errorMessage);
    } else {
      console.error(`Nem várt státuszkód: ${response.status}`);
    }
  } catch (error) {
    console.error("Hiba történt a fetch kérés során:", error);
  }
  return null;
}





// Meghívás például az oldal betöltésekor
checkSession();

async function goToCart() {
  try {
    const response = await fetch("/cart", {
      method: "GET",
      credentials: "include",
    });

    if (response.ok) {
      // Ha be van jelentkezve, a kosár tartalma megjelenhet
      // const message = await response.text();
      // alert(message); // Tesztelési célból kiírjuk a választ
      window.location.href = "/cart"; // Irány a kosár oldala
    } else if (response.status === 401) {
      // Ha nincs bejelentkezve, irány a login oldalra
      alert("Előbb jelentkezz be a kosár megtekintéséhez!");
      window.location.href = "/login";
    }
  } catch (error) {
    console.error("Hiba történt a kosár megtekintésekor:", error);
  }
}

// Példa: kosár gombra kattintáskor
document.getElementById("cart-icon").addEventListener("click", goToCart);
