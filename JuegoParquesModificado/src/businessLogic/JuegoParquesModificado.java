
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
        Tablero tablero = new Tablero();
        Equipo[] jugadores = new Equipo[4];
 
        numJugadores = interfaz.imprimirBienvenida();
           
        jugadores = interfaz.crearJugadores(numJugadores);
        
        jugadores = jugar.definirTurnos(jugadores);
        
        
        
        System.out.println("Que tal estuvo la partida? Te gusto? 0 si Deseas jugar otra partida?");
        if(lector.nextInt()==0){
            jugarOtro=false;
        }
        
    }while(jugarOtro == true);
    } 
       
    
}

