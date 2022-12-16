package com.compunet.acceso;

import com.compunet.modelo.CBDD;

import lombok.Data;

import java.sql.ResultSet;

@Data

public class Productos {

    private int idProductos;
    private int idProveedoresProductos;
    private String nombreProductos;
    private String descripcionProductos;
    private double valorRefCompProductos;
    private double valorRefVentaProductos;
    private int stockProductos;
    private String tieneIvaProductos;
    private String tipoProductos;
    private String buscar;
    private CBDD c;

    public boolean insertProductos(int ip, String n, String d, double vc, double vv, int s, String ti, String tp) { // nnombre, ruc, contacto, dir3eccion

        setIdProveedoresProductos(ip);
        setNombreProductos(n);
        setDescripcionProductos(d);
        setValorRefCompProductos(vc);
        setValorRefVentaProductos(vv);
        setStockProductos(s);
        setTieneIvaProductos(ti);
        setTipoProductos(tp);
        String sql = "INSERT INTO `productos`"
                + "(`IdProveedores_prod`, `nombre_prod`, `descripcion_prod`, `valorRefComp_prod`, "
                + "`valorRefVenta_prod`, `stock_prod`, `tieneIva_prod`, tipo_prod) "
                + "VALUES "
                + "('" + getIdProveedoresProductos() + "',"
                + "'" + getNombreProductos() + "',"
                + "'" + getDescripcionProductos() + "',"
                + "'" + getValorRefCompProductos() + "',"
                + "'" + getValorRefVentaProductos() + "',"
                + "'" + getStockProductos() + "',"
                + "'" + getTieneIvaProductos() + "',"
                + "'" + getTipoProductos() + "')";

        return this.c.ejecutar(sql);
    }

    public boolean deleteProductos(int id) {
        setIdProductos(id);
        String sql = "DELETE FROM `productos`\n"
                + "WHERE `id_prod` =" + getIdProductos();
        return c.ejecutar(sql);
    }

    public boolean updateProductos(int id, int ip, String n, String d, double vc, double vv, int s, String ti, String tp) {
        setIdProductos(id);
        setIdProveedoresProductos(ip);
        setNombreProductos(n);
        setDescripcionProductos(d);
        setValorRefCompProductos(vc);
        setValorRefVentaProductos(vv);
        setStockProductos(s);
        setTieneIvaProductos(ti);
        setTipoProductos(tp);
        String sql = "UPDATE `productos` SET `idProveedores_prod`='" + getIdProveedoresProductos() + "',\n"
                + "`idProveedores_prod`='" + getIdProveedoresProductos() + "',\n"
                + "`descripcion_prod`='" + getDescripcionProductos() + "',\n"
                + "`valorRefComp_prod`=" + getValorRefCompProductos() + ",\n"
                + "`valorRefVenta_prod`=" + getValorRefVentaProductos() + ",\n"
                + "`stock_prod`=" + getStockProductos() + ",\n"
                + "`tieneIva_prod`='" + getTieneIvaProductos() + "',\n"
                + "`tipo_prod`='" + getTipoProductos() + "'\n"
                + "WHERE `id_prod`=" + getIdProductos();
        return this.c.ejecutar(sql);
    }

    public ResultSet selectProductos(String b) {
        setBuscar(b);
        String sql = "SELECT * FROM `productos`\n"
                + "WHERE `nombre_prod` like '%" + getBuscar() + "%'\n"
                + "or `descripcion_prod` like '%" + getBuscar() + "%'";
        return c.consulta(sql);
    }

}
