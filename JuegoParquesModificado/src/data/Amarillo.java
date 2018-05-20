
package data;

public class Amarillo extends Equipo{
 
    public Amarillo(){        
        this.setColor("AMARILLO");
        this.setHabilidadDisponible(true); 
        Ficha[] fichasAmarillas = new Ficha[4];
        for(int i = 0; i < fichasAmarillas.length; i++){
            Ficha ficha = new Ficha("AMARILLO");
            fichasAmarillas[i] = ficha;
        }
        this.setFichas(fichasAmarillas);
        this.setJugador(false);
    }    
    

    @Override
    public void usarPoder(){
    
    }
}
