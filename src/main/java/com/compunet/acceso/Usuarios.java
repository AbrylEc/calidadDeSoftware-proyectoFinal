package com.compunet.acceso;

import com.compunet.modelo.CBDD;

import lombok.Data;

import java.sql.ResultSet;

@Data
public class Usuarios {

	private int idUsuarios;
	private String usuarioUsuarios;
	private String claveUsuarios;
	private String rolUsuarios;
	private String buscarUsuarios;
	private CBDD c;

	public ResultSet verificarUsuario(String usuario, String clave) {
		setUsuarioUsuarios(usuario);
		setClaveUsuarios(clave);
		String sql = "SELECT * FROM `usuario`\n" + "WHERE `usuario_u` = '" + getUsuarioUsuarios() + "'\n"
				+ "and `clave_u` = SHA1('" + getClaveUsuarios() + "')";
		return c.consulta(sql);
	}
}
