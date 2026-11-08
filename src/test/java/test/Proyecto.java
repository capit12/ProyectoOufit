package test;

import consola.Menu;

public class Proyecto {
    public static void main(String[] args) {
        System.out.println(" UNIVERSIDAD CENTRAL DEL ECUADOR ");

        System.out.println("[SISTEMA TEST]: EJECUTANDO BANCO DE PRUEBAS UNITARIAS");

        new test.TestUsuario().probarClase();
        new test.TestPerfilUsuario().probarClase();
        new test.TestPrenda().probarClase();
        new test.TestActividad().probarClase();
        new test.TestOutfit().probarClase();
        new test.TestClima().probarClase();
        new test.TestClasificacionPrenda().probarClase();
        new test.TestFotoPrenda().probarClase();
        new test.TestArmario().probarClase();
        new test.TestValidador().probarClase();

        System.out.println("[SISTEMA TEST]: TODAS LAS ENTIDADES COMPROBADAS");


        System.out.println("Desplegando menús estructurados según Casos de Uso");
        Menu menuConsola = new Menu();
        menuConsola.mostrarMenuPrincipal();
    }
}