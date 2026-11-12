package test;

import GUI.Menu;

public class Proyecto {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("     UNIVERSIDAD CENTRAL DEL ECUADOR     ");
        System.out.println("      PROYECTO: ASISTENTE DE OUTFITS     ");
        System.out.println("=========================================");

        // Nota: Las pruebas unitarias ahora se ejecutan directamente
        // desde el IDE (JUnit 5) y ya no necesitan ser llamadas aquí.

        System.out.println("\nDesplegando menús estructurados según Casos de Uso...");
        Menu menuConsola = new Menu();
        menuConsola.mostrarMenuPrincipal();
    }
}