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
