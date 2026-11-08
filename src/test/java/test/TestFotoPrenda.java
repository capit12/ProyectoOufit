package test;

import dominio.FotoPrenda;

public class TestFotoPrenda {
    public void probarClase() {
        System.out.println("[EJECUTANDO CÓDIGO TEST]: CLASE FOTO PRENDA");
        FotoPrenda f1 = new FotoPrenda();
        FotoPrenda f2 = new FotoPrenda(1, "fotos/camisa_azul.PNG", true);

        System.out.println("Formato deducido por regex: " + f2.getFormato());
        f2.setUriImagen("documento.pdf");  // inválida: se ignora
        System.out.println("URI conservada: " + f2.getUriImagen());
        System.out.println("Fondo eliminado: " + f2.isFondoEliminado() + " | Foto por defecto: [" + f1.getFormato() + "]");
    }
}