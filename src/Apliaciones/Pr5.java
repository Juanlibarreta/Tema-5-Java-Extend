package Apliaciones;

import JLISV.LIB;
import clases.Persona;

public class Pr5 {
    Persona p;
    public Pr5(){
        boolean f = false;
        while(!f){
            try {
                p = new Persona(LIB.lLinea("Nombre: "),
                                LIB.lInt("Edad: "), 
                                LIB.lDouble("Altura: "),
                                 LIB.lDouble("Peso: "));
                f = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        Pr5 app = new Pr5();
        app.inicio();
    }
    private void inicio() {
        System.out.println(p.toString());
    }
}
