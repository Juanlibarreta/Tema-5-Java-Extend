package Apliaciones;

import clases.figuras.Cuadrado;

public class Pr2 {
    Cuadrado c;
    public Pr2(){
        c = new Cuadrado(5);
    }

    public static void main(String[] args) {
        Pr2 app = new Pr2();
        app.inicio();
    }

    private void inicio() {
        c.setRelleno('+');
        System.out.println(c.dimension());
        System.out.println(c.dibujar());
        c.setAncho(c.getAncho()+1);
        System.out.println(c.dimension());
        System.out.println(c.dibujar());
        c.setLado(8);
        c.setGirado(true);
        System.out.println(c.dibujar());
    }
}
