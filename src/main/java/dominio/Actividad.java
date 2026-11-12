package dominio;

import util.Validador;

public class Actividad {
    private int idActividad;
    private String nombreActividad;
    private String fechaHora;
    private String tipoOcasion;

    public Actividad() {
        this.idActividad = 0;
        this.nombreActividad = "Evento General";
        this.fechaHora = "00:00";
        this.tipoOcasion = "Casual";
    }

    public Actividad(int idActividad, String nombreActividad, String fechaHora, String tipoOcasion) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.fechaHora = fechaHora;
        this.tipoOcasion = tipoOcasion;
    }

    //GETTERS Y SETTERS
    public int getIdActividad() {
        return idActividad;
    }
    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }
    public void setNombreActividad(String nombreActividad) {
        if(Validador.validarCaracteres(nombreActividad)) {
            this.nombreActividad = nombreActividad;
        }
    }

    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) {

        if(Validador.validarFechaHora(fechaHora)) {
            this.fechaHora = fechaHora;
        }
    }

    public String getTipoOcasion() {
        return tipoOcasion;
    }
    public void setTipoOcasion(String tipoOcasion) {
        if(Validador.validarOcasion(tipoOcasion)) {
            this.tipoOcasion = tipoOcasion;
        }
    }

    //METODOS
    public void registrarActividad() {
        System.out.println("[RESULTADO]: Actividad agregada a la agenda.");
    }
    public void modificarActividad() {
        System.out.println("[RESULTADO]: Datos de la actividad editados.");
    }
    public void eliminarActividad() {
        System.out.println("[RESULTADO]: Actividad removida de la agenda.");
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "idActividad=" + idActividad +
                ", nombreActividad='" + nombreActividad + '\'' +
                ", fechaHora='" + fechaHora + '\'' +
                ", tipoOcasion='" + tipoOcasion + '\'' +
                '}';
    }
}