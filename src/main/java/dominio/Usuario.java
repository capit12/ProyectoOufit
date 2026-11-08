package dominio;

import util.Validador;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String correo;
    private String contrasenia;
    private PerfilUsuario perfil;

    public Usuario() {
        this.idUsuario = 0;
        this.nombre = "Sin Nombre";
        this.correo = "sin@correo.com";
        this.contrasenia = "1234";
        this.perfil = null;
    }

    public Usuario(int idUsuario, String nombre, String correo, String contrasenia) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        setCorreo(correo); // Usa el setter para validar
        this.contrasenia = contrasenia;
    }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if(Validador.validarCaracteres(nombre)) this.nombre = nombre;
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) {
        if(Validador.validarCorreo(correo)) {
            this.correo = correo;
        } else {
            this.correo = "correo.invalido@uce.edu.ec";
        }
    }

    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) {
        if(Validador.validarContrasenia(contrasenia)) this.contrasenia = contrasenia;
    }

    public PerfilUsuario getPerfil() { return perfil; }
    public void setPerfil(PerfilUsuario perfil) { this.perfil = perfil; }

    public void crearCuenta() { System.out.println("[RESULTADO]: Cuenta de usuario guardada."); }
    public boolean iniciarSesion() { return true; }
    public void eliminarCuenta() { System.out.println("[RESULTADO]: Cuenta eliminada del sistema."); }
}