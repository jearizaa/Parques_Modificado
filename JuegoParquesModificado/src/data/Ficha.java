
package data;


public class Ficha {
    private String color;
    private Casilla posicion;
    private int avance;
    private boolean encarcelado;
    private boolean protegido;

    public Ficha(String color){
        Tablero tablero = new Tablero();
        this.color = color;
        this.avance = 0;
        this.encarcelado = true;
        this.protegido = true;
        this.posicion = tablero.mapearCasillas(this.color, this.avance);
    }
    
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Casilla getPosicion() {
        return posicion;
    }

    public void setPosicion(Casilla posicion) {
        this.posicion = posicion;
    }

    public int getAvance() {
        return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }

    public boolean isEncarcelado() {
        return encarcelado;
    }

    public void setEncarcelado(boolean encarcelado) {
        this.encarcelado = encarcelado;
    }

    public boolean isProtegido() {
        return protegido;
    }

    public void setProtegido(boolean protegido) {
        this.protegido = protegido;
    }
    
    @Override
    public String toString(){
        return "Equipo: "+this.getColor()+" \nCasillas para ganar: "+Integer.toString(72-this.avance)+" \nPosicion: " + this.getPosicion()+"\n";
    }
    
}
