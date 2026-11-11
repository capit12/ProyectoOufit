package dominio;

import util.Validador;
import java.io.Serializable;

public class Prenda implements Serializable {
    private int idPrenda;
    private String nombre;
    private String color;
    private boolean disponibleLimpia;
    private String ocasionUso;
    private String tipoClimaIdeal;
    private ClasificacionPrenda clasificacion;
    private FotoPrenda foto;

    public Prenda() {
        this.idPrenda = 0;
        this.nombre = "Nueva Prenda";
        this.color = "Blanco";
        this.disponibleLimpia = true;
        this.ocasionUso = "Casual";
        this.tipoClimaIdeal = "Templado";
    }

    public Prenda(int idPrenda, String nombre, String color, boolean disponibleLimpia, String ocasionUso, String tipoClimaIdeal) {
        this.idPrenda = idPrenda;
        this.nombre = nombre;
        this.color = color;
        this.disponibleLimpia = disponibleLimpia;
        this.ocasionUso = ocasionUso;
        this.tipoClimaIdeal = tipoClimaIdeal;
    }

    //GETEERS Y SETTERS
    public int getIdPrenda() {
        return idPrenda;
    }
    public void setIdPrenda(int idPrenda) {
        this.idPrenda = idPrenda;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {

        if(Validador.validarCaracteres(nombre)) {
            this.nombre = nombre;
        }
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        if(Validador.validarCaracteres(color)) {
            this.color = color;
        }
    }

    public boolean isDisponibleLimpia() {
        return disponibleLimpia;
    }
    public void setDisponibleLimpia(boolean disponibleLimpia) {
        this.disponibleLimpia = disponibleLimpia;
    }

    public String getOcasionUso() {
        return ocasionUso;
    }
    public void setOcasionUso(String ocasionUso) {
        if(Validador.validarOcasion(ocasionUso)) {
            this.ocasionUso = ocasionUso;
        }
    }

    public String getTipoClimaIdeal() {
        return tipoClimaIdeal;
    }
    public void setTipoClimaIdeal(String tipoClimaIdeal) {
        if(Validador.validarClimaIdeal(tipoClimaIdeal)) {
            this.tipoClimaIdeal = tipoClimaIdeal;
        }
    }

    public ClasificacionPrenda getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(ClasificacionPrenda clasificacion) {
        this.clasificacion = clasificacion;
    }

    public FotoPrenda getFoto() {
        return foto;
    }
    public void setFoto(FotoPrenda foto) {
        this.foto = foto;
    }

    //METODOS
    public void crearPrenda() {
        System.out.println("[RESULTADO]: Prenda registrada en el clóset virtual.");
    }
    public void actualizarPrenda() {
        System.out.println("[RESULTADO]: Estado de la prenda modificado.");
    }
    public void eliminarPrenda() {
        System.out.println("[RESULTADO]: Prenda removida permanentemente.");
    }
}