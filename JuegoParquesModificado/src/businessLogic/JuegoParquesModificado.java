
package businessLogic;

import data.Tablero;
import UI.UI;
import java.util.Random;
import java.util.Scanner;
import data.Equipo;
import data.Rojo;
import data.Verde;
import data.Azul;
import data.Amarillo;
import java.util.HashSet;

public class JuegoParquesModificado {
    
    public static void main(String[] args) {
        UI interfaz = new UI();
        ControlTurno jugar = new ControlTurno(); 
        boolean jugarOtro = true;
        Scanner lector = new Scanner(System.in);
                
        do{
    
        int numJugadores = 0;
        boolean bandera = false;
        boolean ganador = false;
        Tablero tablero = new Tablero();
        Equipo[] jugadores = new Equipo[4];
        Equipo equipoAuxiliar = new Equipo();
        numJugadores = interfaz.imprimirBienvenida();
        System.out.println();
           
        jugadores = interfaz.crearJugadores(numJugadores);
        jugar.presionarEnter();
        
        jugadores = jugar.definirTurnos(jugadores);
        jugar.presionarEnter();
        
        int turno = 1;
        do{

            //Verificamos que sea un turno valido
            if(turno > numJugadores){
                turno = 1;
            }
            
            //Buscamos el jugador con el turno correspondiente
            for(int jugador = 0; jugador <= 4; jugador++){
                if(jugadores[jugador].getTurno()==turno){
                    equipoAuxiliar = jugadores[jugador];
                    break;
                }
            }
                       
        
            jugar.jugarTurno(equipoAuxiliar);
            jugar.presionarEnter();
            System.out.println("Presione \"ENTER\" para ver el estatus de sus fichas.");
            jugar.presionarEnter();
            interfaz.imprimirFichas(equipoAuxiliar.getFichas());
            
            
            
            
            ganador = jugar.verificarGanador(jugadores);
            jugar.presionarEnter();
            
            //Finaliza el turno
            turno++;
        }while(ganador == false);
        
        System.out.println("El GANADOR es:");
        System.out.println(equipoAuxiliar);
        
        
        System.out.println("Que tal estuvo la partida? Te gusto? 0 si Deseas jugar otra partida?");
        if(lector.nextInt()==0){
            jugarOtro=false;
        }
        
    }while(jugarOtro == true);
    } 
       
    
}

