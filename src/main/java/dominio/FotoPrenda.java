package dominio;

import util.Validador;
import java.io.Serializable;

public class FotoPrenda implements Serializable {
    private int idFoto;
    private String uriImagen;
    private String formato;
    private boolean fondoEliminado;

    public FotoPrenda() {
        this.idFoto = 0;
        this.uriImagen = "";
        this.formato = "jpg";
        this.fondoEliminado = false;
    }

    /** El formato se deduce de la extensión de la URI mediante regex. */
    public FotoPrenda(int idFoto, String uriImagen, boolean fondoEliminado) {
        this.idFoto = idFoto;
        this.fondoEliminado = fondoEliminado;
        this.uriImagen = "";
        this.formato = "jpg";
        setUriImagen(uriImagen);
    }

    public int getIdFoto() { return idFoto; }
    public void setIdFoto(int idFoto) { this.idFoto = idFoto; }

    public String getUriImagen() { return uriImagen; }
    /** Acepta solo URIs terminadas en jpg/jpeg/png/webp y actualiza el formato automáticamente. */
    public void setUriImagen(String uriImagen) {
        if (Validador.validarUriImagen(uriImagen)) {
            this.uriImagen = uriImagen;
            this.formato = Validador.extraerFormatoImagen(uriImagen);
        }
    }

    public String getFormato() { return formato; }
    public void setFormato(String formato) {
        if (Validador.validarFormatoImagen(formato)) this.formato = formato.toLowerCase();
    }

    public boolean isFondoEliminado() { return fondoEliminado; }
    public void setFondoEliminado(boolean fondoEliminado) { this.fondoEliminado = fondoEliminado; }
}