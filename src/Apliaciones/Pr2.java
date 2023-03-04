package Apliaciones;

import java.beans.PropertyChangeEvent;

import clases.figuras.Cuadrado;
import clases.figuras.Rectangulo;

public class Pr2 {
    Cuadrado c;
    public Pr2(){
        c = new Cuadrado(5);

        c.addPropertyChangeListener("ancho", v-> onMostrarAlto(v));
        c.addPropertyChangeListener("alto", v-> onMostrarAncho(v));
    }

    public void onMostrarAncho(PropertyChangeEvent v) {
        System.out.println("Ancho: "  + c.getAncho() + " Alto: " + c.getAlto());
        System.out.println("Anterior Alto: " + v.getOldValue() + " Nuevo Alto: " + v.getNewValue());
    }

    public void onMostrarAlto(PropertyChangeEvent v) {
        System.out.println("Ancho: "  + c.getAncho() + " Alto: " + c.getAlto());
        System.out.println("Anterior Ancho: " + v.getOldValue() + " Nuevo Ancho: " + v.getNewValue());
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
        try {
            c.setLado(-5);
        } catch (Rectangulo.FueraDeRangoException e) {
            System.out.println(e);
        }
    }
}
