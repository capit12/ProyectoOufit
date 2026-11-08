package test;

import dominio.Usuario;

public class TestUsuario {
    public void probarClase() {
        System.out.println("EJECUTANDO CÓDIGO TEST: CLASE USUARIO ");

        Usuario u1 = new Usuario();
        System.out.println("Nombre por defecto inicializado: " + u1.getNombre());

        Usuario u2 = new Usuario(10, "Juan Cuzco", "jcuzco@uce.edu.ec", "root");
        System.out.println("Nombre parametrizado asignado: " + u2.getNombre());

        u2.crearCuenta();
        System.out.println("Simulación inicio sesión: " + u2.iniciarSesion());
        u2.eliminarCuenta();
    }
}