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
public class Equipo {
    
    private Ficha[] fichas;
    
    
    public Equipo(){
        fichas = new Ficha[4];
    }    

    
    public Ficha[] getFichas() {
        return fichas;
    }

    public void setFichas(Ficha[] fichas) {
        this.fichas = fichas;
    }
     
    
    
    public void usarPoder(){
    }
    
}
