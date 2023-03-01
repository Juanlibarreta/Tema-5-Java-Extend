package Apliaciones;

import clases.figuras.Caja;
import clases.figuras.Cuadrado;
import clases.figuras.Rectangulo;

public class Pr6 {
    Object r1;
    Object c1;
    Object c2;
    Object ca;
    Object r2;
    public Pr6(){
        r1 = new Rectangulo(3,7);
        c1 = new Cuadrado(5);
        c2 = new Cuadrado(4);
        ca = new Caja(4,2,9);
        r2 = new Rectangulo();
    }

    
    private void inicio() {
        Object[] o = new Object[5];
        o[0] = r1;
        o[1] = c1;
        o[2] = c2;
        o[3] = ca;
        o[4] = r2;

        for (int i = 0; i < o.length; i++) {
            System.out.println(o[i].getClass().getName());
            System.out.println(((Rectangulo) o[i]).dimension());
        }
    }

    public static void main(String[] args) {
        Pr6 app = new Pr6();
        app.inicio();
    }

}
