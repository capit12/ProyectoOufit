package consola;

import dominio.*;
import java.util.Scanner;

public class Menu {
    private Scanner sn = new Scanner(System.in);
    private Armario miArmarioDigital = new Armario(1, "Mi Armario");

    private Usuario usuarioActual = new Usuario(1, "Demo", "demo@uce.edu.ec", "123");
    private Clima climaActual = new Clima();
    private Outfit outfitActual = new Outfit();
    private Actividad actividadActual = new Actividad();

    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("        ASISTENTE INTELIGENTE DE OUTFITS SEMANALES      ");
            System.out.println("               MENÚ PRINCIPAL - NIVEL 0                ");

            System.out.println("1. [Módulo H1] Gestionar Cuenta de Usuario");
            System.out.println("2. [Módulo H2] Añadir Pronóstico del Clima");
            System.out.println("3. [Módulo H3] Gestionar Prenda (Armario Virtual)");
            System.out.println("4. [Módulo H4] Gestionar Recomendación Semanal");
            System.out.println("5. [Módulo H5] Gestionar Calendario de Actividades");
            System.out.println("6. Cerrar Sesión y Salir del Programa");
            System.out.print("Seleccione una opción de nivel 0: ");
            opcion = sn.nextInt(); sn.nextLine();

            switch(opcion) {
                case 1:
                    usuarioActual = FormulariosDatos.formularioGestionarCuenta();
                    SubMenu.mostrarSubMenuCuenta(usuarioActual);
                    break;
                case 2: SubMenu.mostrarSubMenuClima(climaActual); break;
                case 3: SubMenu.mostrarSubMenuPrendas(miArmarioDigital); break;
                case 4: SubMenu.mostrarSubMenuOutfits(outfitActual); break;
                case 5:
                    actividadActual = FormulariosDatos.formularioGestionarCalendario();
                    SubMenu.mostrarSubMenuCalendario(actividadActual);
                    break;
                case 6: System.out.println("\n[SISTEMA]: Aplicación cerrada limpiamente."); break;
            }
        } while(opcion != 6);
    }
}