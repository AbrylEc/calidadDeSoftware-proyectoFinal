package com.compunet.modelo;

import java.sql.Statement;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

@Data
public class CBDD {

	private Statement st;
	private String driver;
	private String user;
	private String clave;
	private String cadena;
	private Connection cnx;

	public CBDD() {
		this.driver = "com.mysql.cj.jdbc.Driver";
		this.user = "root";
		this.clave = "abril010992";
		this.cadena = "jdbc:mysql://localhost/compunet?useSSL=false";
		this.cnx = this.crearConexion();
	}

	private Connection crearConexion() {
		try {
			Class.forName(getDriver()).newInstance();
			return DriverManager.getConnection(getCadena(), getUser(), getClave());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Insert, Update, Delete
	public boolean ejecutar(String sql) {

		try {
			st = getCnx().createStatement();
			int r = st.executeUpdate(sql);
			if (r == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Select
	public ResultSet consulta(String sql) {
		ResultSet rs = null;
		try {
			st = getCnx().createStatement();
			rs = st.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

}
