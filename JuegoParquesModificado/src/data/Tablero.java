
package data;

import java.util.HashMap;
import java.util.Random;

public class Tablero {
    
    private Casilla[] tablero;
    private static HashMap <String,Casilla> mapa = new HashMap<>();  
    
    public Tablero(){
        tablero = new Casilla[101];
        
        for(int i = 0; i < tablero.length; i++){
            Casilla casilla = new Casilla();
            tablero[i] = casilla;
        }
        
        //Tablero comun
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
        
        //Carceles
        tablero[69].setColor("ROJO");
        tablero[69].setTipo("CARCEL");
        tablero[70].setColor("VERDE");
        tablero[70].setTipo("CARCEL");
        tablero[71].setColor("AZUL");
        tablero[71].setTipo("CARCEL");
        tablero[72].setColor("AMARILLO");
        tablero[72].setTipo("CARCEL");
        
        //Caminos a la victoria
        for(int cr = 73; cr <= 79; cr++){
            tablero[cr].setColor("ROJO");
            tablero[cr].setTipo("CAMINO_VICTORIA");
        }
        
        for(int cv = 80; cv <= 86; cv++){
            tablero[cv].setColor("VERDE");
            tablero[cv].setTipo("CAMINO_VICTORIA");
        }
        
        for(int cz = 87; cz <= 93; cz++){
            tablero[cz].setColor("AZUL");
            tablero[cz].setTipo("CAMINO_VICTORIA");
        }
        
        for(int cl = 94; cl <= 100; cl++){
            tablero[cl].setColor("AMARILLO");
            tablero[cl].setTipo("CAMINO_VICTORIA");
        }
        
        
        //Carceles
        mapa.put("ROJO_0",tablero[69]);
        mapa.put("VERDE_0",tablero[70]);
        mapa.put("AZUL_0",tablero[71]);
        mapa.put("AMARILLO_0",tablero[72]);
        
        //Avance a tablero para mapeo
        for(int m=1;m<=64;m++){
            //Avance rojo
            mapa.put("ROJO_"+Integer.toString(m),tablero[m+4]);
            //Avance verde
            if(m+21<=68){
                mapa.put("VERDE_"+Integer.toString(m),tablero[m+21]);
            }else{
                mapa.put("VERDE_"+Integer.toString(m),tablero[m-47]);
            }
            //Avance azul
            if(m+38<=68){
                mapa.put("AZUL_"+Integer.toString(m),tablero[m+38]);
            }else{
                mapa.put("AZUL_"+Integer.toString(m),tablero[m-30]);
            }
            //Avance amarillo
            if(m+55<=68){
                mapa.put("AMARILLO_"+Integer.toString(m),tablero[m+55]);
            }else{
                mapa.put("AMARILLO_"+Integer.toString(m),tablero[m-13]);
            }
        }
               
        //Avance caminos de la victoria
        for(int cv = 65; cv <= 71; cv++){
            mapa.put("ROJO_"+Integer.toString(cv),tablero[cv+8]);
            mapa.put("VERDE_"+Integer.toString(cv),tablero[cv+15]);
            mapa.put("AZUL_"+Integer.toString(cv),tablero[cv+22]);
            mapa.put("AMARILLO_"+Integer.toString(cv),tablero[cv+29]);
        }
        
        //Victoria
        mapa.put("ROJO_72",tablero[0]);
        mapa.put("VERDE_72",tablero[0]);
        mapa.put("AZUL_72",tablero[0]);
        mapa.put("AMARILLO_72",tablero[0]);
        
        mezclarEscalera(tablero);
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
    
    public void mezclarEscalera(Casilla[] tablero){
        Random aleatorio = new Random();
        int[] vectorEfectos = new int[8];
        int escalera=0;
        do{
            int casillaAleatoria = aleatorio.nextInt(101);
            if(tablero[casillaAleatoria].getTipo().equals("REGULAR")){
                //System.out.println(casillaAleatoria);
                tablero[casillaAleatoria].setTipo("ESCALERA");
                int avanza = aleatorio.nextInt(5)+1;
                tablero[casillaAleatoria].setEfecto(avanza);
                vectorEfectos[escalera]=casillaAleatoria;
                escalera++;
            }
        }while(escalera<4);
        
        int rodadero=0;
        do{
            int casillaAleatoria = aleatorio.nextInt(101);
            if(tablero[casillaAleatoria].getTipo().equals("REGULAR")){
                //System.out.println(casillaAleatoria);
                tablero[casillaAleatoria].setTipo("RODADERO");
                int retrocede = aleatorio.nextInt(5)+1;
                tablero[casillaAleatoria].setEfecto(-(retrocede));
                vectorEfectos[rodadero+4]=casillaAleatoria;
                rodadero++;
            }
        }while(rodadero<4);
        
        //Esta seccion del codigo modifica los efectos de las casillas
        //Con el fin de evitar un bug que genera un loop y una ficha puede acabar atrapada
         for(int bug = 0; bug <8; bug++){
            for(int fix = bug + 1; fix < 8; fix++){
                if(vectorEfectos[fix]<vectorEfectos[bug]){
                    int aux = vectorEfectos[bug];
                    vectorEfectos[bug] = vectorEfectos[fix];
                    vectorEfectos[fix]=aux;
                }
            }
        }
        
        if(this.tablero[vectorEfectos[7]].getEfecto()+this.tablero[vectorEfectos[0]].getEfecto() == 0){
               if(this.tablero[vectorEfectos[7]].getEfecto()>0){
                   if(this.tablero[vectorEfectos[7]].getEfecto()<5){
                       this.tablero[vectorEfectos[7]].setEfecto(this.tablero[vectorEfectos[7]].getEfecto()+1); 
                   }else{
                       this.tablero[vectorEfectos[0]].setEfecto(this.tablero[vectorEfectos[0]].getEfecto()+1); 
                   }
               }
        }
        
        for(int bug = 0; bug < 7; bug++){ 
            if(this.tablero[vectorEfectos[bug]].getEfecto()+this.tablero[vectorEfectos[bug+1]].getEfecto() == 0){
               if(this.tablero[vectorEfectos[bug]].getEfecto()>0){
                   if(this.tablero[vectorEfectos[bug]].getEfecto()<5){
                       this.tablero[vectorEfectos[bug]].setEfecto(this.tablero[vectorEfectos[bug]].getEfecto()+1); 
                   }else{
                       this.tablero[vectorEfectos[bug+1]].setEfecto(this.tablero[vectorEfectos[bug+1]].getEfecto()+1); 
                   }
               }
            }           
        }        
    }   
}
