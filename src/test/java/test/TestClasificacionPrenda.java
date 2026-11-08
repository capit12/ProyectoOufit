package test;

import dominio.ClasificacionPrenda;

public class TestClasificacionPrenda {
    public void probarClase() {
        System.out.println("[EJECUTANDO CÓDIGO TEST]: CLASE CLASIFICACION PRENDA");
        ClasificacionPrenda c1 = new ClasificacionPrenda();
        ClasificacionPrenda c2 = new ClasificacionPrenda(1, "Camisa", "Manga larga");

        c2.setCategoria("Pantalón 123");   // inválida (tiene números): se ignora
        System.out.println("Categoría conservada: " + c2.getCategoria());
        System.out.println("Clasificación por defecto: " + c1);
        System.out.println("Clasificación asignada: " + c2);
    }
}