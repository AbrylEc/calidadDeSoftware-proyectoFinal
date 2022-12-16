<%-- 
    Document   : ProductosVista
    Created on : 17 ago 2022, 14:33:09
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <!-- librería para los estilos -->
        <%@include file ="./librerias/Librerias.jsp"%>
    </head>
    <body style="background-color: #d9ffff">
        <div>
            <!-- cabecera y el menú -->
            <%@include file = "./librerias/header.jsp"%>
        </div>

        <div class="container" align="center">
            <h1 style="text-align: center">Productos</h1>
            <hr>
            <form>
                <table>
                    <tr>
                        <td>
                            <label>Buscar:</label>
                        </td>
                        <td>
                            <input type="text" class="form-control" id="buscar"/>
                        </td>                   
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button type="button" 
                                    class="btn btn-dark" 
                                    style="width: 85px; height: 40px"
                                    onclick="readProductos()">   
                                Buscar
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button type="button" 
                                    class="btn btn-info" 
                                    style="width: 85px; height: 40px"
                                    data-toggle="modal"
                                    data-target="#insertarProducto">
                                Insertar
                            </button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

        <br>

        <div class="container">
            <div id="tablaProductos">     
            </div>
        </div>

        <div>
            <!-- pie de página -->
        </div>

        <!-- The Modal Insertar-->
        <div class="modal fade" id="insertarProducto">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title"><strong>Insertar Productos</strong></h4>
                        <button type="button" 
                                class="close" 
                                data-dismiss="modal">
                            &times;
                        </button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body" align="center">
                        <form>
                            <table>
                                <tr>
                                    <td>
                                        <label>ID Proveedor:</label>
                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtIp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Nombre:</label>
                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtNom"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Descripción:</label>

                                    </td>
                                    <td>
                                        <textarea id="txtDescripcion" 
                                                  class="form-control"/>
                                        </textarea>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Valor compra:</label>

                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtValCom"/>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Valor venta:</label>

                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtValVen"/>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Stock:</label>

                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtStock"/>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>IVA:</label>

                                    </td>
                                    <td>
                                        <!--<input type="text" 
                                               class="form-control" 
                                               id="txtIva"/>-->

                                        <select id="txtIva">
                                            <option value="SI">SI</option>
                                            <option value="NO">NO</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Tipo de Producto:</label>

                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtTipoProd"/>

                                    </td>
                                </tr>
                                <tr>
                                    <td>                
                                    </td>
                                    <td>
                                        <button type="button" 
                                                class="btn btn-info"
                                                onclick="insertarProductos()">
                                            Insertar
                                        </button>                                       
                                    </td>
                                </tr>
                            </table>                             
                        </form>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" 
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
        <div class="modal fade" id="actualizarProducto">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title"><strong>Actualizar Productos</strong></h4>
                        <button type="button" 
                                class="close" 
                                data-dismiss="modal">
                            &times;
                        </button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body" align="center">
                        <form>
                            <table>
                                <tr>
                                    <td>
                                        <label>ID:</label>
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
                                        <label>ID Proveedor</label>
                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="numIpUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Nombre:</label>
                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtNomUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Descripción:</label>

                                    </td>
                                    <td>
                                        <textarea id="txtDescripcionUp" 
                                                  class="form-control"/>
                                        </textarea>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Valor compra:</label>

                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtValComUp"/>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Valor venta:</label>

                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtValVenUp"/>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Stock:</label>

                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtStockUp"/>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>IVA:</label>

                                    </td>
                                    <td>
                                        <!-- <input type="text" 
                                               class="form-control" 
                                               id="txtIvaUp"/>--> 

                                        <select id="txtIvaUp">
                                            <option value="SI">SI</option>
                                            <option value="NO">NO</option>
                                        </select>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Tipo de Producto:</label>

                                    </td>
                                    <td>
                                        <input type="text" 
                                               class="form-control" 
                                               id="txtTipoProdUp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>                
                                    </td>
                                    <td>
                                        <button type="button" 
                                                class="btn btn-info"
                                                onclick="updateProductos()">
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
        <div class="modal" id="eliminarProducto">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Eliminar Productos</h4>
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
                        <h3>¿Deseas eliminar este producto?</h3>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" 
                                class="btn btn-dark" 
                                onclick="eliminarProductos()">
                            Si
                        </button>
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

        <script src="./js/productosJs.js">
        </script>
    </body>
</html>
