<%-- 
    Document   : ProveedoresVista
    Created on : 17 ago 2022, 14:33:32
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proveedores</title>
        <!-- librería para los estilos -->
        <%@include file ="./librerias/Librerias.jsp"%>
    </head>
    <body style="background-color: #d9ffff">
        <div>
            <!-- cabecera y el menu -->
            <%@include file = "./librerias/header.jsp" %>
        </div>
        <div class="container" align="center">
            <h1 style="text-align: center">Proveedores</h1>
            <hr>
            <form>
                <table>
                    <tr>
                        <td>
                            <label>Buscar:</label> 
                        </td>
                        <td>
                            <input type="text" class="form-control" id="buscar" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button 
                                type="button" 
                                class="btn btn-dark" 
                                style="width: 85px;height: 40px"
                                onclick="readProveedores()">
                                Buscar
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button type="button" 
                                    class="btn btn-info" 
                                    style="width: 85px;height: 40px"
                                    data-toggle="modal" 
                                    data-target="#insertarProveedor">
                                Insertar
                            </button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

        <br>

        <div class="container">
            <div id="tablaProveedores">
            </div>
        </div>

        <div>
            <!-- pie de pagina -->
        </div>

        <!-- The Modal Insertar-->
        <div class="modal" id="insertarProveedor">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Insertar Proveedores</h4>
                        <button type="button" 
                                class="close" 
                                data-dismiss="modal">
                            &times;
                        </button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body" align="center" >
                        <form>
                            <table>                           
                                <tr>
                                    <td>
                                        <label>RUC: </label>
                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtRuc"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Nombre: </label>
                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtNom"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Dirección: </label>
                                    </td>
                                    <td>
                                        <textarea id="txtDir" 
                                                  class="form-control"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Teléfono: </label>
                                    </td>
                                    <td>
                                        <input type="text" 
                                               id="txtTel" 
                                               class="form-control"/>
                                    </td>
                                </tr>                 
                                <tr>
                                    <td>
                                    </td>
                                    <td>
                                        <button type="button" 
                                                class="btn btn-info" 
                                                onclick="insertarProveedores()">Insertar</button>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button 
                            type="button" 
                            class="btn btn-dark" 
                            data-dismiss="modal" 
                            id="closeInsertar">
                            Cerrar
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <!-- The Modal Actualizar-->
        <div class="modal" id="actualizarProveedor">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Actualizar Proveedores</h4>
                        <button 
                            type="button" 
                            class="close" 
                            data-dismiss="modal">&times;
                        </button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body" align="center" >
                        <form>
                            <table>
                                <tr>
                                    <td>
                                        <label>ID: </label>
                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="numIdUp" 
                                               readonly=""/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>RUC: </label>
                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtRucUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Nombre: </label>
                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtNomUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Dirección: </label>
                                    </td>
                                    <td>
                                        <textarea id="txtDirUp" 
                                                  class="form-control"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Teléfono: </label>
                                    </td>
                                    <td>
                                        <input type="text" 
                                               id="txtTelUp" 
                                               class="form-control"/>
                                    </td>
                                </tr>                
                                <tr>
                                    <td>
                                    </td>
                                    <td>
                                        <button type="button" 
                                                class="btn btn-info" 
                                                onclick="updateProveedores()">
                                            Actualizar
                                        </button>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button 
                            type="button" 
                            class="btn btn-dark" 
                            data-dismiss="modal" 
                            id="closeUpdate">
                            Cerrar
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal Eliminar -->
        <div class="modal" id="eliminarProveedor">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Eliminar Proveedores</h4>
                        <button type="button" 
                                class="close" 
                                data-dismiss="modal">
                            &times;
                        </button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body" align="center" >
                        <input type="hidden" 
                               id="numInDel" 
                               readonly=""/>
                        <h3>¿Deseas eliminar este registro?</h3>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" 
                                class="btn btn-dark" 
                                onclick="eliminarProveedores()">Si</button>
                        <button type="button" 
                                class="btn btn-info" 
                                data-dismiss="modal" 
                                id="closeDelete">
                            No
                        </button>
                    </div>

                </div>
            </div>
        </div>

        <script src="./js/proveedoresJs.js"></script>
    </body>
</html>
