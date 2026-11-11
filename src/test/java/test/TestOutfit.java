package test;

import dominio.Outfit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestOutfit {

    private Outfit outfit;

    @BeforeEach
    public void setUp() {
        // Configuramos un outfit parametrizado antes de cada prueba
        outfit = new Outfit(1, "Martes", 4);
    }

    // Tests de Constructores
    @Test
    public void testConstructorDefecto() {
        Outfit oDefecto = new Outfit();

        assertEquals(0, oDefecto.getIdOutfit());
        assertEquals("Lunes", oDefecto.getDiaSemana());
        assertEquals(5, oDefecto.getValoracion());
    }

    @Test
    public void testConstructorParametrizado() {
        assertEquals(1, outfit.getIdOutfit());
        assertEquals("Martes", outfit.getDiaSemana());
        assertEquals(4, outfit.getValoracion());
    }

    // Tests de Setters y Getters
    @Test
    public void testSetIdOutfit() {
        outfit.setIdOutfit(10);
        assertEquals(10, outfit.getIdOutfit());
    }

    @Test
    public void testSetDiaSemana() {
        outfit.setDiaSemana("Viernes");
        assertEquals("Viernes", outfit.getDiaSemana());
    }

    @Test
    public void testSetValoracion() {
        outfit.setValoracion(3);
        assertEquals(3, outfit.getValoracion());
    }

    // Tests de Métodos de Acción
    @Test
    public void testValorarOutfit() {
        // El metodo valorarOutfit debe actualizar la variable interna "valoracion"
        outfit.valorarOutfit(2);
        assertEquals(2, outfit.getValoracion(), "La valoración debería actualizarse a 2");
    }

    @Test
    public void testMetodosConsolaNoFallan() {
        // Para métodos que solo hacen System.out.println, verificamos que no rompan el programa
        assertDoesNotThrow(() -> outfit.generarOutfitSemanal(), "generarOutfitSemanal no debe lanzar excepciones");
        assertDoesNotThrow(() -> outfit.modificarSugerencia(), "modificarSugerencia no debe lanzar excepciones");
    }
}