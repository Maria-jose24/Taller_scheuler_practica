document.getElementById('userForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const formData = new FormData(this);

    const user = {
        tipoDocumento: formData.get('tipoDocumento'),
        numeroDocumento: formData.get('numeroDocumento'),
        fechaNacimiento: formData.get('fechaNacimiento'),
        contraseña: formData.get('contraseña'),
        correoElectronico: formData.get('correoElectronico')
    };

    fetch('http://localhost:8086/api/v1/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
    .then(response => response.json())
    .then(data => {
        alert('Usuario registrado exitosamente');
        loadUsers();
    })
    .catch(error => console.error('Error:', error));
});

function loadUsers() {
    fetch('http://localhost:8086/api/v1/users')
    .then(response => response.json())
    .then(users => {
        const userList = document.getElementById('userList');
        userList.innerHTML = '';
        users.forEach(user => {
            const userItem = document.createElement('div');
            userItem.textContent = `${user.tipoDocumento} - ${user.numeroDocumento} - ${user.correoElectronico}`;
            userList.appendChild(userItem);
        });
    })
    .catch(error => console.error('Error:', error));
}

loadUsers();
