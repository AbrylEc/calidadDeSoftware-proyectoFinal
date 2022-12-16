
package com.compunet.servlet;

import com.compunet.acceso.Usuarios;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UsuariosS", urlPatterns = "/UsuariosS")
public class UsuariosServlet extends HttpServlet {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		verificarUsuarios(request, response);
	}

	private void verificarUsuarios(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			String usuario = request.getParameter("txtUsuario");
			String clave = request.getParameter("txtClave");
			Usuarios u = new Usuarios();
			ResultSet r = u.verificarUsuario(usuario, clave);
			int cont = 0;

			/* La siguiente línea está almacenando la sesión del proyecto */
			HttpSession sesion = request.getSession();
			while (r.next()) {
				sesion.setAttribute("usuario", r.getString("usuario_u"));
				sesion.setAttribute("perfil", r.getString("rol_u"));
				cont++;
			}

			if (cont > 0) {
				pw.println("true");
				sesion.setAttribute("estado", "1");
			} else {
				pw.println("false");
				sesion.setAttribute("estado", "0");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
