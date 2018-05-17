
package businessLogic;

import data.Tablero;

public class JuegoParquesModificado {

    public static void main(String[] args) {
        
        Tablero tablero = new Tablero();
        
        for(int i = 0; i < tablero.getTablero().length ; i++){
            System.out.println(Integer.toString(i)+"\t"+ tablero.getTablero()[i]);
        }
    
        System.out.println(tablero.mapearCasillas("AMARILLO", 18));
        
        
    }
}
