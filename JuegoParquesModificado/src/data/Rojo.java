
package data;

import java.util.HashSet;
import java.util.Set;

public class Rojo extends Equipo {
    
    public Rojo(){        
        this.setColor("ROJO");
        this.setHabilidadDisponible(true); 
        Ficha[] fichasRojas = new Ficha[4];
        for(int i = 0; i < fichasRojas.length; i++){
            Ficha ficha = new Ficha("ROJO");
            fichasRojas[i] = ficha;
        }
        this.setFichas(fichasRojas);
        this.setJugador(false);
    }
    

    @Override
    public void usarPoder(){
    
    }
    
    
}
