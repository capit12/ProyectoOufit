package test;

import dominio.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestUsuario {

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        // Configuramos un usuario válido antes de cada prueba
        usuario = new Usuario(1, "Pablo Canchignia", "pablo@uce.edu.ec", "secreta123");
    }

    // Tests de Constructores
    @Test
    public void testConstructorDefecto() {
        Usuario uDefecto = new Usuario();

        assertEquals(0, uDefecto.getIdUsuario());
        assertEquals("Sin Nombre", uDefecto.getNombre());
        assertEquals("sin@correo.com", uDefecto.getCorreo());
        assertEquals("1234", uDefecto.getContrasenia());
        assertNull(uDefecto.getPerfil());
    }

    @Test
    public void testConstructorParametrizado() {
        assertEquals(1, usuario.getIdUsuario());
        assertEquals("Pablo Canchignia", usuario.getNombre());
        assertEquals("pablo@uce.edu.ec", usuario.getCorreo());
        assertEquals("secreta123", usuario.getContrasenia());
    }

    // Tests de Setters y Getters (Caminos Felices)
    @Test
    public void testSetIdUsuario() {
        usuario.setIdUsuario(99);
        assertEquals(99, usuario.getIdUsuario());
    }

    @Test
    public void testSetNombreValido() {
        usuario.setNombre("Esteban Lema");
        assertEquals("Esteban Lema", usuario.getNombre());
    }

    @Test
    public void testSetCorreoValido() {
        usuario.setCorreo("nuevo@correo.com");
        assertEquals("nuevo@correo.com", usuario.getCorreo());
    }

    @Test
    public void testSetContraseniaValida() {
        usuario.setContrasenia("nuevaPass456");
        assertEquals("nuevaPass456", usuario.getContrasenia());
    }

    // Tests de Validadores (Caminos Tristes)
    /* Nota: Como tus validadores devuelven void y modifican o ignoran el valor,
     verificamos que la variable interna cambie (o no cambie) según lo esperado.
     */

    @Test
    public void testSetCorreoInvalido() {
        // Según la clase Usuario, un correo inválido se reemplaza por "correo.invalido@uce.edu.ec"
        usuario.setCorreo("correo-sin-arroba");
        assertEquals("correo.invalido@uce.edu.ec", usuario.getCorreo());
    }

    @Test
    public void testIniciarSesion() {
        // Verifica que el metodo iniciarSesion retorne true como está definido
        assertTrue(usuario.iniciarSesion());
    }
}