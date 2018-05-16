/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author hp
 */
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
