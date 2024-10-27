document.addEventListener("DOMContentLoaded", function () {
  const adminLink = document.getElementById("admin-link");
  const adminMenu = document.getElementById("admin-menu");

  adminLink.addEventListener("click", function () {
    adminMenu.classList.toggle("hidden");
  });
});
