// Call the dataTables jQuery plugin
$(document).ready(function() {
    //
});

async function startSession(){

    let data = {};
    data.email = document.getElementById('txtEmail').value;
    data.password = document.getElementById('txtPassword').value;

    console.log(data);
    const request = await fetch('api/login',{
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    //const usuarios = await request.json();
    let usuarios;
    const response = await request.text();
    console.log(response);
    if (response.trim() !== 'False') {
      localStorage.token = response;
      localStorage.email = data.email;
      window.location.href = 'usuarios.html';
    } else {
      alert('Credenciales inválidas. Por favor, intenta de nuevo.');
    }
    //min 4:04:06
    try {
      usuarios = JSON.parse(response);
    } catch (e) {
      console.log("Error al leer la respuesta del servidor:", e);
      return;
    }

};
