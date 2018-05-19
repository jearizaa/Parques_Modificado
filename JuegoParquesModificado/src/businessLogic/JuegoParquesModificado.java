
package businessLogic;

import data.Tablero;
import java.util.Random;
import java.util.Scanner;

public class JuegoParquesModificado {

    public static void main(String[] args) {
        boolean jugarOtro = true;
        Scanner lector = new Scanner(System.in);
        
        do{
        Tablero tablero = new Tablero();
 
        System.out.println(tablero.mapearCasillas("VERDE", 72));
        
        for(int i = 0; i < tablero.getTablero().length ; i++){
            System.out.println(Integer.toString(i)+"\t"+ tablero.getTablero()[i]);
        }
        
        System.out.println("Deseas jugar otra partida?");
        if(lector.nextInt()==0){
            jugarOtro=false;
        }
        
    }while(jugarOtro == true);
    } 
       
    
}

