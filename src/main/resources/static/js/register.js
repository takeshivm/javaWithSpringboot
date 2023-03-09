// Call the dataTables jQuery plugin
$(document).ready(function() {
    //
});

async function registrarUsuario(){

    data
    const request = await fetch('api/usuarios',{
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data);
    });
    const usuarios = await request.json();
    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

};
