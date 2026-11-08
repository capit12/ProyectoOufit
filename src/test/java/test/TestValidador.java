package test;

import util.Validador;

public class TestValidador {
    private void comprobar(String descripcion, boolean obtenido, boolean esperado) {
        System.out.println((obtenido == esperado ? "[OK]    " : "[FALLA] ") + descripcion + " -> " + obtenido);
    }

    public void probarClase() {
        System.out.println("[EJECUTANDO CÓDIGO TEST]: VALIDADOR (REGEX)");
        comprobar("correo 'jcuzco@uce.edu.ec'", Validador.validarCorreo("jcuzco@uce.edu.ec"), true);
        comprobar("correo 'sin-arroba'", Validador.validarCorreo("sin-arroba"), false);
        comprobar("entero positivo '15'", Validador.validarEnteroPositivo("15"), true);
        comprobar("entero positivo '1.5'", Validador.validarEnteroPositivo("1.5"), false);
        comprobar("valoración '5'", Validador.validarValoracion("5"), true);
        comprobar("valoración '6'", Validador.validarValoracion("6"), false);
        comprobar("talla 'm'", Validador.validarTalla("m"), true);
        comprobar("talla 'XXL'", Validador.validarTalla("XXL"), false);
        comprobar("ocasión 'Oficina'", Validador.validarOcasion("Oficina"), true);
        comprobar("clima 'frio'", Validador.validarClimaIdeal("frio"), true);
        comprobar("fecha '25/12/2026 18:30'", Validador.validarFechaHora("25/12/2026 18:30"), true);
        comprobar("fecha '07:00'", Validador.validarFechaHora("07:00"), true);
        comprobar("fecha '32/13/2026 25:61'", Validador.validarFechaHora("32/13/2026 25:61"), false);
        comprobar("contraseña 'ab c'", Validador.validarContrasenia("ab c"), false);
        comprobar("uri 'fotos/a.webp'", Validador.validarUriImagen("fotos/a.webp"), true);
        comprobar("uri 'a.pdf'", Validador.validarUriImagen("a.pdf"), false);
        System.out.println("Formato extraído de 'x/y/Foto.JPEG': " + Validador.extraerFormatoImagen("x/y/Foto.JPEG"));
        comprobar("contienePatron('Camisa','^cam')", Validador.contienePatron("Camisa", "^cam"), true);
        comprobar("esRegexValido('[')", Validador.esRegexValido("["), false);
    }
}