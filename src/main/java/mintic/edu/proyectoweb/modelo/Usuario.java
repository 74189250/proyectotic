
package mintic.edu.proyectoweb.modelo;


public class Usuario {
     private int idUsuario;
    private String nombreUsuario;
     private String correo;
     private String nombreCompleto;
    private String clave;
    private String tipoUsuario;

    public Usuario() {
        
    }

    public Usuario(int idUsuario, String nombreUsuario, String correo, String nombreCompleto, String clave, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.nombreCompleto = nombreCompleto;
        this.clave = clave;
        this.tipoUsuario = tipoUsuario;
        
        
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
