
package data;

import java.util.HashMap;

public class Tablero {
    
    private Casilla[] tablero;
    private static HashMap <String,Casilla> mapa = new HashMap<>();  
    
    public Tablero(){
        tablero = new Casilla[101];
        
        for(int i = 0; i < tablero.length; i++){
            Casilla casilla = new Casilla();
            tablero[i] = casilla;
        }
        
        tablero[0].setTipo("VICTORIA");
        tablero[68].setColor("ROJO");
        tablero[68].setTipo("SEGURO");
        tablero[5].setColor("ROJO");
        tablero[5].setTipo("SALIDA");
        tablero[12].setColor("ROJO");
        tablero[12].setTipo("SEGURO");
        tablero[17].setColor("VERDE");
        tablero[17].setTipo("SEGURO");
        tablero[22].setColor("VERDE");
        tablero[22].setTipo("SALIDA");
        tablero[29].setColor("VERDE");
        tablero[29].setTipo("SEGURO");
        tablero[34].setColor("AZUL");
        tablero[34].setTipo("SEGURO");
        tablero[39].setColor("AZUL");
        tablero[39].setTipo("SALIDA");
        tablero[46].setColor("AZUL");
        tablero[46].setTipo("SEGURO");
        tablero[51].setColor("AMARILLO");
        tablero[51].setTipo("SEGURO");
        tablero[56].setColor("AMARILLO");
        tablero[56].setTipo("SALIDA");
        tablero[63].setColor("AMARILLO");
        tablero[63].setTipo("SEGURO");
        
        //Avance rojo a tablero
        for(int ir=1;ir<=64;ir++){
            this.mapa.put("ROJO_"+Integer.toString(ir),tablero[ir+4]);
        }
        
        //Avance verde a tablero
        for(int iv=1;iv<=64;iv++){
            if(iv+21<=68){
                this.mapa.put("VERDE_"+Integer.toString(iv),tablero[iv+21]);
            }else{
                this.mapa.put("VERDE_"+Integer.toString(iv),tablero[iv-47]);
            }
        }
        
        //Avance azul a tablero
        for(int iz=1;iz<=64;iz++){
            if(iz+38<=68){
                this.mapa.put("AZUL_"+Integer.toString(iz),tablero[iz+38]);
            }else{
                this.mapa.put("AZUL_"+Integer.toString(iz),tablero[iz-30]);
            }
        }
        
        //Avance amarillo a tablero
        for(int il=1;il<=64;il++){
            if(il+55<=68){
                this.mapa.put("AMARILLO_"+Integer.toString(il),tablero[il+55]);
            }else{
                this.mapa.put("AMARILLO_"+Integer.toString(il),tablero[il-13]);
            }
        }
        
        
    }
    
    
    public Casilla[] getTablero() {
        return tablero;
    }

    public void setTablero(Casilla[] tablero) {
        this.tablero = tablero;
    }

    public HashMap<String, Casilla> getMapa() {
        return mapa;
    }

    public void setMapa(HashMap<String, Casilla> mapa) {
        this.mapa = mapa;
    }
    
    
    public Casilla mapearCasillas(String color, int avance){
           return this.mapa.get(color+"_"+Integer.toString(avance)); 
    }
       
    
}
