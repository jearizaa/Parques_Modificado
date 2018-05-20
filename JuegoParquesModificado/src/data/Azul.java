
package data;

public class Azul extends Equipo{

    public Azul(){        
        this.setColor("AZUL");
        this.setHabilidadDisponible(true); 
        Ficha[] fichasAzules = new Ficha[4];
        for(int i = 0; i < fichasAzules.length; i++){
            Ficha ficha = new Ficha("AZUL");
            fichasAzules[i] = ficha;
        }
        this.setFichas(fichasAzules);
        this.setJugador(false);
    }
    
    @Override
    public void usarPoder(){
    
    }   
    
}
