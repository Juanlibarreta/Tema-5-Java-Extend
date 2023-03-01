import clases.Persona;
import clases.figuras.Cuadrado;

public class Tema5 {
    Cuadrado c;
    Persona p;
    public Tema5(){
        c = new Cuadrado(6,true);
        p = new Persona();
    }

    public static void main(String[] args) throws Exception {
        Tema5 app = new Tema5();
        app.inicio();
    }

    private void inicio() {
        p.setEdad(-2);
    }
}
