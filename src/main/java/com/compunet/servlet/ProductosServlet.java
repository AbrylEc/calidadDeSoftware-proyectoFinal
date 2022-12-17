package com.compunet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.compunet.acceso.Productos;

@WebServlet(name = "ProductosS", urlPatterns = "/ProductosS")
public class ProductosServlet extends HttpServlet {

	private static final String TYPE_RESPONSE = "text/html";
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String menu = request.getParameter("crud");
		if (menu.equals("sel")) {
			// read
			readProductos(request, response);
		} else if (menu.equals("up")) {
			// update
			updateProductos(request, response);
		} else if (menu.equals("in")) {
			// Insert
			insertProductos(request, response);
		} else if (menu.equals("del")) {
			// delete
			deleteProductos(request, response);
		}
	}

	// CRUD
	private void deleteProductos(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType(TYPE_RESPONSE);
			PrintWriter pw = response.getWriter();
			int id = Integer.parseInt(request.getParameter("numId"));
			Productos p = new Productos();
			boolean r = p.deleteProductos(id);
			pw.println(r);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	private void readProductos(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType(TYPE_RESPONSE);
			PrintWriter pw = response.getWriter();
			String buscar = request.getParameter("txtBuscar");
			Productos c = new Productos();
			ResultSet r = c.selectProductos(buscar);
			StringBuilder tabla = new StringBuilder();
			tabla.append("<table class='table table-hover'>");
			String[] header = { "ID PRODUCTO", "ID PROVEEDOR", "NOMBRE", "VALOR COMPRA", "VALOR VENTA", "STOCK", "IVA",
					"ACCIÓN" };
			String[] body = { "id_prod", "idProveedores_prod", "nombre_prod", "valorRefComp_prod", "valorRefVenta_prod",
					"stock_prod", "tieneIva_prod" };

			tabla.append("<thead class='thead-dark' style='text-align: center'>");
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
						"<button type='button' class='btn btn-dark' data-toggle='modal' data-target='#actualizarProducto' onclick=\"cargarDatosActualizar('"
								+ r.getInt(body[0]) + "','" + r.getInt("idProveedores_prod") + "','"
								+ r.getString("descripcion_prod") + "','" + r.getDouble("valorRefComp_prod") + "','"
								+ r.getDouble("valorRefVenta_prod") + "','" + r.getInt("stock_prod") + "','"
								+ r.getString("tieneIva_prod") + "')\">Actualizar</button>");
				tabla.append(
						"<button type='button' class='btn btn-info'data-toggle='modal' data-target='#eliminarProducto' onclick=\"cargarDatosEliminar('"
								+ r.getInt("body[0]") + "')\" >Eliminar</button>");
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

	private void insertProductos(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType(TYPE_RESPONSE);
			PrintWriter pw = response.getWriter();
			int ip = Integer.parseInt(request.getParameter("numIp"));
			String n = request.getParameter("txtN");
			double vc = Double.parseDouble(request.getParameter("decVc"));
			double vv = Double.parseDouble(request.getParameter("decVv"));
			int s = Integer.parseInt(request.getParameter("numS"));
			String ti = request.getParameter("txtTi");
			Productos p = new Productos();
			boolean r = p.insertProductos(ip, n, vc, vv, s, ti);
			pw.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateProductos(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType(TYPE_RESPONSE);
			PrintWriter pw = response.getWriter();
			Integer id = Integer.parseInt(request.getParameter("numId"));
			Integer ip = Integer.parseInt(request.getParameter("numIp"));
			String n = request.getParameter("txtN");
			Double vc = Double.parseDouble(request.getParameter("decVc"));
			Double vv = Double.parseDouble(request.getParameter("decVv"));
			Integer s = Integer.parseInt(request.getParameter("numS"));
			String ti = request.getParameter("txtTi");
			Productos p = new Productos();
			ArrayList<Object> updateData = new ArrayList<>();
			updateData.add(id);
			updateData.add(ip);
			updateData.add(n);
			updateData.add(vc);
			updateData.add(vv);
			updateData.add(s);
			updateData.add(ti);
			boolean r = p.updateProductos(updateData);
			pw.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
