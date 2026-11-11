package dominio;

import util.Validador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Armario implements Serializable {
    private int idArmario;
    private String nombreArmario;
    private int totalPrendas;
    private List<Prenda> prendas = new ArrayList<>();

    public Armario() {
        this.idArmario = 0;
        this.nombreArmario = "Mi Armario";
        this.totalPrendas = 0;
    }

    public Armario(int idArmario, String nombreArmario) {
        this.idArmario = idArmario;
        this.nombreArmario = nombreArmario;
        this.totalPrendas = 0;
    }

    //GETTERS Y SETTERS
    public int getIdArmario() {
        return idArmario;
    }
    public void setIdArmario(int idArmario) {
        this.idArmario = idArmario;
    }

    public String getNombreArmario() {
        return nombreArmario;
    }
    public void setNombreArmario(String nombreArmario) {
        if (Validador.validarCaracteres(nombreArmario)) {
            this.nombreArmario = nombreArmario;
        }
    }

    public int getTotalPrendas() {
        return totalPrendas;
    }
    public void setTotalPrendas(int totalPrendas) {
        this.totalPrendas = totalPrendas;
    }

    public List<Prenda> getPrendas() {
        return prendas;
    }
    public void setPrendas(List<Prenda> prendas) {
        this.prendas = prendas;
        this.totalPrendas = prendas.size();
    }

    //METODOS
    public void agregarPrenda(Prenda prenda) {
        prendas.add(prenda);
        totalPrendas = prendas.size();
    }

    public Prenda eliminarPrenda(int indice) {
        Prenda eliminada = prendas.remove(indice);
        totalPrendas = prendas.size();
        return eliminada;
    }

    public boolean estaVacio() {
        return prendas.isEmpty();
    }

    /** Busca prendas cuyo nombre o color contenga el patrón (regex) indicado, usando Pattern/Matcher. */
    public List<Prenda> buscarPrendasPorPatron(String regex) {
        List<Prenda> encontradas = new ArrayList<>();
        for (Prenda p : prendas) {
            if (Validador.contienePatron(p.getNombre(), regex) || Validador.contienePatron(p.getColor(), regex)) {
                encontradas.add(p);
            }
        }
        return encontradas;
    }
}