package test;

import dominio.Clima;

public class TestClima {
    public void probarClase() {
        System.out.println("[EJECUTANDO CÓDIGO TEST]: CLASE CLIMA");
        Clima c1 = new Clima();
        Clima c2 = new Clima(1, 12.5, 80.0, "Lluvia");

        c2.consultarPronostico();
        System.out.println("¿Validación de lluvia?: " + c2.verificarLluvia());
    }
}