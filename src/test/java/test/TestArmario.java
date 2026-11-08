package test;

import dominio.Armario;
import dominio.Prenda;

public class TestArmario {
    public void probarClase() {
        System.out.println("[EJECUTANDO CÓDIGO TEST]: CLASE ARMARIO");
        Armario a1 = new Armario();
        Armario a2 = new Armario(1, "Armario Principal");

        a2.agregarPrenda(new Prenda(1, "Camisa", "Azul", true, "Oficina", "Templado"));
        a2.agregarPrenda(new Prenda(2, "Jean", "Negro", true, "Casual", "Frío"));
        a2.agregarPrenda(new Prenda(3, "Camiseta", "Blanco", true, "Deporte", "Cálido"));

        System.out.println("Total de prendas: " + a2.getTotalPrendas());
        System.out.println("Búsqueda regex '^ca.*' -> " + a2.buscarPrendasPorPatron("^ca.*").size() + " coincidencias");
        System.out.println("Búsqueda regex 'azul|negro' -> " + a2.buscarPrendasPorPatron("azul|negro").size() + " coincidencias");
        System.out.println("Búsqueda regex inválida '[' -> " + a2.buscarPrendasPorPatron("[").size() + " coincidencias");
        a2.eliminarPrenda(0);
        System.out.println("Total tras eliminar: " + a2.getTotalPrendas() + " | Armario por defecto vacío: " + a1.estaVacio());
    }
}