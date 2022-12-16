window.onload = function () { //Esta funciòn permite que se cargue la tabla automàticamente
    readClientes();           //De lo contrario tendremos que presionar el botòn para cargarla
};

function readClientes() {
    let buscar = document.getElementById('buscar');
    /*El ajax utilizando lenguaje jquery me va a permitir enviar los datos a nuestro 
     controlador que en este caso es un servlet. Envía los datos y luego regresa un
     dato success.
     Enviar los datos desde la vista y esperar una respuesta. Sirve para cualquier
     lenguaje de programación de servidor. Los lenguajes actuales se van a conectar 
     siempre a servicios.*/

    $.ajax({
        /*Preparamos el ambiente para enviar los datos. Estructura básica para
         conectarnos con el Servlet*/
        data: {
            "crud": "sel",
            "txtBuscar": buscar.value
        },
        url: "./ClientesS",
        async: true,
        type: "GET",
        dataType: "text",
        /*Cuando es success, regresa la información ya que resulta satisfactorio*/
        success: function (datos) {
            /*Aquí se va a imprimir la tabla*/
            document.getElementById('tablaClientes').innerHTML = datos;
        }
    });
}

function insertarClientes() {
    let cedula = document.getElementById('txtCi');
    let numeroDeCuenta = document.getElementById('txtNdc');
    let saldo = document.getElementById('txtSaldo');
    let nombre = document.getElementById('txtNom');
    let apellido = document.getElementById('txtApe');
    let direccion = document.getElementById('txtDir');
    let telefono = document.getElementById('txtTel');

    $.ajax({
        data: {
            "crud": "in",
            "txtCi": cedula.value,
            "txtNdc": numeroDeCuenta.value,
            "txtSaldo": saldo.value,
            "txtNom": nombre.value,
            "txtApe": apellido.value,
            "txtDir": direccion.value,
            "txtTel": telefono.value
        },
        url: "./ClientesS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            /*En JS  se colocan 3 ===, diferente sería !==*/
            if (datos === 'true') {
                alert("Cliente insertado");
            } else {
                alert("Cliente no insertado");
            }
            /*Permite que se recargue automáticamente la tabla. Sin esto hay que 
             actualizar manualmente.*/
            document.getElementById('closeInsertar').click();
            readClientes();
        }
    });
}

function cargarDatosActualizar(id, ci, ndc, saldo, nom, ape, dir, tel) {
    /*Estos id salen del modal de actualizar*/

    document.getElementById("numIdUp").value = id;
    document.getElementById('txtCiUp').value = ci;
    document.getElementById('txtNdcUp').value = ndc;
    document.getElementById('txtSaldoUp').value = saldo;
    document.getElementById('txtNomUp').value = nom;
    document.getElementById('txtApeUp').value = ape;
    document.getElementById('txtDirUp').value = dir;
    document.getElementById('txtTelUp').value = tel;
}

function updateClientes() {
    /*Se coloca el evento onclick en el botón actualizar de 
     clientesVista*/
    let id = document.getElementById("numIdUp").value;
    let ci = document.getElementById('txtCiUp').value;
    let ndc = document.getElementById('txtNdcUp').value;
    let saldo = document.getElementById('txtSaldoUp').value;
    let nom = document.getElementById('txtNomUp').value;
    let ape = document.getElementById('txtApeUp').value;
    let dir = document.getElementById('txtDirUp').value;
    let tel = document.getElementById('txtTelUp').value;

    $.ajax({
        data: {
            /*Tiene que ser igual al mètodo update de clientesServlet*/
            "crud": "up",
            "numId": id,
            "txtCi": ci,
            "txtNdc": ndc,
            "txtSaldo": saldo,
            "txtNom": nom,
            "txtApe": ape,
            "txtDir": dir,
            "txtTel": tel
        },
        url: "./ClientesS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            /*En JS  se colocan 3 ===, diferente sería !==*/
            //alert(datos);
            if (datos === 'true') {
                alert("Cliente Actualizado");
            } else {
                alert("Cliente no actualizado");
            }
            /*Permite que se recargue automáticamente la tabla. Sin esto hay que 
             actualizar manualmente.*/
            document.getElementById('closeUpdate').click();
            readClientes();
        }
    });
}

function cargarDatosEliminar(id) {
    document.getElementById('numInDel').value = id;
}

function eliminarClientes() {
    let id = document.getElementById('numInDel').value;

    $.ajax({
        data: {

            "crud": "del",
            "txtID": id

        },
        url: "./ClientesS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            /*En JS  se colocan 3 ===, diferente sería !==*/
            if (datos === 'true') {
                alert("Cliente Eliminado");
            } else {
                alert("Cliente no Eliminado");
            }
            /*Permite que se recargue automáticamente la tabla. Sin esto hay que 
             actualizar manualmente.*/
            document.getElementById('closeDelete').click();
            readClientes();
        }
    });
}


