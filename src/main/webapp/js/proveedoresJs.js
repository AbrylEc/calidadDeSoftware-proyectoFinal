window.onload = function () { //Esta funciòn permite que se cargue la tabla automàticamente
    readProveedores();           //De lo contrario tendremos que presionar el botòn para cargarla
};

function readProveedores() {
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
        url: "./ProveedoresS",
        async: true,
        type: "GET",
        dataType: "text",
        /*Cuando es success, regresa la información ya que resulta satisfactorio*/
        success: function (datos) {
            /*Aquí se va a imprimir la tabla*/
            document.getElementById('tablaProveedores').innerHTML = datos;
        }
    });
}

function insertarProveedores() {
    let ruc = document.getElementById('txtRuc');
    let nombre = document.getElementById('txtNom');
    let direccion = document.getElementById('txtDir');
    let telefono = document.getElementById('txtTel');

    $.ajax({
        data: {
            "crud": "in",
            "txtRuc": ruc.value,
            "txtNom": nombre.value,
            "txtDir": direccion.value,
            "txtTel": telefono.value
        },
        url: "./ProveedoresS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            /*En JS  se colocan 3 ===, diferente sería !==*/
            if (datos === 'true') {
                alert("Proveedor insertado");
            } else {
                alert("Proveedor no insertado");
            }
            /*Permite que se recargue automáticamente la tabla. Sin esto hay que 
             actualizar manualmente.*/
            document.getElementById('closeInsertar').click();
            readProveedores();
        }
    });
}

function cargarDatosActualizar(id, r, n , d, t) {
    /*Estos id salen del modal de actualizar*/
    document.getElementById('numIdUp').value = id;
    document.getElementById('txtRucUp').value = r;
    document.getElementById('txtNomUp').value = n;
    document.getElementById('txtDirUp').value = d;
    document.getElementById('txtTelUp').value = t;
}

function updateProveedores() {
    /*Se coloca el evento onclick en el botón actualizar de 
     clientesVista*/
    let id = document.getElementById("numIdUp").value;
    let r = document.getElementById("txtRucUp").value;
    let n = document.getElementById("txtNomUp").value;
    let d = document.getElementById("txtDirUp").value;
    let t = document.getElementById("txtTelUp").value;

    $.ajax({
        data: {
            /*Tiene que ser igual al mètodo update de clientesServlet*/
            "crud": "up",
            "numId": id,
            "txtRuc": r,
            "txtNom": n,
            "txtDir": d,
            "txtTel": t
        },
        url: "./ProveedoresS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            /*En JS  se colocan 3 ===, diferente sería !==*/
            if (datos === 'true') {
                alert("Proveedor actualizado");
            } else {
                alert("Proveedor no actualizado");
            }
            /*Permite que se recargue automáticamente la tabla. Sin esto hay que 
             actualizar manualmente.*/
            document.getElementById('closeUpdate').click();
            readProveedores();
        }
    });
}

function cargarDatosEliminar(id) {
    document.getElementById('numInDel').value = id;
}

function eliminarProveedores() {
    let id = document.getElementById('numInDel').value;

    $.ajax({
        data: {

            "crud": "del",
            "txtID": id

        },
        url: "./ProveedoresS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            /*En JS  se colocan 3 ===, diferente sería !==*/
            if (datos === 'true') {
                alert("Proveedor Eliminado");
            } else {
                alert("Proveedor no Eliminado");
            }
            /*Permite que se recargue automáticamente la tabla. Sin esto hay que 
             actualizar manualmente.*/
            document.getElementById('closeDelete').click();
            readProveedores();
        }
    });
}

