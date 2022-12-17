
package com.compunet.servlet;

import com.compunet.acceso.Proveedores;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Proveedores", urlPatterns = "/ProveedoresS")
public class ProveedoresServlet extends HttpServlet {

	private static final String TYPE_RESPONSE = "text/html";
	private static final long serialVersionUID = 1L;

	// Método GET
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String menu = request.getParameter("crud");
		if (menu.equals("sel")) {
			// Read
			readProveedores(request, response);
		} else if (menu.equals("up")) {
			updateProveedores(request, response);
			// Update
		} else if (menu.equals("in")) {
			insertProveedores(request, response);
			// insert
		} else if (menu.equals("del")) {
			// Delete
			deleteProveedores(request, response);
		}
	}

	// CRUD
	private void deleteProveedores(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType(TYPE_RESPONSE);
			PrintWriter pw = response.getWriter();
			int id = Integer.parseInt(request.getParameter("txtID"));
			Proveedores p = new Proveedores();
			boolean r = p.deleteProveedores(id);
			pw.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readProveedores(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType(TYPE_RESPONSE);
			PrintWriter pw = response.getWriter();
			String buscar = request.getParameter("txtBuscar");
			Proveedores p = new Proveedores();
			ResultSet r = p.selectProveedores(buscar);
			StringBuilder tabla = new StringBuilder();
			tabla.append("<table class='table table-hover'>");
			String[] header = { "ID", "RUC", "NOMBRE", "DIRECCIÓN", "TELÉFONO", "ACCIÓN" };
			String[] body = { "id_prov", "ruc_prov", "nombre_prov", "direccion_prov", "telefono_prov" };

			tabla.append("<thead class='thead-dark'>");
			tabla.append("<tr>");
			for (int i = 0; i < header.length; i++) {
				tabla.append("<th>");
				tabla.append(header[i]);
				tabla.append("</th>");
			}
			tabla.append("</tr>");
			tabla.append("</thead>");
			tabla.append("<tbody>");
			while (r.next()) {
				tabla.append("<tr>");
				for (int i = 0; i < body.length; i++) {
					tabla.append("<td>" + body[i] + "</td>");
				}
				tabla.append("<td>");
				tabla.append(
						"<button type='button' class='btn btn-dark' data-toggle='modal' data-target='#actualizarProveedor' onclick=\"cargarDatosActualizar('"
								+ r.getInt(body[0]) + "','" + r.getString("ruc_prov") + "','"
								+ r.getString("nombre_prov") + "','" + r.getString("direccion_prov") + "','"
								+ r.getString("telefono_prov") + "')\">Actualizar</button>");
				tabla.append(
						"<button type='button' class='btn btn-info' data-toggle='modal' data-target='#eliminarProveedor' onclick=\"cargarDatosEliminar('"
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

	private void insertProveedores(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType(TYPE_RESPONSE);
			PrintWriter pw = response.getWriter();
			String ruc = request.getParameter("txtRuc");
			String nom = request.getParameter("txtNom");
			String dir = request.getParameter("txtDir");
			String tel = request.getParameter("txtTel");
			Proveedores p = new Proveedores();
			boolean r = p.insertProveedores(ruc, nom, dir, tel);
			pw.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateProveedores(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType(TYPE_RESPONSE);
			PrintWriter pw = response.getWriter();
			int id = Integer.parseInt(request.getParameter("numId"));
			String ruc = request.getParameter("txtRuc");
			String nom = request.getParameter("txtNom");
			String dir = request.getParameter("txtDir");
			String tel = request.getParameter("txtTel");
			Proveedores p = new Proveedores();
			boolean r = p.updateProveedores(id, ruc, nom, dir, tel);
			pw.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
