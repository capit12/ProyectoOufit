package dominio;

public class Clima {
    private int idClima;
    private double temperatura;
    private double probabilidadLluvia;
    private String tipoClima;

    public Clima() {
        this.idClima = 0;
        this.temperatura = 15.0;
        this.probabilidadLluvia = 20.0;
        this.tipoClima = "Despejado";
    }

    public Clima(int idClima, double temperatura, double probabilidadLluvia, String tipoClima) {
        this.idClima = idClima;
        this.temperatura = temperatura;
        this.probabilidadLluvia = probabilidadLluvia;
        this.tipoClima = tipoClima;
    }

    public int getIdClima() { return idClima; }
    public void setIdClima(int idClima) { this.idClima = idClima; }

    public double getTemperatura() { return temperatura; }
    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }

    public double getProbabilidadLluvia() { return probabilidadLluvia; }
    public void setProbabilidadLluvia(double probabilidadLluvia) { this.probabilidadLluvia = probabilidadLluvia; }

    public String getTipoClima() { return tipoClima; }
    public void setTipoClima(String tipoClima) { this.tipoClima = tipoClima; }

    public void consultarPronostico() { System.out.println("[RESULTADO]: Datos meteorológicos sincronizados."); }
    public boolean verificarLluvia() { return probabilidadLluvia > 50.0; }
}