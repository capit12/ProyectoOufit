package dominio;

import util.Validador;

public class PerfilUsuario {
    private int idPerfil;
    private String estiloPreferido;
    private String talla;
    private String ciudadUbicacion;

    public PerfilUsuario() {
        this.idPerfil = 0;
        this.estiloPreferido = "Casual";
        this.talla = "M";
        this.ciudadUbicacion = "Quito";
    }

    public PerfilUsuario(int idPerfil, String estiloPreferido, String talla, String ciudadUbicacion) {
        this.idPerfil = idPerfil;
        this.estiloPreferido = estiloPreferido;
        this.talla = talla;
        this.ciudadUbicacion = ciudadUbicacion;
    }

    //GETEERS Y SETTERS
    public int getIdPerfil() {
        return idPerfil;
    }
    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getEstiloPreferido() {
        return estiloPreferido;
    }
    public void setEstiloPreferido(String estiloPreferido) {
        if(Validador.validarEstilo(estiloPreferido)) {
            this.estiloPreferido = estiloPreferido;
        }
    }

    public String getTalla() {
        return talla;
    }
    public void setTalla(String talla) {
        if(Validador.validarTalla(talla)) {
            this.talla = talla.toUpperCase();
        }
    }

    public String getCiudadUbicacion() {
        return ciudadUbicacion;
    }
    public void setCiudadUbicacion(String ciudadUbicacion) {
        if(Validador.validarCaracteres(ciudadUbicacion)) {
            this.ciudadUbicacion = ciudadUbicacion;
        }
    }

    //METODOS
    public void actualizarPerfil() {
        System.out.println("[RESULTADO]: Preferencias del perfil actualizadas.");
    }
    public void guardarPreferencias() {
        System.out.println("[RESULTADO]: Configuración de perfil guardada.");
    }
}