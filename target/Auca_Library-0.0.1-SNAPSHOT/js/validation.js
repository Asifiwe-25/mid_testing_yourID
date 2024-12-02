document.addEventListener('DOMContentLoaded', () => {
    // Validate form fields
    const registerForm = document.querySelector("form");
    if (registerForm) {
        registerForm.addEventListener("submit", function (event) {
            const username = document.getElementById("username").value;
            const password = document.getElementById("password").value;
            
            if (username.length < 3) {
                alert("Username must be at least 3 characters long.");
                event.preventDefault();
            }
            if (password.length < 6) {
                alert("Password must be at least 6 characters long.");
                event.preventDefault();
            }
        });
    }
});
