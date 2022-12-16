package com.compunet.acceso;

import com.compunet.modelo.CBDD;

import lombok.Data;

import java.sql.ResultSet;

@Data
public class Proveedores {

    private int idProveedores;
    private String rucProveedores;
    private String nombreProveedores;
    private String direccionProveedores;
    private String telefonoProveedores;
    private String buscar;
    private CBDD c;
    
    public boolean insertProveedores(String r, String n, String d, String t) { // nnombre, ruc, contacto, direccion       
        setRucProveedores(r);
        setNombreProveedores(n);
        setDireccionProveedores(d);
        setTelefonoProveedores(t);
        String sql = "INSERT INTO `proveedores`"
                + "(`ruc_prov`, `nombre_prov`, `direccion_prov`, "
                + "`telefono_prov`) "
                + "VALUES "
                + "('" + getRucProveedores() + "',"
                + "'" + getNombreProveedores() + "',"
                + "'" + getDireccionProveedores() + "',"
                + "'" + getTelefonoProveedores() + "')";
        return this.c.ejecutar(sql);
    }

    public boolean deleteProveedores(int id) {
        setIdProveedores(id);
        String sql = "DELETE FROM `proveedores`\n"
                + "WHERE `id_prov` =" + getIdProveedores();
        return c.ejecutar(sql);
    }

    public boolean updateProveedores(int id, String r, String n, String d, String t) {
        setIdProveedores(id);
        setRucProveedores(r);
        setNombreProveedores(n);
        setDireccionProveedores(d);
        setTelefonoProveedores(t);
        String sql = "UPDATE `proveedores` SET `ruc_prov`='" + getRucProveedores() + "',\n"
                + "`nombre_prov`='" + getNombreProveedores() + "',\n"
                + "`direccion_prov`='" + getDireccionProveedores() + "',\n"
                + "`telefono_prov`='" + getTelefonoProveedores() + "'\n"
                + "WHERE `id_prov`=" + getIdProveedores();
        return this.c.ejecutar(sql);
    }

    public ResultSet selectProveedores(String b) {
        setBuscar(b);
        String sql = "SELECT * FROM `proveedores`\n"
                + "WHERE `nombre_prov` like '%" + getBuscar() + "%'\n"
                + "or `ruc_prov` like '%" + getBuscar() + "%'";
        return c.consulta(sql);
    }

}
