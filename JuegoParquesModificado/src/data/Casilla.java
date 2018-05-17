
package data;

public class Casilla {
    private String color;
    private String tipo;

    public Casilla(){
        this.tipo = "REGULAR";
        this.color = "";
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
    
    @Override
    public String toString(){
        return "Casilla de color "+this.getColor()+"\nCasilla de tipo "+this.getTipo()+"\n";
    }
    
}
