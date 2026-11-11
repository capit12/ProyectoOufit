package test;

import org.junit.jupiter.api.Test;
import util.Validador;
import static org.junit.jupiter.api.Assertions.*;

public class TestValidador {

    // Tests de Textos Generales y Correos
    @Test
    public void testValidarCorreo() {
        assertTrue(Validador.validarCorreo("jcuzco@uce.edu.ec"));
        assertFalse(Validador.validarCorreo("sin-arroba"));
        assertFalse(Validador.validarCorreo(null));
    }

    @Test
    public void testValidarCaracteres() {
        assertTrue(Validador.validarCaracteres("Pablo Canchignia"));
        assertTrue(Validador.validarCaracteres("Áéíóú Ññ")); // Prueba de tildes
        assertFalse(Validador.validarCaracteres("Juan123")); // No debe aceptar números
        assertFalse(Validador.validarCaracteres("   "));     // No debe aceptar solo espacios
        assertFalse(Validador.validarCaracteres(null));
    }

    // Tests de Números
    @Test
    public void testValidarNumeros() {
        assertTrue(Validador.validarNumeros("123"));
        assertTrue(Validador.validarNumeros("-15.5")); // Acepta negativos y decimales
        assertFalse(Validador.validarNumeros("abc"));
    }

    @Test
    public void testValidarEnteroPositivo() {
        assertTrue(Validador.validarEnteroPositivo("15"));
        assertFalse(Validador.validarEnteroPositivo("1.5"));
        assertFalse(Validador.validarEnteroPositivo("-5"));
    }

    @Test
    public void testValidarValoracion() {
        assertTrue(Validador.validarValoracion("5"));
        assertTrue(Validador.validarValoracion("1"));
        assertFalse(Validador.validarValoracion("6"));
        assertFalse(Validador.validarValoracion("0"));
    }

    // Tests de Catálogos (Talla, Estilo, Ocasión, Clima)
    @Test
    public void testValidarTalla() {
        assertTrue(Validador.validarTalla("m")); // CASE_INSENSITIVE
        assertTrue(Validador.validarTalla("XL"));
        assertFalse(Validador.validarTalla("XXL"));
    }

    @Test
    public void testValidarEstilo() {
        assertTrue(Validador.validarEstilo("Casual"));
        assertTrue(Validador.validarEstilo("formal"));
        assertFalse(Validador.validarEstilo("Deportivo"));
    }

    @Test
    public void testValidarOcasion() {
        assertTrue(Validador.validarOcasion("Oficina"));
        assertTrue(Validador.validarOcasion("deporte"));
        assertFalse(Validador.validarOcasion("Fiesta"));
    }

    @Test
    public void testValidarClimaIdeal() {
        assertTrue(Validador.validarClimaIdeal("frío")); // Acepta tildes
        assertTrue(Validador.validarClimaIdeal("Templado"));
        assertFalse(Validador.validarClimaIdeal("Nieve"));
    }

    // Tests de Fechas y Contraseñas
    @Test
    public void testValidarFechaHora() {
        assertTrue(Validador.validarFechaHora("25/12/2026 18:30"));
        assertTrue(Validador.validarFechaHora("07:00"));
        assertFalse(Validador.validarFechaHora("32/13/2026 25:61"));
    }

    @Test
    public void testValidarContrasenia() {
        assertTrue(Validador.validarContrasenia("secreta123"));
        assertFalse(Validador.validarContrasenia("123")); // Menos de 4 caracteres
        assertFalse(Validador.validarContrasenia("ab c")); // Contiene un espacio
    }

    // Tests de Imágenes y Expresiones Regulares
    @Test
    public void testValidarFormatoImagen() {
        assertTrue(Validador.validarFormatoImagen("jpg"));
        assertTrue(Validador.validarFormatoImagen("WEBP"));
        assertFalse(Validador.validarFormatoImagen("pdf"));
    }

    @Test
    public void testValidarUriImagen() {
        assertTrue(Validador.validarUriImagen("fotos/a.webp"));
        assertFalse(Validador.validarUriImagen("a.pdf"));
    }

    @Test
    public void testExtraerFormatoImagen() {
        assertEquals("jpeg", Validador.extraerFormatoImagen("x/y/Foto.JPEG")); // Lo convierte a minúscula
        assertNull(Validador.extraerFormatoImagen("documento.pdf"));
        assertNull(Validador.extraerFormatoImagen(null));
    }

    @Test
    public void testContienePatron() {
        assertTrue(Validador.contienePatron("Camisa", "^cam"));
        assertFalse(Validador.contienePatron("Pantalón", "^cam"));
        assertFalse(Validador.contienePatron("Camisa", "[")); // Atrapa PatternSyntaxException y devuelve false
        assertFalse(Validador.contienePatron(null, "^cam"));
    }

    @Test
    public void testEsRegexValido() {
        assertTrue(Validador.esRegexValido("^[a-z]+$"));
        assertFalse(Validador.esRegexValido("["));
        assertFalse(Validador.esRegexValido(null));
        assertFalse(Validador.esRegexValido(""));
    }
}