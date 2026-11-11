package dominio;

import util.Validador;
import java.io.Serializable;

public class ClasificacionPrenda implements Serializable {
    private int idClasificacion;
    private String categoria;
    private String subcategoria;

    public ClasificacionPrenda() {
        this.idClasificacion = 0;
        this.categoria = "General";
        this.subcategoria = "General";
    }

    public ClasificacionPrenda(int idClasificacion, String categoria, String subcategoria) {
        this.idClasificacion = idClasificacion;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
    }
    //GETTERS Y SETTERS
    public int getIdClasificacion() {
        return idClasificacion;
    }
    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        if (Validador.validarCaracteres(categoria)) {
            this.categoria = categoria;
        }
    }

    public String getSubcategoria() {
        return subcategoria;
    }
    public void setSubcategoria(String subcategoria) {
        if (Validador.validarCaracteres(subcategoria)) {
            this.subcategoria = subcategoria;
        }
    }

    @Override
    public String toString() { return categoria + " / " + subcategoria; }
}