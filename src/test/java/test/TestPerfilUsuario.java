package test;

import dominio.PerfilUsuario;

public class TestPerfilUsuario {
    public void probarClase() {
        System.out.println("[EJECUTANDO CÓDIGO TEST]: CLASE PERFIL");
        PerfilUsuario p1 = new PerfilUsuario();
        PerfilUsuario p2 = new PerfilUsuario(2, "Formal", "L", "Quito");

        p2.actualizarPerfil();
        p2.guardarPreferencias();
    }
}