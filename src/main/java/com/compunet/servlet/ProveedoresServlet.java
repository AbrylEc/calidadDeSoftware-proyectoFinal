
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

	/**
	* 
	*/
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
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			int id = Integer.parseInt(request.getParameter("txtID"));
			Proveedores p = new Proveedores();
			boolean r = p.deleteProveedores(id);
			pw.println(r);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private void readProveedores(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			String buscar = request.getParameter("txtBuscar");
			Proveedores p = new Proveedores();
			ResultSet r = p.selectProveedores(buscar);
			String tabla = "<table class='table table-hover'>";
			tabla += "<thead class='thead-dark'>";
			tabla += "<tr>";
			tabla += "<th>ID";
			tabla += "</th>";
			tabla += "<th>RUC";
			tabla += "</th>";
			tabla += "<th>NOMBRE";
			tabla += "</th>";
			tabla += "<th>DIRECCIÓN";
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
				tabla += "<td>" + r.getInt("id_prov");
				tabla += "</td>";
				tabla += "<td>" + r.getString("ruc_prov");
				tabla += "</td>";
				tabla += "<td>" + r.getString("nombre_prov");
				tabla += "</td>";
				tabla += "<td>" + r.getString("direccion_prov");
				tabla += "</td>";
				tabla += "<td>" + r.getString("telefono_prov");
				tabla += "</td>";
				tabla += "<td>";
				tabla += "<button type='button' class='btn btn-dark' data-toggle='modal' data-target='#actualizarProveedor' onclick=\"cargarDatosActualizar('"
						+ r.getInt("id_prov") + "','" + r.getString("ruc_prov") + "','" + r.getString("nombre_prov")
						+ "','" + r.getString("direccion_prov") + "','" + r.getString("telefono_prov")
						+ "')\">Actualizar</button>";
				tabla += "<button type='button' class='btn btn-info' data-toggle='modal' data-target='#eliminarProveedor' onclick=\"cargarDatosEliminar('"
						+ r.getInt("id_prov") + "')\" >Eliminar</button>";
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

	private void insertProveedores(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html");
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
			response.setContentType("text/html");
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
