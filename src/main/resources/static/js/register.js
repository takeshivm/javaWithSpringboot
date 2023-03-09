// Call the dataTables jQuery plugin
$(document).ready(function() {
    //
});

async function registrarUsuario(){

    const request = await fetch('api/usuarios',{
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const usuarios = await request.json();
    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

};
