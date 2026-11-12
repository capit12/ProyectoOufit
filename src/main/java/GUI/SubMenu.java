package GUI;

import dominio.*;
import util.Validador;
import java.util.Scanner;
import java.util.List;

public class SubMenu {
    private static Scanner sn = new Scanner(System.in);

    public static void mostrarSubMenuCuenta(Usuario usuario) {
        int op;
        do {
            System.out.println("\n--> SUBMENÚ CONSOLA NIVEL 1: CUENTA [H1]");
            System.out.println("1. [Caso H1.1] Registrar Cuenta");
            System.out.println("2. [Caso H1.2] Actualizar Perfil de Estilo");
            System.out.println("3. [Caso H1.3] Eliminar Cuenta Permanente");
            System.out.println("4. <-- Regresar al Menú Principal (Nivel 0)");
            System.out.print("Seleccione opción: ");
            op = sn.nextInt(); sn.nextLine();

            switch(op) {
                case 1: usuario.crearCuenta(); break;
                case 2:
                    if(usuario.getPerfil() != null) usuario.getPerfil().actualizarPerfil();
                    else System.out.println("Alerta: Sin perfil adjunto.");
                    break;
                case 3: usuario.eliminarCuenta(); break;
            }
        } while(op != 4);
    }

    public static void mostrarSubMenuClima(Clima clima) {
        int op;
        do {
            System.out.println("\n--> SUBMENÚ CONSOLA NIVEL 1: CLIMA [H2]");
            System.out.println("1. [Caso H2.1] Obtener Datos de la API");
            System.out.println("2. [Caso H2.2] Ubicación Manual");
            System.out.println("3. <-- Regresar al Menú Principal (Nivel 0)");
            System.out.print("Seleccione opción: ");
            op = sn.nextInt(); sn.nextLine();

            switch(op) {
                case 1: clima.consultarPronostico(); break;
                case 2: System.out.println("Ubicación manual fijada."); break;
            }
        } while(op != 3);
    }

    public static void mostrarSubMenuPrendas(Armario miArmario) {
        int op;
        do {
            System.out.println("\n--> SUBMENÚ CONSOLA NIVEL 1: PRENDAS [H3]");
            System.out.println("1. [Caso H3.1] Registrar y Clasificar Prenda");
            System.out.println("2. Ver Catálogo del Armario Virtual");
            System.out.println("3. [Caso H3.2] Modificar Disponibilidad");
            System.out.println("4. [Caso H3.3] Eliminar Prenda");
            System.out.println("5. Buscar Prenda por Patrón (regex)");
            System.out.println("6. <-- Regresar al Menú Principal (Nivel 0)");
            System.out.print("Seleccione opción: ");
            op = sn.nextInt(); sn.nextLine();

            switch(op) {
                case 1:
                    Prenda nuevaPrenda = FormulariosDatos.formularioGestionarPrenda();
                    miArmario.agregarPrenda(nuevaPrenda);
                    nuevaPrenda.crearPrenda();
                    break;
                case 2:
                    System.out.println("\n--- LISTADO DE PRENDAS ---");
                    System.out.println("Armario: " + miArmario.getNombreArmario() + " | Total de prendas: " + miArmario.getTotalPrendas());
                    if(miArmario.estaVacio()) System.out.println("Armario vacío.");
                    else {
                        for(Prenda p : miArmario.getPrendas()) {
                            System.out.println("- ID: " + p.getIdPrenda() + " | " + p.getNombre() + " (" + p.getColor() + ")"
                                    + (p.getClasificacion() != null ? " | " + p.getClasificacion() : "")
                                    + (p.getFoto() != null ? " | Foto: " + p.getFoto().getUriImagen() + " [" + p.getFoto().getFormato() + "]" : ""));
                        }
                    }
                    break;
                case 3:
                    if(!miArmario.estaVacio()) miArmario.getPrendas().get(0).actualizarPrenda();
                    else System.out.println("Sin elementos.");
                    break;
                case 4:
                    if(!miArmario.estaVacio()) miArmario.eliminarPrenda(0).eliminarPrenda();
                    else System.out.println("Sin elementos.");
                    break;
                case 5:
                    System.out.print("Ingrese el patrón a buscar en nombre o color (ej. ^ca.* o azul|negro): ");
                    String patron = sn.nextLine().trim();
                    if(!Validador.esRegexValido(patron)) {
                        System.out.println("[ERROR]: Expresión regular inválida.");
                        break;
                    }
                    List<Prenda> encontradas = miArmario.buscarPrendasPorPatron(patron);
                    System.out.println("Coincidencias: " + encontradas.size());
                    for(Prenda p : encontradas) {
                        System.out.println("- ID: " + p.getIdPrenda() + " | " + p.getNombre() + " (" + p.getColor() + ")");
                    }
                    break;
            }
        } while(op != 6);
    }

    public static void mostrarSubMenuOutfits(Outfit outfit) {
        int op;
        do {
            System.out.println("\n--> SUBMENÚ CONSOLA NIVEL 1: OUTFITS [H4]");
            System.out.println("1. [Caso H4.1] Generar Sugerencia");
            System.out.println("2. [Caso H4.2] Modificar Sugerencia");
            System.out.println("3. [Caso H4.3] Valorar Planificación");
            System.out.println("4. <-- Regresar al Menú Principal (Nivel 0)");
            System.out.print("Seleccione opción: ");
            op = sn.nextInt(); sn.nextLine();

            switch(op) {
                case 1: outfit.generarOutfitSemanal(); break;
                case 2: outfit.modificarSugerencia(); break;
                case 3:
                    System.out.print("Ingrese valoración (1-5): ");
                    String ptsTxt = sn.nextLine().trim();
                    if(Validador.validarValoracion(ptsTxt)) {
                        outfit.valorarOutfit(Integer.parseInt(ptsTxt));
                    } else {
                        System.out.println("[ERROR]: La valoración debe ser un entero entre 1 y 5.");
                    }
                    break;
            }
        } while(op != 4);
    }

    public static void mostrarSubMenuCalendario(Actividad actividad) {
        int op;
        do {
            System.out.println("\n--> SUBMENÚ CONSOLA NIVEL 1: CALENDARIO [H5]");
            System.out.println("1. [Caso H5.1] Sincronizar Actividad");
            System.out.println("2. [Caso H5.2] Modificar Compromiso");
            System.out.println("3. [Caso H5.3] Eliminar Actividad");
            System.out.println("4. <-- Regresar al Menú Principal (Nivel 0)");
            System.out.print("Seleccione opción: ");
            op = sn.nextInt(); sn.nextLine();

            switch(op) {
                case 1: actividad.registrarActividad(); break;
                case 2: actividad.modificarActividad(); break;
                case 3: actividad.eliminarActividad(); break;
            }
        } while(op != 4);
    }
}