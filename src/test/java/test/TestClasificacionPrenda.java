package test;

import dominio.ClasificacionPrenda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestClasificacionPrenda {

    private ClasificacionPrenda clasificacion;

    @BeforeEach
    public void setUp() {
        // Configuramos una clasificación válida antes de cada prueba
        clasificacion = new ClasificacionPrenda(1, "Camisa", "Manga Larga");
    }

    // Tests de Constructores
    @Test
    public void testConstructorDefecto() {
        ClasificacionPrenda cDefecto = new ClasificacionPrenda();

        assertEquals(0, cDefecto.getIdClasificacion());
        assertEquals("General", cDefecto.getCategoria());
        assertEquals("General", cDefecto.getSubcategoria());
    }

    @Test
    public void testConstructorParametrizado() {
        assertEquals(1, clasificacion.getIdClasificacion());
        assertEquals("Camisa", clasificacion.getCategoria());
        assertEquals("Manga Larga", clasificacion.getSubcategoria());
    }

    // Tests de Setters (Caminos Felices)
    @Test
    public void testSetIdClasificacion() {
        clasificacion.setIdClasificacion(10);
        assertEquals(10, clasificacion.getIdClasificacion());
    }

    @Test
    public void testSetCategoriaValida() {
        clasificacion.setCategoria("Pantalón"); // Acepta tildes gracias al Validador
        assertEquals("Pantalón", clasificacion.getCategoria());
    }

    @Test
    public void testSetSubcategoriaValida() {
        clasificacion.setSubcategoria("Vaquero");
        assertEquals("Vaquero", clasificacion.getSubcategoria());
    }

    // Tests de Validadores (Caminos Tristes)
    @Test
    public void testSetCategoriaInvalida() {
        String categoriaAntes = clasificacion.getCategoria(); // "Camisa"

        // No debe aceptar números
        clasificacion.setCategoria("Pantalón 123");

        assertEquals(categoriaAntes, clasificacion.getCategoria(), "La categoría no debió cambiar si contiene números");
    }

    @Test
    public void testSetSubcategoriaInvalida() {
        String subcategoriaAntes = clasificacion.getSubcategoria(); // "Manga Larga"

        // No debe aceptar caracteres especiales
        clasificacion.setSubcategoria("Vaquero@");

        assertEquals(subcategoriaAntes, clasificacion.getSubcategoria(), "La subcategoría no debió cambiar si es inválida");
    }

    // Tests de Métodos Especiales
    @Test
    public void testToString() {
        // Verifica que el formato devuelto por toString sea exactamente "Categoría / Subcategoría"
        String resultadoEsperado = "Camisa / Manga Larga";
        assertEquals(resultadoEsperado, clasificacion.toString());
    }
}