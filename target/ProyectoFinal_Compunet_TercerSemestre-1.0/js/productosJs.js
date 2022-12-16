window.onload = function () {
    readProductos();
};

function readProductos() {
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
        url: "./ProductosS",
        async: true,
        type: "GET",
        dataType: "text",
        /*Cuando es success, regresa la información ya que resulta satisfactorio*/
        success: function (datos) {
            /*Aquí se va a imprimir la tabla*/
            document.getElementById('tablaProductos').innerHTML = datos;
        }
    });
}

function insertarProductos() {
    let idProveedores = document.getElementById('txtIp');
    let nombre = document.getElementById('txtNom');
    let descripcion = document.getElementById('txtDescripcion');
    let valorCompra = document.getElementById('txtValCom');
    let valorVenta = document.getElementById('txtValVen');
    let stock = document.getElementById('txtStock');
    let tieneIva = document.getElementById('txtIva');
    let tipoProd = document.getElementById('txtTipoProd');

    $.ajax({
        data: {
            "crud": "in",
            "numIp": idProveedores.value,
            "txtN": nombre.value,
            "txtD": descripcion.value,
            "decVc": valorCompra.value,
            "decVv": valorVenta.value,
            "numS": stock.value,
            "txtTi": tieneIva.value,
            "txtTp": tipoProd.value
        },

        url: "./ProductosS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            /*En JS  se colocan 3 ===, diferente sería !==*/
            if (datos === 'true') {
                alert("Producto Agregado Exitosamente");
            } else {
                alert("Producto No Agregado");
            }
            /*Permite que se recargue automáticamente la tabla. Sin esto hay que 
             actualizar manualmente.*/
            document.getElementById('closeInsertar').click();
            readProductos();
        }
    });
}

function cargarDatosActualizar(id, ip, n, d, vc, vv, s, ti, tp) {
    /*Estos id salen del modal de actualizar*/
    document.getElementById('numIdUp').value = id;
    document.getElementById('numIpUp').value = ip;
    document.getElementById('txtNomUp').value = n;
    document.getElementById('txtDescripcionUp').value = d;
    document.getElementById('txtValComUp').value = vc;
    document.getElementById('txtValVenUp').value = vv;
    document.getElementById('txtStockUp').value = s;
    let selectIva = document.getElementById('txtIvaUp');
    if (ti === 'SI') {
        selectIva.options[0].selected = true;
    } else if (ti === 'NO') {
        selectIva.options[1].selected = true;
    }

    document.getElementById('txtTipoProdUp').value = tp;
}

function updateProductos() {
    /*Se coloca el evento onclick en el botón actualizar de 
     clientesVista*/
    let id = document.getElementById("numIdUp").value;
    let ip = document.getElementById('numIpUp').value;
    let n = document.getElementById("txtNomUp").value;
    let d = document.getElementById("txtDescripcionUp").value;
    let vc = document.getElementById("txtValComUp").value;
    let vv = document.getElementById("txtValVenUp").value;
    let s = document.getElementById("txtStockUp").value;
    let ti = document.getElementById("txtIvaUp").value;
    let tp = document.getElementById("txtTipoProdUp").value;

    $.ajax({
        data: {
            /*Tiene que ser igual al mètodo update de clientesServlet*/
            "crud": "up",
            "numId": id,
            "numIp": ip,
            "txtN": n,
            "txtD": d,
            "decVc": vc,
            "decVv": vv,
            "numS": s,
            "txtTi": ti,
            "txtTp": tp

        },
        url: "./ProductosS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            /*En JS  se colocan 3 ===, diferente sería !==*/
            if (datos === 'true') {
                alert("Producto Actualizado");
            } else {
                alert("Producto no Actualizado");
            }
            /*Permite que se recargue automáticamente la tabla. Sin esto hay que 
             actualizar manualmente.*/
            document.getElementById('closeUpdate').click();
            readProductos();
        }
    });
}

function cargarDatosEliminar(id) {
    document.getElementById('numInDel').value = id;
}

function eliminarProductos() {
    let id = document.getElementById('numInDel').value;

    $.ajax({
        data: {
            "crud": "del",
            "numId": id

        },
        url: "./ProductosS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            /*En JS  se colocan 3 ===, diferente sería !==*/
            if (datos === 'true') {
                alert("Producto Eliminado");
            } else {
                alert("Producto no Eliminado");
            }
            /*Permite que se recargue automáticamente la tabla. Sin esto hay que 
             actualizar manualmente.*/
            document.getElementById('closeDelete').click();
            readProductos();
        }
    });
}


