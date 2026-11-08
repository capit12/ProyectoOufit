package test;

import dominio.Prenda;

public class TestPrenda {
    public void probarClase() {
        System.out.println("[EJECUTANDO CÓDIGO TEST]: CLASE PRENDA");
        Prenda pr1 = new Prenda();
        Prenda pr2 = new Prenda(1, "Jean", "Azul", true, "Casual", "Templado");

        pr2.crearPrenda();
        pr2.actualizarPrenda();
        pr2.eliminarPrenda();
    }
}