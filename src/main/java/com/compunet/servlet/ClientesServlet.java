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

	private static final String TYPE_RESPONSE = "text/html";
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String menu = request.getParameter("crud");
		if (menu.equals("sel")) {
			// Read
			readClientes(request, response);
		} else if (menu.equals("up")) {
			updateClientes(request, response);
			// Update
		} else if (menu.equals("in")) {
			insertClientes(request, response);
			// insert
		} else if (menu.equals("del")) {
			// Delete
			deleteClientes(request, response);
		}

	}

	// CRUD
	private void deleteClientes(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType(TYPE_RESPONSE);
			PrintWriter pw = response.getWriter();
			int id = Integer.parseInt(request.getParameter("txtID"));
			Clientes c = new Clientes();
			boolean r = c.deleteClientes(id);
			pw.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readClientes(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType(TYPE_RESPONSE);
			PrintWriter pw = response.getWriter();
			String buscar = request.getParameter("txtBuscar");
			Clientes c = new Clientes();
			ResultSet r = c.selectClientes(buscar);
			StringBuilder tabla = new StringBuilder();
			tabla.append("<table class='table table-hover'>");
			String[] header = {"ID", "CÉDULA", "NOMBRE", "APELLIDO", "DIRECCIÓN", "TELÉFONO", "ACCIÓN"};
			String[] body = { "id_cli", "ci_cli", "nombre_cli", "apellido_cli", "direccion_cli", "telefono_cli" };
			
			tabla.append("<thead class='thead-dark'>");
			tabla.append("<tr>");
			for (int i = 0; i < header.length; i++) {
				tabla.append("<th>");
				tabla.append(header[i]);
				tabla.append("</th>");
			}
			tabla.append("</tr>") ;
			tabla.append("</thead>");
			tabla.append("<tbody>");
			while (r.next()) {
				tabla.append("<tr>");
				for (int i = 0; i < body.length; i++) {
					tabla.append("<td>" + body[i] + "</td>");
				}		
				tabla.append("<td>");
				tabla.append("<button type='button' class='btn btn-dark' data-toggle='modal' data-target='#actualizarCliente' onclick=\"cargarDatosActualizar('"
						+ r.getInt(body[0]) + "','" + r.getString("ci_cli") + "','" + r.getString("nombre_cli") + "','"
						+ r.getString("apellido_cli") + "','" + r.getString("direccion_cli") + "','"
						+ r.getString("telefono_cli") + "')\">Actualizar</button>");
				tabla.append("<button type='button' class='btn btn-info' data-toggle='modal' data-target='#eliminarCliente' onclick=\"cargarDatosEliminar('"
						+ r.getInt(body[0]) + "')\" >Eliminar</button>");
				tabla.append("</td>");
				tabla.append("</tr>");
			}
			tabla.append("</tbody>");
			tabla.append("</tabla>");
			pw.println(tabla);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void insertClientes(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType(TYPE_RESPONSE);
			PrintWriter pw = response.getWriter();
			String ci = request.getParameter("txtCi");
			String nom = request.getParameter("txtNom");
			String ape = request.getParameter("txtApe");
			String dir = request.getParameter("txtDir");
			String tel = request.getParameter("txtTel");
			Clientes c = new Clientes();
			boolean r = c.insertClientes(ci, nom, ape, dir, tel);
			pw.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateClientes(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType(TYPE_RESPONSE);
			PrintWriter pw = response.getWriter();
			int id = Integer.parseInt(request.getParameter("numId"));
			String ci = request.getParameter("txtCi");
			String nom = request.getParameter("txtNom");
			String ape = request.getParameter("txtApe");
			String dir = request.getParameter("txtDir");
			String tel = request.getParameter("txtTel");
			Clientes c = new Clientes();
			boolean r = c.updateClientes(id, ci, nom, ape, dir, tel);
			pw.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
