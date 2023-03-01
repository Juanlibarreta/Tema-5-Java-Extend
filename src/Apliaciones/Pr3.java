package Apliaciones;

import clases.figuras.Caja;

public class Pr3 {
    Caja c;
    
    public Pr3(){
        c = new Caja(4, 5, 3);
    }

    public static void main(String[] args) {
        Pr3 app = new Pr3();
        app.inicio();
    }

    private void inicio() {
        System.out.println(c.esCubo());
        System.out.println(c.equals(Caja.DIEZ));
        System.out.println(c.equals(Caja.UNO));
        c.setLargo(c.getLargo()+2).setAncho(c.getAncho()+2).setAlto(c.getAlto()+1);
        System.out.println(c.dimension());
        c.restaurar();
        System.out.println(c.dimension());
        Caja j = Caja.sumar(Caja.UNO, Caja.DIEZ);
        Caja z = Caja.sumar(j, c);
        System.out.println(z.dimension());
    }
}
