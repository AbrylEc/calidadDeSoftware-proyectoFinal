<%
   HttpSession sesion = request.getSession();
    String estado = sesion.getAttribute("estado").toString();
    
    if(estado.equals("0")){
        //regresar al Login.jsp
        response.sendRedirect("./LoginVista.jsp");
    }
%>

<div class="container">
    <div clas="row">
        <div class="col-md-8" align="center">
            ..:Logo de la empresa:..

        </div>
        <div class="com-md-4">
            <%
                out.println(sesion.getAttribute("usuario"));
            %>
            <br>
            <%
            out.println(sesion.getAttribute("perfil"));
            %>
            <!--  
             Nombre de usuario<br>
            Perfil de usuario<br>
            -->


            <a href="./LoginVista.jsp">Cerrar sesión</a>
        </div>
    </div>  
</div>
<div class="container">
    [07:34 a. m.]
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark"><!-- Brand -->
        <a class="navbar-brand" href="./MenuPrincipal.jsp">Logo</a><!-- Links -->
        <ul class="navbar-nav">
            <!-- Dropdown -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Ingreso
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="./ProductosVista.jsp">Productos</a>
                    <a class="dropdown-item" href="./ProveedoresVista.jsp">Proveedores</a>
                    <a class="dropdown-item" href="ClientesVista.jsp">Clientes</a>
                </div>
            </li>
        </ul>
    </nav>
</div>
