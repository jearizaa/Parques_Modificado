
package data;

import java.util.ArrayList;

public class Casilla {
    private String color;
    private String tipo;
    private int efecto;
    private ArrayList<Ficha> fichas = new ArrayList<>();

    public Casilla(){
        this.tipo = "REGULAR";
        this.color = "";
        this.efecto = 0;
    }    
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEfecto() {
        return efecto;
    }

    public void setEfecto(int efecto) {
        this.efecto = efecto;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }    
    
    @Override
    public String toString(){
        return "Casilla de color "+this.getColor()+"\nCasilla de tipo "+this.getTipo()+"\n"+"Efecto en fichas "+Integer.toString(this.getEfecto())+"\n";
    }
    
}
