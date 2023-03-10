package clases.figuras;

import java.beans.PropertyVetoException;

public final class Cuadrado extends Rectangulo{
    private boolean girado = false;

    public boolean getGirado(){
        return girado;
    }

    public int getLado(){
        return getAlto();
    }

    public Cuadrado setGirado(boolean girado){
        try {
            cambiandose.fireVetoableChange("girado", this.girado, girado);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        boolean antiguo = this.girado;
        this.girado = girado;
        cambio.firePropertyChange("girado", antiguo, this.girado);
        return this;
    }

    public Cuadrado setLado(int lado){
        try {
            cambiandose.fireVetoableChange("lado", getAlto(), lado);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        int antiguo = getAlto();
        setAlto(lado);
        cambio.firePropertyChange("lado", antiguo, lado);
        return this; 
    }

    @Override
    public Cuadrado setAncho(int lado){
        int anchoAntiguo = getAncho();
        super.setAncho(lado);
        if(getAncho() != getAlto()){
            super.setAlto(lado);
        }
        cambio.firePropertyChange("ancho", anchoAntiguo, getAncho());
        return this;
    }

    @Override
    public Cuadrado setAlto(int lado){
        int altoAntiguo = getAlto();
        super.setAlto(lado);
        if(getAlto() != getAncho()){
            super.setAncho(lado);
        }
        cambio.firePropertyChange("alto", altoAntiguo, getAlto());
        return this;
    }

    public Cuadrado(int lado){
        setLado(lado);
    }

    public Cuadrado(int lado, boolean girado){
        setLado(lado);
        setGirado(girado);
    }

    public Cuadrado(int lado, char borde, char relleno){
        super(borde, relleno);
        setLado(lado);
    }

    public Cuadrado(Cuadrado cuadrado){
        setGirado(cuadrado.getGirado());
        setLado(cuadrado.getLado());
    }
    @Override
    public String dibujar(){
        String s = "";
        if(girado){
            for (int i = 0; i < getLado()*2; i++) {
                for (int j = 0; j < getLado()*2; j++) {
                    if(i < getLado()){
                        if(j == getLado() && i == 0){
                            s += getBorde() + " ";
                        }else if(j == getLado() + i || j == getLado() - i){
                            s += getBorde() + " ";
                        }else if(j < getLado() + i && j > getLado() - i){
                            s+= getRelleno() + " ";
                        }else{
                            s += " " + " ";
                        }
                    }else{
                        if(i > getLado()){
                            if(j == getLado() - (getLado()*2 -1- i) || j == getLado() + (getLado()*2 -1-i)){
                               s += getBorde() + " ";
                            }else if(j > getLado() - (getLado()*2 -1- i) && j < getLado() + (getLado()*2 -1- i)){
                               s += getRelleno() + " ";
                            }else{
                               s += " " + " ";
                            }
                        }
                    }
                }
                if(i != getLado()){
                    s+= "\n";
                }
            }
        }else{
            s += super.dibujar();
        }
        return s;
    }

    @Override
    public String dimension(){
        return "lado = " + getLado();
    }

    @Override
    public String toString(){
        String s = "";
        s += super.toString();
        s += "LADO: " + getLado() + "\n";
        s += "GIRADO: " + getGirado() + "\n";
        return s;
    }

    @Override
    public int compareTo(Rectangulo o) {
        if(o instanceof Cuadrado){
            Cuadrado c = (Cuadrado) o;
            if(this.getLado() < c.getLado())return -1;
            if(this.getLado() > c.getLado()) return 1;
            return 0;
        }
        return super.compareTo(o);
    }

    @Override
    public Cuadrado clone(){
        return (Cuadrado) super.clone();
    }
}
