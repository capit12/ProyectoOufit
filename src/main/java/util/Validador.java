package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Validaciones del sistema usando expresiones regulares (Pattern / Matcher).
 * Los Pattern se compilan una sola vez como constantes estáticas.
 */
public class Validador {

    // ---------- Patrones precompilados ----------
    private static final Pattern CORREO = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern CARACTERES = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
    private static final Pattern NUMEROS = Pattern.compile("^-?\\d+(\\.\\d+)?$");
    private static final Pattern ENTERO_POSITIVO = Pattern.compile("^\\d{1,9}$");
    private static final Pattern VALORACION = Pattern.compile("^[1-5]$");
    private static final Pattern CONTRASENIA = Pattern.compile("^\\S{4,}$");
    private static final Pattern TALLA = Pattern.compile("^(XS|S|M|L|XL)$", Pattern.CASE_INSENSITIVE);
    private static final Pattern ESTILO = Pattern.compile("^(Casual|Formal)$", Pattern.CASE_INSENSITIVE);
    private static final Pattern OCASION = Pattern.compile("^(Oficina|Casual|Deporte)$", Pattern.CASE_INSENSITIVE);
    private static final Pattern CLIMA_IDEAL = Pattern.compile("^(Fr[ií]o|C[aá]lido|Templado)$", Pattern.CASE_INSENSITIVE);
    // "HH:mm" o "dd/MM/yyyy HH:mm"
    private static final Pattern FECHA_HORA = Pattern.compile(
            "^(?:(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/\\d{4} )?([01]\\d|2[0-3]):[0-5]\\d$");
    private static final Pattern FORMATO_IMAGEN = Pattern.compile("^(jpg|jpeg|png|webp)$", Pattern.CASE_INSENSITIVE);
    // Grupo 1 = extensión de la imagen
    private static final Pattern URI_IMAGEN = Pattern.compile("^\\S+\\.(jpg|jpeg|png|webp)$", Pattern.CASE_INSENSITIVE);

    private static boolean coincide(Pattern pattern, String texto) {
        if (texto == null) return false;
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }

    // ---------- Validaciones ----------
    public static boolean validarCorreo(String correo) {
        return coincide(CORREO, correo);
    }


    public static boolean validarCaracteres(String texto) {
        if (texto == null || texto.trim().isEmpty())
            return false;
        return coincide(CARACTERES, texto);
    }

    public static boolean validarNumeros(String numero) {
        return coincide(NUMEROS, numero);
    }

    /** Entero positivo de hasta 9 dígitos (ids). Evita NumberFormatException con "1.5" o "-3". */
    public static boolean validarEnteroPositivo(String texto) {
        return coincide(ENTERO_POSITIVO, texto);
    }

    /** Valoración entera de 1 a 5. */
    public static boolean validarValoracion(String texto) {
        return coincide(VALORACION, texto);
    }

    /** Mínimo 4 caracteres y sin espacios. */
    public static boolean validarContrasenia(String texto) {
        return coincide(CONTRASENIA, texto);
    }

    public static boolean validarTalla(String texto) {
        return coincide(TALLA, texto);
    }
    public static boolean validarEstilo(String texto) {
        return coincide(ESTILO, texto);
    }
    public static boolean validarOcasion(String texto) {
        return coincide(OCASION, texto);
    }
    public static boolean validarClimaIdeal(String texto) {
        return coincide(CLIMA_IDEAL, texto);
    }
    public static boolean validarFechaHora(String texto) {
        return coincide(FECHA_HORA, texto);
    }
    public static boolean validarFormatoImagen(String texto) {
        return coincide(FORMATO_IMAGEN, texto); }
    public static boolean validarUriImagen(String texto) {
        return coincide(URI_IMAGEN, texto);
    }

    /** Extrae la extensión (en minúsculas) de una URI de imagen usando el grupo del Matcher; null si no es válida. */
    public static String extraerFormatoImagen(String uri) {
        if (uri == null) return null;
        Matcher matcher = URI_IMAGEN.matcher(uri);
        return matcher.matches() ? matcher.group(1).toLowerCase() : null;
    }

    /**
     * Indica si el texto contiene el patrón (regex ingresado por el usuario) usando Matcher.find().
     * Búsqueda sin distinguir mayúsculas; si el regex es inválido devuelve false.
     */
    public static boolean contienePatron(String texto, String regex) {
        if (texto == null || regex == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(texto);
            return matcher.find();
        } catch (PatternSyntaxException e) {
            return false;

        }
    }

    /** true si el regex se puede compilar. */
    public static boolean esRegexValido(String regex) {
        if (regex == null || regex.isEmpty()) {
            return false;
        }
        try {
            Pattern.compile(regex);
            return true;
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}