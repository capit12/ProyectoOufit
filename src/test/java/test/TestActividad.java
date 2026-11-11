package test;

import dominio.Actividad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestActividad {

    private Actividad actividad;

    @BeforeEach
    public void setUp() {
        // Configuramos una actividad válida antes de cada prueba
        // Usamos los mismos datos de la prueba manual original
        actividad = new Actividad(5, "Clases", "07:00", "Formal");
    }

    // Tests de Constructores
    @Test
    public void testConstructorDefecto() {
        Actividad aDefecto = new Actividad();

        assertEquals(0, aDefecto.getIdActividad());
        assertEquals("Evento General", aDefecto.getNombreActividad());
        assertEquals("00:00", aDefecto.getFechaHora());
        assertEquals("Casual", aDefecto.getTipoOcasion());
    }

    @Test
    public void testConstructorParametrizado() {
        assertEquals(5, actividad.getIdActividad());
        assertEquals("Clases", actividad.getNombreActividad());
        assertEquals("07:00", actividad.getFechaHora());
        assertEquals("Formal", actividad.getTipoOcasion());
    }

    // Tests de Setters (Caminos Felices)
    @Test
    public void testSetIdActividad() {
        actividad.setIdActividad(12);
        assertEquals(12, actividad.getIdActividad());
    }

    @Test
    public void testSetNombreActividadValido() {
        actividad.setNombreActividad("Reunion Universidad");
        assertEquals("Reunion Universidad", actividad.getNombreActividad());
    }

    @Test
    public void testSetFechaHoraValida() {
        // Acepta formato completo DD/MM/YYYY HH:mm
        actividad.setFechaHora("25/11/2026 14:30");
        assertEquals("25/11/2026 14:30", actividad.getFechaHora());
    }

    @Test
    public void testSetTipoOcasionValida() {
        actividad.setTipoOcasion("Deporte");
        assertEquals("Deporte", actividad.getTipoOcasion());
    }

    // Tests de Validadores (Caminos Tristes)
    @Test
    public void testSetNombreActividadInvalido() {
        String nombreAntes = actividad.getNombreActividad(); // "Clases"

        // No debe aceptar números
        actividad.setNombreActividad("Clase 101");

        assertEquals(nombreAntes, actividad.getNombreActividad(), "El nombre no debió cambiar porque tiene números");
    }

    @Test
    public void testSetFechaHoraInvalida() {
        String fechaAntes = actividad.getFechaHora(); // "07:00"

        // Formato incorrecto (horas imposibles)
        actividad.setFechaHora("25:99");

        assertEquals(fechaAntes, actividad.getFechaHora(), "La fecha/hora no debió cambiar si el formato es irreal");
    }

    @Test
    public void testSetTipoOcasionInvalida() {
        String ocasionAntes = actividad.getTipoOcasion(); // "Formal"

        // Ocasión no contemplada en el Validador (solo acepta Oficina, Casual o Deporte, o Formal en tu base)
        actividad.setTipoOcasion("Gala");

        assertEquals(ocasionAntes, actividad.getTipoOcasion(), "La ocasión no debió cambiar si no está permitida");
    }

    // Tests de Métodos de Acción
    @Test
    public void testMetodosConsolaNoFallan() {
        // Verificamos que los métodos de impresión se ejecuten sin lanzar excepciones
        assertDoesNotThrow(() -> actividad.registrarActividad(), "registrarActividad no debe fallar");
        assertDoesNotThrow(() -> actividad.modificarActividad(), "modificarActividad no debe fallar");
        assertDoesNotThrow(() -> actividad.eliminarActividad(), "eliminarActividad no debe fallar");
    }
}