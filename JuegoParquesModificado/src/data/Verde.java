
package data;


public class Verde extends Equipo {
    
    public Verde(){        
        this.setColor("VERDE");
        this.setHabilidadDisponible(true); 
        Ficha[] fichasVerdes = new Ficha[4];
        for(int i = 0; i < fichasVerdes.length; i++){
            Ficha ficha = new Ficha("VERDE");
            fichasVerdes[i] = ficha;
        }
        this.setFichas(fichasVerdes);
        this.setJugador(false);
    }
    
    
    @Override
    public void usarPoder(){
    
    }

    
}
