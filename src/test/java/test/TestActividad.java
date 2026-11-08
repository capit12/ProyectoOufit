package test;

import dominio.Actividad;

public class TestActividad {
    public void probarClase() {
        System.out.println("[EJECUTANDO CÓDIGO TEST]: CLASE ACTIVIDAD");
        Actividad a1 = new Actividad();
        Actividad a2 = new Actividad(5, "Clases", "07:00", "Formal");

        a2.registrarActividad();
        a2.modificarActividad();
        a2.eliminarActividad();
    }
}