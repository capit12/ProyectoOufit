package consola;

import dominio.*;
import util.Validador;
import java.util.Scanner;
import java.util.function.Predicate;

public class FormulariosDatos {
    private static Scanner sn = new Scanner(System.in);

    /** Repite la pregunta hasta que el texto cumpla la validación (regex) indicada. */
    private static String leerValidado(String mensaje, Predicate<String> validador, String error) {
        String texto;
        while (true) {
            System.out.print(mensaje);
            texto = sn.nextLine().trim();
            if (validador.test(texto)) return texto;
            System.out.println("[ERROR]: " + error);
        }
    }

    public static Usuario formularioGestionarCuenta() {
        System.out.println("\n--- [ALCANCE CAMPOS H1]: REGISTRO DE CUENTA ---");

        int id = Integer.parseInt(leerValidado("Ingrese ID de Usuario (Solo números enteros): ",
                Validador::validarEnteroPositivo, "El ID debe ser un entero positivo."));

        String nombre = leerValidado("Ingrese Nombre de Usuario (Solo letras): ",
                Validador::validarCaracteres, "Use solo letras y espacios.");

        String correo = leerValidado("Ingrese Correo Electrónico (ejemplo@uce.edu.ec): ",
                Validador::validarCorreo, "Correo con formato inválido.");

        String contrasenia = leerValidado("Ingrese Contraseña de Seguridad (mín. 4 caracteres, sin espacios): ",
                Validador::validarContrasenia, "Contraseña inválida.");

        Usuario nuevoUsuario = new Usuario(id, nombre, correo, contrasenia);

        String estilo = leerValidado("Ingrese su Estilo Preferido (Casual/Formal): ",
                Validador::validarEstilo, "Elija Casual o Formal.");
        String talla = leerValidado("Ingrese su Talla de Ropa (XS/S/M/L/XL): ",
                Validador::validarTalla, "Talla inválida.");
        String ciudad = leerValidado("Ingrese su Ciudad de Ubicación Actual: ",
                Validador::validarCaracteres, "Use solo letras y espacios.");

        PerfilUsuario perfil = new PerfilUsuario(201, estilo, talla.toUpperCase(), ciudad);
        nuevoUsuario.setPerfil(perfil);

        return nuevoUsuario;
    }

    public static Prenda formularioGestionarPrenda() {
        System.out.println("\n--- [ALCANCE CAMPOS H3]: REGISTRO DE PRENDA ---");

        int id = Integer.parseInt(leerValidado("Ingrese ID de Prenda (Solo números enteros): ",
                Validador::validarEnteroPositivo, "El ID debe ser un entero positivo."));

        String nombre = leerValidado("Ingrese el Nombre de la Prenda (Solo letras): ",
                Validador::validarCaracteres, "Use solo letras y espacios.");
        String color = leerValidado("Ingrese el Color Dominante (Solo letras): ",
                Validador::validarCaracteres, "Use solo letras y espacios.");
        String ocasion = leerValidado("Seleccione Ocasión de Uso (Oficina/Casual/Deporte): ",
                Validador::validarOcasion, "Elija Oficina, Casual o Deporte.");
        String climaIdeal = leerValidado("Seleccione Tipo de Clima Ideal (Frío/Cálido/Templado): ",
                Validador::validarClimaIdeal, "Elija Frío, Cálido o Templado.");

        Prenda prenda = new Prenda(id, nombre, color, true, ocasion, climaIdeal);

        String categoria = leerValidado("Ingrese la Categoría de la prenda (ej. Camisa, Pantalón): ",
                Validador::validarCaracteres, "Use solo letras y espacios.");
        String subcategoria = leerValidado("Ingrese la Subcategoría (ej. Manga larga): ",
                Validador::validarCaracteres, "Use solo letras y espacios.");
        prenda.setClasificacion(new ClasificacionPrenda(id, categoria, subcategoria));

        System.out.print("Ingrese la URI de la foto (.jpg/.jpeg/.png/.webp) o Enter para omitir: ");
        String uri = sn.nextLine().trim();
        while (!uri.isEmpty() && !Validador.validarUriImagen(uri)) {
            System.out.println("[ERROR]: La URI debe terminar en .jpg, .jpeg, .png o .webp y no tener espacios.");
            System.out.print("Ingrese la URI de la foto o Enter para omitir: ");
            uri = sn.nextLine().trim();
        }
        if (!uri.isEmpty()) prenda.setFoto(new FotoPrenda(id, uri, false));

        return prenda;
    }

    public static Actividad formularioGestionarCalendario() {
        System.out.println("\n--- [ALCANCE CAMPOS H5]: REGISTRO DE ACTIVIDAD ---");

        int id = Integer.parseInt(leerValidado("Ingrese ID de Actividad (Solo números enteros): ",
                Validador::validarEnteroPositivo, "El ID debe ser un entero positivo."));

        String titulo = leerValidado("Ingrese el Título del Evento (Solo letras/espacios): ",
                Validador::validarCaracteres, "Use solo letras y espacios.");
        String fechaHora = leerValidado("Ingrese la Fecha y Hora del Compromiso (dd/MM/yyyy HH:mm o HH:mm): ",
                Validador::validarFechaHora, "Formato inválido. Ejemplo: 25/12/2026 18:30");
        String categoria = leerValidado("Seleccione la Categoría (Oficina/Casual/Deporte): ",
                Validador::validarOcasion, "Elija Oficina, Casual o Deporte.");

        return new Actividad(id, titulo, fechaHora, categoria);
    }
}