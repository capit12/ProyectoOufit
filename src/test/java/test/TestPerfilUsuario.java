package test;

import dominio.PerfilUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPerfilUsuario {

    private PerfilUsuario perfil;

    @BeforeEach
    public void setUp() {
        // Configuramos un perfil inicial válido antes de cada prueba
        perfil = new PerfilUsuario(1, "Formal", "L", "Quito");
    }

    //  Tests de Constructores
    @Test
    public void testConstructorDefecto() {
        PerfilUsuario pDefecto = new PerfilUsuario();

        assertEquals(0, pDefecto.getIdPerfil());
        assertEquals("Casual", pDefecto.getEstiloPreferido());
        assertEquals("M", pDefecto.getTalla());
        assertEquals("Quito", pDefecto.getCiudadUbicacion());
    }

    @Test
    public void testConstructorParametrizado() {
        assertEquals(1, perfil.getIdPerfil());
        assertEquals("Formal", perfil.getEstiloPreferido());
        assertEquals("L", perfil.getTalla());
        assertEquals("Quito", perfil.getCiudadUbicacion());
    }

    //  Tests de Setters (Caminos Felices)
    @Test
    public void testSetIdPerfil() {
        perfil.setIdPerfil(5);
        assertEquals(5, perfil.getIdPerfil());
    }

    @Test
    public void testSetEstiloPreferidoValido() {
        perfil.setEstiloPreferido("Casual");
        assertEquals("Casual", perfil.getEstiloPreferido());
    }

    @Test
    public void testSetTallaValida() {
        // Probamos enviando una talla en minúscula
        perfil.setTalla("s");

        // Verificamos que se guarde correctamente y convertida a mayúscula
        assertEquals("S", perfil.getTalla(), "La talla debió guardarse en mayúsculas");
    }

    @Test
    public void testSetCiudadUbicacionValida() {
        perfil.setCiudadUbicacion("Guayaquil");
        assertEquals("Guayaquil", perfil.getCiudadUbicacion());
    }

    // Tests de Validadores (Caminos Tristes)
    @Test
    public void testSetEstiloPreferidoInvalido() {
        String estiloAntes = perfil.getEstiloPreferido(); // "Formal"

        // Estilo no permitido por tu Validador (solo Casual o Formal)
        perfil.setEstiloPreferido("Deportivo");

        assertEquals(estiloAntes, perfil.getEstiloPreferido(), "El estilo no debió cambiar");
    }

    @Test
    public void testSetTallaInvalida() {
        String tallaAntes = perfil.getTalla(); // "L"

        // Talla no permitida (solo XS, S, M, L, XL)
        perfil.setTalla("XXL");

        assertEquals(tallaAntes, perfil.getTalla(), "La talla no debió cambiar al ser inválida");
    }

    @Test
    public void testSetCiudadUbicacionInvalida() {
        String ciudadAntes = perfil.getCiudadUbicacion(); // "Quito"

        // Ciudad con números (rechazado por validarCaracteres)
        perfil.setCiudadUbicacion("Quito 123");

        assertEquals(ciudadAntes, perfil.getCiudadUbicacion(), "La ciudad no debió cambiar");
    }

    // Tests de Métodos de Acción
    @Test
    public void testMetodosConsolaNoFallan() {
        // Verificamos que los métodos que imprimen en consola se ejecuten sin lanzar excepciones
        assertDoesNotThrow(() -> perfil.actualizarPerfil(), "actualizarPerfil no debe fallar");
        assertDoesNotThrow(() -> perfil.guardarPreferencias(), "guardarPreferencias no debe fallar");
    }
}