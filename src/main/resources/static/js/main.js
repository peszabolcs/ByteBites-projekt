document.addEventListener("DOMContentLoaded", function () {
  const adminLink = document.getElementById("admin-link");
  const adminMenu = document.getElementById("admin-menu");
  const usernameBtn = document.getElementById("username");
  const dropdownMenu = document.querySelector(".dropdown");

  // Toggle admin menu
  adminLink.addEventListener("click", function (event) {
    event.stopPropagation();
    adminMenu.style.display =
      adminMenu.style.display === "none" ? "block" : "none";
  });

  // Toggle user dropdown menu
  usernameBtn.addEventListener("click", function (event) {
    event.stopPropagation();
    dropdownMenu.style.display =
      dropdownMenu.style.display === "none" ? "block" : "none";
  });

  // Hide menus when clicking outside
  document.addEventListener("click", function (event) {
    if (!adminMenu.contains(event.target) && event.target !== adminLink) {
      adminMenu.style.display = "none";
    }
    if (!dropdownMenu.contains(event.target) && event.target !== usernameBtn) {
      dropdownMenu.style.display = "none";
    }
  });
});
