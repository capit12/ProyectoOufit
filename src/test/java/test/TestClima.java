package test;

import dominio.Clima;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestClima {

    private Clima clima;

    @BeforeEach
    public void setUp() {
        // Inicializamos un clima lluvioso antes de cada prueba
        clima = new Clima(1, 12.5, 80.0, "Lluvia");
    }

    // Tests de Constructores
    @Test
    public void testConstructorDefecto() {
        Clima cDefecto = new Clima();

        assertEquals(0, cDefecto.getIdClima());
        assertEquals(15.0, cDefecto.getTemperatura(), 0.001); // Se usa delta para los double
        assertEquals(20.0, cDefecto.getProbabilidadLluvia(), 0.001);
        assertEquals("Despejado", cDefecto.getTipoClima());
    }

    @Test
    public void testConstructorParametrizado() {
        assertEquals(1, clima.getIdClima());
        assertEquals(12.5, clima.getTemperatura(), 0.001);
        assertEquals(80.0, clima.getProbabilidadLluvia(), 0.001);
        assertEquals("Lluvia", clima.getTipoClima());
    }

    // Tests de Setters
    @Test
    public void testSetIdClima() {
        clima.setIdClima(5);
        assertEquals(5, clima.getIdClima());
    }

    @Test
    public void testSetTemperatura() {
        clima.setTemperatura(22.4);
        assertEquals(22.4, clima.getTemperatura(), 0.001);
    }

    @Test
    public void testSetProbabilidadLluvia() {
        clima.setProbabilidadLluvia(10.5);
        assertEquals(10.5, clima.getProbabilidadLluvia(), 0.001);
    }

    @Test
    public void testSetTipoClima() {
        clima.setTipoClima("Nublado");
        assertEquals("Nublado", clima.getTipoClima());
    }

    //  Tests de Lógica de Negocio y Límites
    @Test
    public void testVerificarLluviaTrue() {
        // El clima del setUp tiene 80.0 de probabilidad, debe retornar true
        assertTrue(clima.verificarLluvia(), "Debe retornar true si la probabilidad es mayor a 50%");
    }

    @Test
    public void testVerificarLluviaFalse() {
        // Límite exacto: no debe llover si es exactamente 50.0
        clima.setProbabilidadLluvia(50.0);
        assertFalse(clima.verificarLluvia(), "Debe retornar false si la probabilidad es exactamente 50%");

        // Menor al límite
        clima.setProbabilidadLluvia(49.9);
        assertFalse(clima.verificarLluvia(), "Debe retornar false si la probabilidad es menor a 50%");
    }

    @Test
    public void testConsultarPronostico() {
        // Verificamos que el metodo de consola se ejecute sin errores (no lance excepciones)
        assertDoesNotThrow(() -> clima.consultarPronostico());
    }
}