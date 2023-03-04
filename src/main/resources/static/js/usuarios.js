// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios(){

    const request = await fetch('usuarios',{
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const usuarios = await request.json();
    console.log(usuarios);
    let listadoHtml = '';
    //console.log(usuarios);
    for(let usuario of usuarios){
        const usuariosHtml = `
        <tr>
            <td>`+usuario.id+`</td>
            <td>`+usuario.nombre+`</td>
            <td>`+usuario.apellido+`</td>
            <td>`+usuario.email+`</td>
            <td>`+usuario.telefono+`</td>
            <td>
                <a href="#" class="btn btn-danger btn-circle btn-lg">
                    <i class="fas fa-trash"></i>
                </a>
            </td>
        </tr>
        `;
        listadoHtml += usuariosHtml;
    }

    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

};