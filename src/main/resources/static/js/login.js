document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.querySelector('form[action="/login"]');
    if (loginForm) {
        loginForm.addEventListener('submit', function(event) {
            event.preventDefault();
            const username = document.getElementById('email').value;
            const password = document.getElementById('password').value;

            fetch('/api/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ username: username, password: password })
            })
                .then(response => {
                    if (response.ok) {
                        return response.json();
                    } else {
                        throw new Error('Login failed');
                    }
                })
                .then(data => {
                    localStorage.setItem('token', data.token);
                    alert('Login successful');
                    window.location.href = '/';
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Login failed');
                });
        });
    }
});