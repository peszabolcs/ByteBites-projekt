document.addEventListener("DOMContentLoaded", function () {
  const isLoggedIn = true; // Replace with your actual login logic
  const loginBtn = document.getElementById("login-btn");
  const registerBtn = document.getElementById("register-btn");
  const userContainer = document.getElementById("user-container");
  const username = document.getElementById("username");
  const dropdown = document.querySelector(".dropdown");

  if (isLoggedIn) {
    loginBtn.style.display = "none";
    registerBtn.style.display = "none";
    userContainer.style.display = "flex";
  }

  // Toggle dropdown visibility on click
  username.addEventListener("click", function (event) {
    console.log("Username clicked"); // Debugging: Check if click is detected
    event.stopPropagation(); // Prevent immediate close
    dropdown.style.display =
      dropdown.style.display === "block" ? "none" : "block";
    console.log("Dropdown display:", dropdown.style.display); // Debugging: Check dropdown status
  });

  // Close the dropdown if clicked outside
  document.addEventListener("click", function (event) {
    if (!userContainer.contains(event.target)) {
      console.log("Clicked outside, closing dropdown"); // Debugging: Detect outside clicks
      dropdown.style.display = "none";
    }
  });
});
