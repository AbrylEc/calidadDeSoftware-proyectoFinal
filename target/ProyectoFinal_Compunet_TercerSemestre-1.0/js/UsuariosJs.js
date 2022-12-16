function verificarUsuario() {
    let u = document.getElementById('txtUsuario');
    let c = document.getElementById('txtClave');

    $.ajax({
        data: {
            "txtUsuario": u.value,
            "txtClave": c.value
        },
        url: "./UsuariosS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim(); //.trim: Elimina los espacios al inicio y al final de la cadena.
            if (datos === 'true'){
                window.location.href = "./MenuPrincipal.jsp";
            }else{
                window.location.href = "./Login.jsp";
            }
            //alert(datos);
        }
    });
}


