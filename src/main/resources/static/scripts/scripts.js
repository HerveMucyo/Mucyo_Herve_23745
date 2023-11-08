"use strict";
// Event Listeners
document.getElementById("loginBtn").addEventListener("click", checkValidation);
document.getElementById("signupBtnn").addEventListener("click", regForm);
document.getElementById("myForm").addEventListener("submit", validateForm);

// Email validation function
function isValidEmail(email) {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return emailRegex.test(email);
}

// Form Validation Functions
function checkValidation() {
  const contactEmail = document.getElementById("mail").value;
  const contactPassword = document.getElementById("contact-password").value;
  const emailError = document.querySelector(".email-error");
  const passwordError = document.querySelector(".password-error");

  // Reset error messages
  emailError.textContent = "";
  passwordError.textContent = "";

  // Validate email
  if (contactEmail.trim() === "") {
    emailError.textContent = "Please insert your email";
    return false;
  } else if (!isValidEmail(contactEmail)) {
    emailError.textContent = "Please enter a valid email address";
    return false;
  }

  // Validate password (add your password validation logic here)
  if (contactPassword.trim() === "") {
    passwordError.textContent = "Please insert your password";
    return false;
  }

  // If both email and password are valid, redirect to the second page
  // window.location.href = "welcome.html";
}

function validateForm(event) {
  const dropdown = document.getElementById("dropdown");
  const dropdownError = document.getElementById("dropdownError");

  if (dropdown.value === "") {
    dropdownError.textContent = "Please select an option";
    event.preventDefault(); // Prevent form submission
  } else {
    dropdownError.textContent = ""; // Clear error message
  }

  // Add other form field validations as needed
}

function regForm() {
  // Redirect to the registration form page
  // window.location.href = "Admission.jsp";
}

// Hello !!
