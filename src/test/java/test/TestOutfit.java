package test;

import dominio.Outfit;

public class TestOutfit {
    public void probarClase() {
        System.out.println("[EJECUTANDO CÓDIGO TEST]: CLASE OUTFIT");
        Outfit o1 = new Outfit();
        Outfit o2 = new Outfit(1, "Martes", 4);

        o2.generarOutfitSemanal();
        o2.modificarSugerencia();
        o2.valorarOutfit(5);
    }
}