package dominio;

public class Outfit {
    private int idOutfit;
    private String diaSemana;
    private int valoracion;

    public Outfit() {
        this.idOutfit = 0;
        this.diaSemana = "Lunes";
        this.valoracion = 5;
    }

    public Outfit(int idOutfit, String diaSemana, int valoracion) {
        this.idOutfit = idOutfit;
        this.diaSemana = diaSemana;
        this.valoracion = valoracion;
    }

    public int getIdOutfit() { return idOutfit; }
    public void setIdOutfit(int idOutfit) { this.idOutfit = idOutfit; }

    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }

    public int getValoracion() { return valoracion; }
    public void setValoracion(int valoracion) { this.valoracion = valoracion; }

    public void generarOutfitSemanal() { System.out.println("[RESULTADO]: Combinación semanal de outfits procesada."); }
    public void modificarSugerencia() { System.out.println("[RESULTADO]: Alternativa de vestimenta asignada."); }
    public void valorarOutfit(int puntos) { this.valoracion = puntos; System.out.println("[RESULTADO]: Puntuación de " + puntos + " estrellas guardada."); }
}