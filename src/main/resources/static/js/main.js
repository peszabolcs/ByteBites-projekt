document.addEventListener("DOMContentLoaded", function () {
  const adminLink = document.getElementById("admin-link");
  const adminMenu = document.getElementById("admin-menu");

  adminLink.addEventListener("click", function (event) {
    event.stopPropagation();
    adminMenu.style.display =
      adminMenu.style.display === "none" ? "block" : "none";
  });

  // Hide the menu when clicking outside of it
  document.addEventListener("click", function (event) {
    if (!adminMenu.contains(event.target) && event.target !== adminLink) {
      adminMenu.style.display = "none";
    }
  });
});
