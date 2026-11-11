package test;

import dominio.Prenda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPrenda {

    private Prenda prenda;

    @BeforeEach
    public void setUp() {
        // Objeto base para pruebas con datos correctos
        prenda = new Prenda(1, "Jean", "Azul", true, "Casual", "Templado");
    }

    //Tests de Constructores
    @Test
    public void testConstructorDefecto() {
        Prenda pDefecto = new Prenda();

        assertEquals(0, pDefecto.getIdPrenda());
        assertEquals("Nueva Prenda", pDefecto.getNombre());
        assertEquals("Blanco", pDefecto.getColor());
        assertTrue(pDefecto.isDisponibleLimpia());
        assertEquals("Casual", pDefecto.getOcasionUso());
        assertEquals("Templado", pDefecto.getTipoClimaIdeal());
        assertNull(pDefecto.getClasificacion());
        assertNull(pDefecto.getFoto());
    }

    @Test
    public void testConstructorParametrizado() {
        assertEquals(1, prenda.getIdPrenda());
        assertEquals("Jean", prenda.getNombre());
        assertEquals("Azul", prenda.getColor());
        assertTrue(prenda.isDisponibleLimpia());
        assertEquals("Casual", prenda.getOcasionUso());
        assertEquals("Templado", prenda.getTipoClimaIdeal());
    }

    //  Tests de Setters (Caminos Felices)
    @Test
    public void testSetNombreValido() {
        prenda.setNombre("Camiseta Polo");
        assertEquals("Camiseta Polo", prenda.getNombre());
    }

    @Test
    public void testSetColorValido() {
        prenda.setColor("Negro");
        assertEquals("Negro", prenda.getColor());
    }

    @Test
    public void testSetOcasionUsoValido() {
        prenda.setOcasionUso("Oficina");
        assertEquals("Oficina", prenda.getOcasionUso());
    }

    @Test
    public void testSetTipoClimaIdealValido() {
        prenda.setTipoClimaIdeal("Frío");
        assertEquals("Frío", prenda.getTipoClimaIdeal());
    }

    @Test
    public void testSetDisponibleLimpia() {
        prenda.setDisponibleLimpia(false);
        assertFalse(prenda.isDisponibleLimpia());
    }

    // Tests de Validadores (Caminos Tristes)
    /* En la clase Prenda, si la validación falla (ej. Validador.validarCaracteres(nombre) es false),
    la variable simplemente no se actualiza y conserva el valor anterior. */

    @Test
    public void testSetNombreInvalido() {
        String nombreAntes = prenda.getNombre(); // "Jean"

        // Asumiendo que el Validador rechaza números
        prenda.setNombre("Jean 123");
        assertEquals(nombreAntes, prenda.getNombre(), "El nombre no debió cambiar si contiene números");
    }

    @Test
    public void testSetColorInvalido() {
        String colorAntes = prenda.getColor(); // "Azul"

        // Asumiendo que el Validador rechaza caracteres especiales
        prenda.setColor("Azul@");
        assertEquals(colorAntes, prenda.getColor(), "El color no debió cambiar si contiene caracteres especiales");
    }

    @Test
    public void testSetOcasionUsoInvalida() {
        String ocasionAntes = prenda.getOcasionUso(); // "Casual"

        // Ocasión no contemplada en el Validador
        prenda.setOcasionUso("Fiesta");
        assertEquals(ocasionAntes, prenda.getOcasionUso(), "La ocasión no debió cambiar si no está en el catálogo");
    }

    @Test
    public void testSetTipoClimaIdealInvalido() {
        String climaAntes = prenda.getTipoClimaIdeal(); // "Templado"

        // Clima no contemplado en el Validador
        prenda.setTipoClimaIdeal("Nieve");
        assertEquals(climaAntes, prenda.getTipoClimaIdeal(), "El clima no debió cambiar si no está en el catálogo");
    }

    // Tests de Métodos de Acción
    @Test
    public void testMetodosConsolaNoFallan() {
        // Para metodos que solo imprimen en consola, verificamos que no rompan el programa
        assertDoesNotThrow(() -> prenda.crearPrenda(), "crearPrenda no debe lanzar excepciones");
        assertDoesNotThrow(() -> prenda.actualizarPrenda(), "actualizarPrenda no debe lanzar excepciones");
        assertDoesNotThrow(() -> prenda.eliminarPrenda(), "eliminarPrenda no debe lanzar excepciones");
    }
}