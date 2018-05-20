
package businessLogic;

import java.util.Random;
import data.Equipo;

public class ControlTurno {
    
    public int lanzarDado(){
        Random dado = new Random();
        return dado.nextInt(6)+1;
    }
    
    public Equipo[] definirTurnos(Equipo[] jugadores){
        boolean bandera = false;
        System.out.println("El jugador con el mayor numero al lanzar un dado empieza el juego\n");
        Equipo[] jugadoresAux = new Equipo[4];
        jugadoresAux = jugadores;
        int ganador = 5;
        do{
            int[] lanzamiento = new int[4];
            for(int equipo = 0; equipo < 4; equipo++){
                if(jugadoresAux[equipo].isJugador()==true){
                    System.out.println("Por favor lance el dado");
                    System.out.println(jugadoresAux[equipo]);
                    lanzamiento[equipo] = lanzarDado();
                    System.out.printf("Su resultado fue: %d\n\n", lanzamiento[equipo]);
                }           
            }
        
            int contador = 0;

            for(int caraDado = 6; caraDado < 1; caraDado--){
            System.out.println(caraDado);    
            }


            for(int caraDado = 6; caraDado >= 1; caraDado--){
                for(int equipo = 0; equipo < 4; equipo++){
                    if(lanzamiento[equipo]==caraDado){
                        ganador = equipo;
                        contador++;
                    }
                }
                if(contador>0){
                    if(contador==1){
                        System.out.printf("Ganador con un valor de %d\n", caraDado);
                        System.out.println(jugadoresAux[ganador]);
                        bandera=true;
                        break;
                    }else{
                        System.out.printf("Mas de un ganador con la cara del dado %d\n", caraDado);
                        for(int equipo = 0; equipo < 4; equipo++){
                            if(lanzamiento[equipo]!=caraDado){
                                jugadoresAux[equipo].setJugador(false);
                                bandera=false;
                            }
                        }
                        break;
                    }
                }
            }
        }while(bandera==false);
        
        int turno = 1;
        for(int defTurno = ganador; defTurno < 4; defTurno++){
            if(jugadores[defTurno].isJugador()==true){
                jugadores[defTurno].setTurno(turno);            
                turno++;
                System.out.println(jugadores[defTurno]);
            }
        }
        for(int defTurno = 0; defTurno < ganador; defTurno++){
            if(jugadores[defTurno].isJugador()==true){
                jugadores[defTurno].setTurno(turno);
                turno++;
                System.out.println(jugadores[defTurno]);
            }
        }
                
        return jugadores;        
    }
    
}
