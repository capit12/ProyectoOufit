package test;

import dominio.FotoPrenda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestFotoPrenda {

    private FotoPrenda foto;

    @BeforeEach
    public void setUp() {
        // Configuramos una foto válida. Al pasar la URI, el constructor debe
        // usar el setter internamente para deducir que el formato es "png".
        foto = new FotoPrenda(1, "fotos/camisa_azul.png", true);
    }

    // Tests de Constructores
    @Test
    public void testConstructorDefecto() {
        FotoPrenda fDefecto = new FotoPrenda();

        assertEquals(0, fDefecto.getIdFoto());
        assertEquals("", fDefecto.getUriImagen());
        assertEquals("jpg", fDefecto.getFormato(), "El formato por defecto debería ser jpg");
        assertFalse(fDefecto.isFondoEliminado());
    }

    @Test
    public void testConstructorParametrizado() {
        assertEquals(1, foto.getIdFoto());
        assertEquals("fotos/camisa_azul.png", foto.getUriImagen());
        // Verificamos la deducción automática del formato
        assertEquals("png", foto.getFormato(), "El formato debió extraerse automáticamente de la URI");
        assertTrue(foto.isFondoEliminado());
    }

    // Tests de Setters (Caminos Felices)
    @Test
    public void testSetIdFoto() {
        foto.setIdFoto(15);
        assertEquals(15, foto.getIdFoto());
    }

    @Test
    public void testSetFondoEliminado() {
        foto.setFondoEliminado(false);
        assertFalse(foto.isFondoEliminado());
    }

    @Test
    public void testSetUriImagenValida() {
        // Probamos enviando una nueva URI con otra extensión (incluso en mayúsculas)
        foto.setUriImagen("archivos/pantalon.WEBP");

        assertEquals("archivos/pantalon.WEBP", foto.getUriImagen());
        assertEquals("webp", foto.getFormato(), "El formato debió actualizarse a webp (en minúsculas)");
    }

    @Test
    public void testSetFormatoValido() {
        // El setter de formato debe aceptar el valor y guardarlo en minúsculas
        foto.setFormato("JPEG");
        assertEquals("jpeg", foto.getFormato());
    }

    // Tests de Validadores (Caminos Tristes)
    @Test
    public void testSetUriImagenInvalida() {
        String uriAntes = foto.getUriImagen();
        String formatoAntes = foto.getFormato();

        // Intentamos pasar un PDF (no es imagen permitida en tu sistema)
        foto.setUriImagen("documentos/manual.pdf");

        assertEquals(uriAntes, foto.getUriImagen(), "La URI no debió cambiar porque es inválida");
        assertEquals(formatoAntes, foto.getFormato(), "El formato tampoco debió verse afectado");
    }

    @Test
    public void testSetFormatoInvalido() {
        String formatoAntes = foto.getFormato();

        // Intentamos forzar un formato no admitido
        foto.setFormato("gif");

        assertEquals(formatoAntes, foto.getFormato(), "El formato no debió cambiar si no es jpg/jpeg/png/webp");
    }
}