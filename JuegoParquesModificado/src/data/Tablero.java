
package data;

public class Tablero {
    
    private Casilla[] tablero;
    
    public Tablero(){
        tablero = new Casilla[101];
    }

    public Casilla[] getTablero() {
        return tablero;
    }

    public void setTablero(Casilla[] tablero) {
        this.tablero = tablero;
    }
    
    public void actualizarCasillas(){
    
    }
    
}
