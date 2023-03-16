package clases.figuras;

import java.beans.PropertyVetoException;

final public class Caja extends Rectangulo{
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
            throw new FueraDeRangoException("Numero debe ser mayor de 2");
        }
        try {
            cambiandose.fireVetoableChange("largo", this.largo,largo);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        int antiguo = this.largo;
        this.largo = largo;
        cambio.firePropertyChange("largo",antiguo,this.largo);
        return this;
    }

    public Caja(int largo, int ancho, int alto){
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

    public Caja(int largo, int ancho, int alto, char borde, char relleno){
        super(ancho, alto,borde,relleno);
        setLargo(largo);
        LARGO_INICIAL = getLargo();
    }

    public Caja(Caja c){
        super(c.getAncho(),c.getAlto(),c.getBorde(),c.getRelleno());
        setLargo(c.getLargo());
        LARGO_INICIAL = c.LARGO_INICIAL;
    }

    public int volumen(){
        return getLargo()*area();
    }

    public boolean esCubo(){
        return getLargo() == getAncho() && esCuadrado();
    }

    public static final Caja sumar(Caja c1, Caja c2){
        if(c1 == null && c2 == null) return null;
        if(c1 == null && c2 != null) return c2;
        if(c1 != null && c2 == null) return c1;

        Caja c = new Caja(c1.getLargo()+c2.getLargo(),
                            c1.getAncho()+c2.getAncho(),
                            c1.getAlto()+c2.getAlto());
        return c;
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
    public String dibujar(String v){
        String s = "";
        s += super.dibujar("BASE: \n");
        s += new Rectangulo(getLargo(),getAncho()).dibujar("CARA LATERAL: \n");
        s += new Rectangulo(getAlto(),getLargo()).dibujar("CARA FRONTAL: \n");
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

    @Override
    public Caja clone() {
        return (Caja) super.clone();
    }
    
    public static void main(String[] args) {
        Caja c = new Caja(7,5,6);
        System.out.println(c.dibujar(""));
    }
}
