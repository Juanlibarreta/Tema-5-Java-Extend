package Apliaciones;

import clases.*;
import clases.enumerados.Licenciatura;

public class Pr1 {
    Profesor pr;
    Profesor pr2;
    Persona p;

    public Pr1(){

    }

    public static void main(String[] args) {
        Pr1 app = new Pr1();
        app.inicio();
    }

    public void inicio() {
        pr = new Profesor("JUAN");
        pr2 = new Profesor("ELENA", Licenciatura.Matematicas);
        p = new Persona("JUAN");

        System.out.println(pr.compareTo(p));
        System.out.println(pr.compareTo(pr2));

    }
}
