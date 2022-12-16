package com.compunet.acceso;

import com.compunet.modelo.CBDD;

import lombok.Data;

import java.sql.ResultSet;

@Data
public class Clientes {

    private int idClientes;
    private String ciClientes;
    private String numeroDeCuentaClientes;
    private String saldoClientes;
    private String nombreClientes;
    private String apellidoClientes;
    private String direccionClientes;
    private String telefonoClientes;
    private String buscar;
    private CBDD c;

    public boolean insertClientes(String ci, String nc, String s, String n, String a, String d, String t) { // nnombre, ruc, contacto, direccion
        setCiClientes(ci);
        setNumeroDeCuentaClientes(nc);
        setSaldoClientes(s);
        setNombreClientes(n);
        setApellidoClientes(a);
        setDireccionClientes(d);
        setTelefonoClientes(t);
        String sql = "INSERT INTO `clientes`"
                + "(`ci_cli`, `numeroDeCuenta_cli`, `saldo_cli`, `nombre_cli`, "
                + "`apellido_cli`, `direccion_cli`, `telefono_cli`) "
                + "VALUES "
                + "('" + getCiClientes() + "',"
                + "'" + getNumeroDeCuentaClientes() + "',"
                + "'" + getSaldoClientes() + "',"
                + "'" + getNombreClientes() + "',"
                + "'" + getApellidoClientes() + "',"
                + "'" + getDireccionClientes() + "',"
                + "'" + getTelefonoClientes() + "')";
        return this.c.ejecutar(sql);
    }

    public boolean deleteClientes(int id) {
        setIdClientes(id);
        String sql = "DELETE FROM `clientes`\n"
                + "WHERE `id_cli` =" + getIdClientes();
        return c.ejecutar(sql);
    }

    public boolean updateClientes(int id, String ci, String nc, String s, String n, String a, String d, String t) {
        setIdClientes(id);
        setCiClientes(ci);
        setNumeroDeCuentaClientes(nc);
        setSaldoClientes(s);
        setNombreClientes(n);
        setApellidoClientes(a);
        setDireccionClientes(d);
        setTelefonoClientes(t);
        String sql = "UPDATE `clientes` SET `ci_cli`='" + getCiClientes() + "',\n"
                + "`numeroDeCuenta_cli`='" + getNumeroDeCuentaClientes() + "',\n"
                + "`saldo_cli`='" + getSaldoClientes() + "',\n"
                  + "`nombre_cli`='" + getNombreClientes() + "',\n"
                  + "`apellido_cli`='" + getApellidoClientes() + "',\n"
                  + "`direccion_cli`='" + getDireccionClientes() + "',\n"
                + "`telefono_cli`='" + getTelefonoClientes() + "'\n"
                + "WHERE `id_cli`=" + getIdClientes();
        return this.c.ejecutar(sql);
    }

    public ResultSet selectClientes(String b) {
        setBuscar(b);
        String sql = "SELECT * FROM `clientes`\n"
                + "WHERE `nombre_cli` like '%" + getBuscar() + "%'\n"
                + "or `ci_cli` like '%" + getBuscar() + "%'";
        return c.consulta(sql);
    }
}
