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
public class Jugador {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
    
    @Override
    public String toString(){
        return "Nombre jugador: "+this.getNombre()+"\n";
    }
    
}
