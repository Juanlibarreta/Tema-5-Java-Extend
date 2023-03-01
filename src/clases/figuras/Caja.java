package clases.figuras;

import java.beans.PropertyVetoException;

public class Caja extends Rectangulo{
    public static final Caja UNO;
    public static final Caja DIEZ;
    public static final int NUMERO_DE_CARAS;
    public final int LARGO_INICIAL;
    private int largo = 2;
    static{
        NUMERO_DE_CARAS = 12;
        UNO = new Caja(2, 2, 2);
        DIEZ = new Caja(10, 10, 10);
    }

    public int getLargo(){
        return largo;
    }

    public Caja setLargo(int largo){
        if(largo < 2){
            throw new Caja.FueraDeRangoException("Numero debe ser mayor de 2");
        }
        try {
            getCambiandose().fireVetoableChange("largo", this.largo,largo);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        int antiguo = this.largo;
        this.largo = largo;
        getCambio().firePropertyChange("largo",antiguo,this.largo);
        return this;
    }

    public Caja(int largo, int alto, int ancho){
        super(ancho, alto);
        setLargo(largo);
        LARGO_INICIAL = getLargo();
    }
    public Caja(int largo){
        setLargo(largo);
        LARGO_INICIAL = getLargo();
    }
    public Caja(){
        LARGO_INICIAL = getLargo();
    }
    public Caja(int alto, int ancho, int largo, char borde, char relleno){
        super(ancho, alto,borde,relleno);
        setLargo(largo);
        LARGO_INICIAL = getLargo();
    }
    public Caja(Caja c){
        super(c.getAlto(),c.getAncho(),c.getBorde(),c.getRelleno());
        setLargo(c.getLargo());
        LARGO_INICIAL = c.LARGO_INICIAL;
    }

    public int volumen(){
        return getLargo()*getAlto()*getAncho();
    }

    public boolean esCubo(){
        if(getLargo()==getAncho() && getAncho()== getAlto()) return true;
        return false;
    }

    public static final Caja sumar(Caja c1, Caja c2){
         return  new Caja(c1.getLargo()+c2.getLargo(),
                            c1.getAncho()+c2.getAncho(),
                            c1.getAncho()+c2.getAncho());
    }

    @Override
    public Caja plus(){
        super.plus();
        setLargo(getLargo()+1);
        return this;
    }

    @Override
    public String dimension(){
        return getLargo() + " X " + super.dimension();
    }

    @Override
    public final String dibujar(){
        String s = "";

        return s;
    }

    @Override
    public Caja restaurar(){
        super.restaurar();
        setLargo(LARGO_INICIAL);
        return this;
    }

    @Override
    public int compareTo(Rectangulo r){
        if(r instanceof Caja){
            Caja c = (Caja) r;
            if(this.volumen() < c.volumen()) return -1;
            if(this.volumen() > c.volumen()) return 1;
            return 0;
        }
        return super.compareTo(r);
    }

    @Override
    public final boolean equals(Object o){
        if(o instanceof Caja){
            Caja c = (Caja) o;
            if(volumen() != c.volumen()) return false;
            return true;
        }else if(o instanceof Rectangulo){
            return super.equals(o);
        }else if(o == null){
            throw new NullPointerException();
        }else{
            throw new IllegalArgumentException();
        }
    }
}
