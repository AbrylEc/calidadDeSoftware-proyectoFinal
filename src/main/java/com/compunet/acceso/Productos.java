package com.compunet.acceso;

import com.compunet.modelo.CBDD;

import lombok.Data;

import java.sql.ResultSet;
import java.util.List;

@Data

public class Productos {

	private int idProductos;
	private int idProveedoresProductos;
	private String nombreProductos;
	private double valorRefCompProductos;
	private double valorRefVentaProductos;
	private int stockProductos;
	private String tieneIvaProductos;
	private String buscar;
	private CBDD c;

	public boolean insertProductos(int ip, String n, double vc, double vv, int s, String ti) {

		setIdProveedoresProductos(ip);
		setNombreProductos(n);
		setValorRefCompProductos(vc);
		setValorRefVentaProductos(vv);
		setStockProductos(s);
		setTieneIvaProductos(ti);
		String sql = "INSERT INTO `productos`"
				+ "(`IdProveedores_prod`, `nombre_prod`, `descripcion_prod`, `valorRefComp_prod`, "
				+ "`valorRefVenta_prod`, `stock_prod`, `tieneIva_prod`, tipo_prod) " + "VALUES " + "('"
				+ getIdProveedoresProductos() + "'," + "'" + getNombreProductos() + "'," + "'"
				+ getValorRefCompProductos() + "'," + "'" + getValorRefVentaProductos() + "'," + "'"
				+ getStockProductos() + "'," + "'" + getTieneIvaProductos() + "')";

		return this.c.ejecutar(sql);
	}

	public boolean deleteProductos(int id) {
		setIdProductos(id);
		String sql = "DELETE FROM `productos`\n" + "WHERE `id_prod` =" + getIdProductos();
		return c.ejecutar(sql);
	}

	public boolean updateProductos(List<Object> data) {
		
		setIdProductos((Integer) data.get(0));
		setIdProveedoresProductos((Integer) data.get(1));
		setNombreProductos((String) data.get(2));
		setValorRefCompProductos((Double) data.get(3));
		setValorRefVentaProductos((Double) data.get(4));
		setStockProductos((Integer) data.get(5));
		setTieneIvaProductos((String) data.get(6));
		
		String sql = "UPDATE `productos` SET `idProveedores_prod`='" + getIdProveedoresProductos() + "',\n"
				+ "`idProveedores_prod`='" + getIdProveedoresProductos() + "',\n" + "`valorRefComp_prod`="
				+ getValorRefCompProductos() + ",\n" + "`valorRefVenta_prod`=" + getValorRefVentaProductos() + ",\n"
				+ "`stock_prod`=" + getStockProductos() + ",\n" + "`tipo_prod`='" + getTieneIvaProductos() + "'\n"
				+ "WHERE `id_prod`=" + getIdProductos();
		return this.c.ejecutar(sql);
	}

	public ResultSet selectProductos(String b) {
		setBuscar(b);
		String sql = "SELECT * FROM `productos`\n" + "WHERE `nombre_prod` like '%" + getBuscar() + "%'\n"
				+ "or `descripcion_prod` like '%" + getBuscar() + "%'";
		return c.consulta(sql);
	}

}
