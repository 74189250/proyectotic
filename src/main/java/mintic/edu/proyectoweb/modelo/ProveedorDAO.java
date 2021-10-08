package mintic.edu.proyectoweb.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    Connection con = null; // Hacer la conexion a la BDs
    Conexion cn = new Conexion();
    Statement stm = null; // Separa el espacio para construir un comando SQL
    ResultSet res = null; // Guarda el resultado de la consulta
    PreparedStatement ps = null;

    public List<Proveedor> getProveedores() {

        String sql = "SELECT * FROM proveedor";
        List<Proveedor> proveedores = new ArrayList<>();
        try {
            con = cn.Conexion();
            stm = con.createStatement();
            res = stm.executeQuery(sql);
            while (res.next()) { // Recorrer todo el ResultSet
                Proveedor prov = new Proveedor();
                prov.setNit(res.getInt(1));
                prov.setNombreproveedor(res.getString(2));
                prov.setDireccion(res.getString(3));
                prov.setTelefono(res.getString(4));
                prov.setCiudad(res.getString(5));
                proveedores.add(prov);

            }
            stm.close(); // Cerrar toda la conexión a la BDs
            res.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        }
        return proveedores; // Devuelve el ArrayList clientes
    }

    public boolean agregarProveedor(Proveedor proveedor) {
        boolean registrar = false; // Permite identificar si ya existe el usuario
        boolean encontrado = false; // Encuentra un usuario con el correo Institucional
        String buscar = "SELECT * FROM provedores where nit = " // Instrucción sql
                + proveedor.getNit(); // Para buscar un registro con el mismo id
        encontrado = buscar(buscar); // Ejecutamos el método con la consulta
        if (!encontrado) {
            // La instrucción para insertar el registro
            String sql = "INSERT INTO proveedor values (" + proveedor.getNit()+ ",'" + proveedor.getNombreproveedor()
                    + "','" + proveedor.getDireccion() + "','" + proveedor.getTelefono() + "','"
                    + proveedor.getCiudad() + "')";
            try {
                con = cn.Conexion();
                stm = con.createStatement();
                stm.execute(sql);
                registrar = true;
                stm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Error: Clase ProveedoreDao, método agregarUsuario");
                e.printStackTrace();
            }
        }

        return registrar;
    }

    private boolean buscar(String sql) {
        boolean encontrado = false;
        con = cn.Conexion();
        try {
            stm = con.createStatement();
            res = stm.executeQuery(sql);
            while (res.next()) {
                encontrado = true;
            }
        } catch (SQLException e) {
            System.out.println("Mensaje:" + e.getMessage());
            System.out.println("Estado:" + e.getSQLState());
            System.out.println("Codigo del error:" + e.getErrorCode());
            System.out.println("Error: Clase ProveedorDao, método agregarcliente" + e.getMessage());
        }
        return encontrado;
    }

    public Proveedor getProveedorId(int id) {
        String sql = "SELECT * FROM proveedor WHERE nit=" + id;
        Proveedor prov = new Proveedor();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                prov.setNit(res.getInt(1));
                prov.setNombreproveedor(res.getString(2));
                prov.setDireccion(res.getString(3));
                prov.setTelefono(res.getString(4));
                prov.setCiudad(res.getString(5));
            }
            // cerramos el jdbc
            stm.close();
            res.close();
            con.close();
        } catch (SQLException er) {
            System.err.println("Error:" + er);
        }
        return prov;
    }

    public boolean actualizarProveedor(Proveedor proveedor) {
        boolean encontrado = false;
        boolean actualizar = false;
        String sql = "UPDATE proveedor SET nombreproveedor = '" + proveedor.getNombreproveedor()
                + "', direccion = '" + proveedor.getDireccion() + "', ciudad = '" + proveedor.getCiudad()
                + "', telefono = '" + proveedor.getTelefono() + "'"
                + " WHERE nit = " + proveedor.getNit();
        System.out.println("" + sql);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase CDao, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    public boolean eliminarProveedor(int id) {
        boolean encontrado = false;
        boolean eliminar = false;
        String buscar = "SELECT * FROM proveedor WHERE nit=" + id;
        encontrado = buscar(buscar);
        String sql = "DELETE FROM proveedor WHERE nit = " + id;
        if (encontrado) {
            try {
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                ps.executeUpdate(sql);
                eliminar = true;
            } catch (SQLException e) {
                System.out.println("Error: Clase EstudianteDao, método eliminar");
                e.printStackTrace();
            }
        }
        return eliminar;
    }

}


