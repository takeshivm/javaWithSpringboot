// Call the dataTables jQuery plugin
$(document).ready(function() {
    //
});

async function registrarUsuario(){

    let data = {};
    data.nombre = document.getElementById('txtFirstName').value;
    data.apellido = document.getElementById('txtLastName').value;
    data.email = document.getElementById('txtEmail').value;
    data.password = document.getElementById('txtPassword').value;
    let repeatPassword = document.getElementById('txtRepeatPassword').value;

    if(repeatPassword != data.password){
        alert('La contraseña no coincide');
        return;
    }
    console.log(data);
    const request = await fetch('api/usuarios',{
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    //const usuarios = await request.json();
    const response = await request.text();
    let usuarios;
    if (response.trim() === '') {
        console.log("La respuesta del servidor está vacía");
        return;
    }
    try {
      usuarios = JSON.parse(response);
    } catch (e) {
      console.log("Error al leer la respuesta del servidor:", e);
      return;
    }
};
