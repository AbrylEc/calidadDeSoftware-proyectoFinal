package com.compunet.servlet;

import com.compunet.acceso.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClientesS", urlPatterns = "/ClientesS")
public class ClientesServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("crud");
        if (menu.equals("sel")) {
            //Read  
            readClientes(request, response);
        } else if (menu.equals("up")) {
            updateClientes(request, response);
            //Update
        } else if (menu.equals("in")) {
            insertClientes(request, response);
            //insert
        } else if (menu.equals("del")) {
            //Delete
            deleteClientes(request, response);
        }

    }

    //CRUD
    private void deleteClientes(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            int id = Integer.parseInt(request.getParameter("txtID"));
            Clientes c = new Clientes();
            boolean r = c.deleteClientes(id);
            pw.println(r);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void readClientes(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            String buscar = request.getParameter("txtBuscar");
            Clientes c = new Clientes();
            ResultSet r = c.selectClientes(buscar);
            String tabla = "<table class='table table-hover'>";
            tabla += "<thead class='thead-dark'>";
            tabla += "<tr>";
            tabla += "<th>ID";
            tabla += "</th>";
            tabla += "<th>CÉDULA";
            tabla += "</th>";
            tabla += "<th>NÚMERO DE CUENTA";
            tabla += "</th>";
            tabla += "<th>SALDO";
            tabla += "</th>";
            tabla += "<th>NOMBRE";
            tabla += "</th>";
            tabla += "<th>APELLIDO";
            tabla += "</th>";
            tabla += "<th>DIRECCION";
            tabla += "</th>";
            tabla += "<th>TELÉFONO";
            tabla += "</th>";
            tabla += "<th>ACCIÓN";
            tabla += "</th>";
            tabla += "</tr>";
            tabla += "</thead>";
            tabla += "<tbody>";
            while (r.next()) {
                tabla += "<tr>";
                tabla += "<td>" + r.getInt("id_cli");
                tabla += "</td>";
                tabla += "<td>" + r.getString("ci_cli");
                tabla += "</td>";
                tabla += "<td>" + r.getString("numeroDeCuenta_cli");
                tabla += "</td>";
                tabla += "<td>" + r.getString("saldo_cli");
                tabla += "</td>";
                tabla += "<td>" + r.getString("nombre_cli");
                tabla += "</td>";
                tabla += "<td>" + r.getString("apellido_cli");
                tabla += "</td>";
                tabla += "<td>" + r.getString("direccion_cli");
                tabla += "</td>";
                tabla += "<td>" + r.getString("telefono_cli");
                tabla += "</td>";
                tabla += "<td>";
                tabla += "<button type='button' class='btn btn-dark' data-toggle='modal' data-target='#actualizarCliente' onclick=\"cargarDatosActualizar('" + r.getInt("id_cli") + "','" + r.getString("ci_cli") + "','" + r.getString("numeroDeCuenta_cli") + "','" + r.getString("saldo_cli") + "','" + r.getString("nombre_cli") + "','" + r.getString("apellido_cli") + "','" + r.getString("direccion_cli") + "','" + r.getString("telefono_cli") + "')\">Actualizar</button>";
                tabla += "<button type='button' class='btn btn-info' data-toggle='modal' data-target='#eliminarCliente' onclick=\"cargarDatosEliminar('" + r.getInt("id_cli") + "')\" >Eliminar</button>";
                tabla += "</td>";
                tabla += "</tr>";
            }
            tabla += "</tbody>";
            tabla += "</tabla>";
            pw.println(tabla);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertClientes(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            String ci = request.getParameter("txtCi");
            String ndc = request.getParameter("txtNdc");
            String saldo = request.getParameter("txtSaldo");
            String nom = request.getParameter("txtNom");
            String ape = request.getParameter("txtApe");
            String dir = request.getParameter("txtDir");
            String tel = request.getParameter("txtTel");
            Clientes c = new Clientes();
            boolean r = c.insertClientes(ci, ndc, saldo, nom, ape, dir, tel);
            pw.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateClientes(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            int id = Integer.parseInt(request.getParameter("numId"));
            String ci = request.getParameter("txtCi");
            String ndc = request.getParameter("txtNdc");
            String saldo = request.getParameter("txtSaldo");
            String nom = request.getParameter("txtNom");
            String ape = request.getParameter("txtApe");
            String dir = request.getParameter("txtDir");
            String tel = request.getParameter("txtTel");
            Clientes c = new Clientes();
            boolean r = c.updateClientes(id, ci, ndc, saldo, nom, ape, dir, tel);
            pw.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
