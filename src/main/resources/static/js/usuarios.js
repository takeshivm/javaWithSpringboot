// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
  updateUserEmail();
});

function updateUserEmail() {
    document.getElementById('txtEmailUsuario').outerHTML = localStorage.email;
}

async function cargarUsuarios(){

    const request = await fetch('api/usuarios',{
        method: 'GET',
        headers: getHeaders()
    });
    const usuarios = await request.json();
    console.log(usuarios);


    let listadoHtml = '';
    //console.log(usuarios);
    for(let usuario of usuarios){
        let button = `<a href="#" onclick="eliminarUsuario('${usuario.id}')" class="btn btn-danger btn-circle btn-lg">
                              <i class="fas fa-trash"></i>
                          </a>`;
        let telefono = usuario.telefono ? usuario.telefono : '-';

        let usuariosHtml = `
        <tr>
            <td>`+usuario.id+`</td>
            <td>`+usuario.nombre+` `+usuario.apellido+`</td>
            <td>`+usuario.email+`</td>
            <td>`+telefono+`</td>
            <td>${button}</td>
        </tr>
        `;
        listadoHtml += usuariosHtml;
    }

    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

};

function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    }
}

async function eliminarUsuario(id){
    if(!confirm('¿Desea eliminar al usuario?')){
        return;
    }

    const request = await fetch('api/usuario/${id}',{
        method: 'DELETE',
        headers: getHeaders()
    });

    location.reload();

}