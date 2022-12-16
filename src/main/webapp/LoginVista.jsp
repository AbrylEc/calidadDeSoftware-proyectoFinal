<%-- 
    Document   : LoginVista
    Created on : 17 ago 2022, 14:32:23
    Author     : USER
--%>

<!-- Lenguaje jsp (java) -->
<%  
    HttpSession sesion = request.getSession();
    sesion.setAttribute("estado", "0");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <script src='./js/UsuariosJs.js'></script>
        <!-- librería para los estilos -->
        <%@include file ="./librerias/Librerias.jsp"%>
    </head>
    <body style="background-color: #d9ffff">
        <div class="container" align = 'center'>
            <h1>Login</h1>
            <form>
                <table>
                    <tr>
                        <td>
                            <label>Usuario: </label>
                        </td>
                        <td>
                            <input type='text' id='txtUsuario'/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Clave: </label>
                        </td>
                        <td>
                            <input type='password' id='txtClave'/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            <button class='btn btn-dark'
                                    type='button'
                                    onclick='verificarUsuario()'>Iniciar Sesión
                            </button>
                        </td>
                    </tr>
                </table>
            </form>

        </div>
    </body>
</html>
