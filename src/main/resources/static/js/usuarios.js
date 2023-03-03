// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios(){

    const request = await fetch('usuario/123',{
        method: 'GET',
        header: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const data = await request.json();
    console.log(data);

};