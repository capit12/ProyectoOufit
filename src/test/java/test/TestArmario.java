package test;

import dominio.Armario;
import dominio.Prenda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestArmario {

    private Armario armario;
    private Prenda prenda1;
    private Prenda prenda2;
    private Prenda prenda3;

    @BeforeEach
    public void setUp() {
        // Inicializamos el armario y algunas prendas para las pruebas
        armario = new Armario(1, "Armario Principal");

        prenda1 = new Prenda(1, "Camisa", "Azul", true, "Oficina", "Templado");
        prenda2 = new Prenda(2, "Jean", "Negro", true, "Casual", "Frío");
        prenda3 = new Prenda(3, "Camiseta", "Blanco", true, "Deporte", "Cálido");

        // Llenamos el armario base
        armario.agregarPrenda(prenda1);
        armario.agregarPrenda(prenda2);
        armario.agregarPrenda(prenda3);
    }

    // Tests de Constructores
    @Test
    public void testConstructorDefecto() {
        Armario aDefecto = new Armario();

        assertEquals(0, aDefecto.getIdArmario());
        assertEquals("Mi Armario", aDefecto.getNombreArmario());
        assertEquals(0, aDefecto.getTotalPrendas());
        assertTrue(aDefecto.estaVacio(), "El armario por defecto debería estar vacío");
    }

    @Test
    public void testConstructorParametrizado() {
        // Probamos un armario nuevo sin llenarlo aún
        Armario aParametrizado = new Armario(2, "Armario de Verano");

        assertEquals(2, aParametrizado.getIdArmario());
        assertEquals("Armario de Verano", aParametrizado.getNombreArmario());
        assertEquals(0, aParametrizado.getTotalPrendas());
    }

    // Tests de Setters (Caminos Felices y Tristes)
    @Test
    public void testSetNombreArmarioValido() {
        armario.setNombreArmario("Armario Deportivo");
        assertEquals("Armario Deportivo", armario.getNombreArmario());
    }

    @Test
    public void testSetNombreArmarioInvalido() {
        String nombreAntes = armario.getNombreArmario();
        armario.setNombreArmario("123 Armario"); // Contiene números, el validador lo rechaza
        assertEquals(nombreAntes, armario.getNombreArmario(), "El nombre no debió cambiar");
    }

    @Test
    public void testSetPrendas() {
        List<Prenda> nuevaLista = new ArrayList<>();
        nuevaLista.add(prenda1);

        armario.setPrendas(nuevaLista);

        assertEquals(1, armario.getPrendas().size());
        assertEquals(1, armario.getTotalPrendas(), "El total de prendas debe actualizarse al usar setPrendas");
    }

    // Tests de Lógica de Listas
    @Test
    public void testAgregarPrenda() {
        Prenda prenda4 = new Prenda(4, "Chaqueta", "Gris", true, "Casual", "Frío");
        armario.agregarPrenda(prenda4);

        assertEquals(4, armario.getPrendas().size());
        assertEquals(4, armario.getTotalPrendas());
    }

    @Test
    public void testEliminarPrenda() {
        // Eliminamos el elemento en el índice 0 (que es la Camisa Azul)
        Prenda eliminada = armario.eliminarPrenda(0);

        assertEquals("Camisa", eliminada.getNombre());
        assertEquals(2, armario.getPrendas().size());
        assertEquals(2, armario.getTotalPrendas());
    }

    @Test
    public void testEstaVacio() {
        assertFalse(armario.estaVacio());

        armario.eliminarPrenda(2);
        armario.eliminarPrenda(1);
        armario.eliminarPrenda(0);

        assertTrue(armario.estaVacio(), "El armario debería estar vacío tras eliminar todo");
    }

    // Tests de Búsqueda por Patrón (Regex)
    @Test
    public void testBuscarPrendasPorPatronColor() {
        // Debe encontrar "Azul" o "Negro"
        List<Prenda> resultados = armario.buscarPrendasPorPatron("azul|negro");
        assertEquals(2, resultados.size());
    }

    @Test
    public void testBuscarPrendasPorPatronNombre() {
        // Busca  palabras que empiecen por "ca" (Camisa, Camiseta)
        List<Prenda> resultados = armario.buscarPrendasPorPatron("^ca.*");
        assertEquals(2, resultados.size());
    }

    @Test
    public void testBuscarPrendasPorPatronSinResultados() {
        List<Prenda> resultados = armario.buscarPrendasPorPatron("Rojo");
        assertEquals(0, resultados.size());
    }

    @Test
    public void testBuscarPrendasPorPatronInvalido() {
        // Un patrón regex mal formado como "[" debería ser manejado por el Validador
        // y devolver 0 coincidencias en lugar de romper el programa.
        List<Prenda> resultados = armario.buscarPrendasPorPatron("[");
        assertEquals(0, resultados.size());
    }
}