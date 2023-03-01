package Apliaciones;

import JLISV.LIB;
import clases.figuras.Rectangulo;

public class Pr4 {
    Rectangulo r;

    public Pr4(){
        boolean f = false;
        while(!f){
            try {
                r = new Rectangulo(LIB.lInt("Alto: "),
                 LIB.lInt("Ancho: "),
                  LIB.lChar("Relleno: "),
                  LIB.lChar("Borde: "));
                f = true;
            } catch (Rectangulo.FueraDeRangoException e) {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        Pr4 app = new Pr4();
        app.inicio();
    }
    private void inicio() {
        System.out.println(r.dibujar());
    }
}
