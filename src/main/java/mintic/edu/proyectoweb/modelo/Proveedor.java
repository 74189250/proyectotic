package mintic.edu.proyectoweb.modelo;

public class Proveedor {

    private int nit;
    private String nombreproveedor;
    private String direccion;
    private String telefono;
    private String ciudad;

    public Proveedor() {
    }

    public Proveedor(int nit, String nombreproveedor, String direccion, String telefono, String ciudad) {
        this.nit = nit;
        this.nombreproveedor = nombreproveedor;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombreproveedor() {
        return nombreproveedor;
    }

    public void setNombreproveedor(String nombreproveedor) {
        this.nombreproveedor = nombreproveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "nit=" + nit + ", nombreproveedor=" + nombreproveedor + ", direccion=" + direccion + ", telefono=" + telefono + ", ciudad=" + ciudad + '}';
    }

}
