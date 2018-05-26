
package businessLogic;

import UI.UI;
import java.util.Random;
import data.Equipo;
import data.Ficha;
import data.Tablero;
import java.util.Scanner;

public class ControlTurno {
    
    public void presionarEnter(){
        System.out.println("Presione \"ENTER\" para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    
    public int lanzarDado(){
        Random dado = new Random();
        return dado.nextInt(6)+1;
    }
    
    public Equipo[] definirTurnos(Equipo[] jugadores){
        boolean bandera = false;
        System.out.println("El jugador con el mayor numero al lanzar un dado empieza el juego.\n");
        presionarEnter();
        Equipo[] jAux = new Equipo[4];
        jAux = jugadores;
        int ganador = 5;
        do{
            int[] lanzamiento = new int[4];
            for(int equipo = 0; equipo < 4; equipo++){
                if(jAux[equipo].isJugador()==true){
                    System.out.println(jAux[equipo]);
                    System.out.println("Por favor presione \"ENTER\" para lanzar el dado.");
                    presionarEnter();
                    lanzamiento[equipo] = lanzarDado();
                    System.out.printf("Su resultado fue: %d\n\n", lanzamiento[equipo]);
                    presionarEnter();
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
                        System.out.println(jAux[ganador]);
                        System.out.println("Presione \"ENTER\" para ver el resultado del sorteo.\n");
                        presionarEnter();
                        bandera=true;
                        break;
                    }else{
                        System.out.printf("Mas de un ganador con la cara del dado %d, se jugaran los turnos de nuevo.\n", caraDado);
                        presionarEnter();
                        for(int equipo = 0; equipo < 4; equipo++){
                            if(lanzamiento[equipo]!=caraDado){
                                //jAux[equipo].setJugador(false);
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
    
    public int contarFichasJugando(Ficha[] fichas){
        int fichasJugando = 0;
            for(int i = 0; i < 4; i++){
                if(fichas[i].getAvance()!=0){
                    fichasJugando++;
                }
            }
        return fichasJugando;
    }
    
    public void sacarFichas(Ficha[] fichas, int[] dados){
        Tablero tablero = new Tablero();
        if(dados[0]==1||dados[0]==6){
            System.out.println("Salieron 4 fichas de la carcel"+Integer.toString(dados[0])+", "+Integer.toString(dados[1]));
            for(int i = 0; i < 4; i++){
                if(fichas[i].getAvance()==0){
                    fichas[i].setAvance(1);
                    fichas[i].setPosicion(tablero.mapearCasillas(fichas[i].getColor(),fichas[i].getAvance()));
                    fichas[i].setEncarcelado(false);
                }
            }
        }else{
            int cont = 0;
            System.out.println("Salieron 2 fichas de la carcel por "+Integer.toString(dados[0])+", "+Integer.toString(dados[1]));
            for(int i = 0; i < 4; i++){
                if(fichas[i].getAvance()==0){
                    fichas[i].setAvance(1);
                    fichas[i].setPosicion(tablero.mapearCasillas(fichas[i].getColor(),fichas[i].getAvance()));
                    fichas[i].setEncarcelado(false);
                    cont++;
                }
            if(cont==2){
                break;
            }
            }
        }
    }
    
    public void avanzarFichas(Equipo equipo, int[] dados){
        UI interfaz = new UI();
        Scanner lector = new Scanner(System.in);
        Tablero tablero = new Tablero();
        boolean bandera = false;
        int fichaSel = 5;
        do{
            interfaz.imprimirFichas(equipo.getFichas());
            System.out.println("Por favor escoja la ficha a asignarle el dado con valor :"+Integer.toString(dados[0]));
            fichaSel = lector.nextInt()-1;
            if(equipo.getFichas()[fichaSel].getAvance()==0||equipo.getFichas()[fichaSel].getAvance()==72){
                System.out.printf("La ficha esta en %s, seleccione otra ficha.\n",equipo.getFichas()[fichaSel].getPosicion().getTipo());
                bandera = false;
            }else{
                System.out.printf("La ficha %d se ha movido %d", fichaSel+1, dados[0]);
                equipo.getFichas()[fichaSel].setAvance(equipo.getFichas()[fichaSel].getAvance()+dados[0]);
                if(equipo.getFichas()[fichaSel].getAvance()>72){
                    equipo.getFichas()[fichaSel].setAvance(72);
                }
                equipo.getFichas()[fichaSel].setEncarcelado(false);
                equipo.getFichas()[fichaSel].setPosicion(tablero.mapearCasillas(equipo.getFichas()[fichaSel].getColor(), equipo.getFichas()[fichaSel].getAvance()));
                //Aplicamos el efecto de la casilla si lo hay
                while(equipo.getFichas()[fichaSel].getPosicion().getEfecto()!=0){
                    if(equipo.getColor().equals("ROJO") && equipo.isHabilidadDisponible()==true && equipo.getFichas()[fichaSel].getPosicion().getEfecto()<0){
                        System.out.println("El equipo ROJO puede anular el efecto de la casilla. Desea usar esta habilidad?\n");
                        System.out.println("\t(1)Si\t(2)No\n");
                        int sel = lector.nextInt();
                        if(sel == 1){
                            equipo.setHabilidadDisponible(false);
                            break;
                        }                
                    }   
                    
                    if(equipo.getColor().equals("AMARILLO") && equipo.isHabilidadDisponible()==true && equipo.getFichas()[fichaSel].getPosicion().getEfecto()>0){
                        System.out.println("El equipo AMARILLO puede incrementar el efecto de la casilla. Desea usar esta habilidad?\n");
                        System.out.println("\t(1)Si\t(2)No\n");
                        int sel = lector.nextInt();
                        if(sel == 1){
                            equipo.getFichas()[fichaSel].setAvance(equipo.getFichas()[fichaSel].getAvance()+equipo.getFichas()[fichaSel].getPosicion().getEfecto()*2);
                            equipo.getFichas()[fichaSel].setPosicion(tablero.mapearCasillas(equipo.getFichas()[fichaSel].getColor(), equipo.getFichas()[fichaSel].getAvance()));
                            if(equipo.getFichas()[fichaSel].getPosicion().getTipo().equals("SALIDA")||equipo.getFichas()[fichaSel].getPosicion().getTipo().equals("SEGURO")){
                                equipo.getFichas()[fichaSel].setProtegido(true);
                            }else{
                                equipo.getFichas()[fichaSel].setProtegido(false);
                            }
                            equipo.setHabilidadDisponible(false);
                        }                
                    }else{
                        equipo.getFichas()[fichaSel].setAvance(equipo.getFichas()[fichaSel].getAvance()+equipo.getFichas()[fichaSel].getPosicion().getEfecto());
                        equipo.getFichas()[fichaSel].setPosicion(tablero.mapearCasillas(equipo.getFichas()[fichaSel].getColor(), equipo.getFichas()[fichaSel].getAvance()));
                        if(equipo.getFichas()[fichaSel].getPosicion().getTipo().equals("SALIDA")||equipo.getFichas()[fichaSel].getPosicion().getTipo().equals("SEGURO")){
                            equipo.getFichas()[fichaSel].setProtegido(true);
                        }else{
                            equipo.getFichas()[fichaSel].setProtegido(false);
                        }
                    }
                } 
                bandera=true;
            }
        }while(bandera==false);
        
        if(equipo.getColor().equals("VERDE") && equipo.isHabilidadDisponible()==true && equipo.getFichas()[fichaSel].getPosicion().getTipo().equals("REGULAR")){
            System.out.println("El equipo VERDE puede proteger la ficha por una unica vez. Desea usar esta habilidad?\n");
            System.out.println("\t(1)Si\t(2)No\n");
            int sel = lector.nextInt();
            if(sel == 1){
                equipo.getFichas()[fichaSel].setProtegido(true);
                equipo.setHabilidadDisponible(false);
            }                
        }
        
        bandera = false;
        fichaSel = 5;
        do{
            interfaz.imprimirFichas(equipo.getFichas());
            System.out.println("Por favor escoja la ficha a asignarle el dado con valor :"+Integer.toString(dados[1]));
            fichaSel = lector.nextInt()-1;
            if(equipo.getFichas()[fichaSel].getPosicion().getTipo().equals("CARCEL")){
                System.out.println("La ficha esta en la carcel, seleccione otra ficha.");
                bandera = false;
            }else{
                System.out.printf("La ficha %d se ha movido %d", fichaSel+1, dados[1]);
                equipo.getFichas()[fichaSel].setAvance(equipo.getFichas()[fichaSel].getAvance()+dados[1]);
                equipo.getFichas()[fichaSel].setEncarcelado(false);
                equipo.getFichas()[fichaSel].setPosicion(tablero.mapearCasillas(equipo.getFichas()[fichaSel].getColor(), equipo.getFichas()[fichaSel].getAvance()));
                //Aplicamos el efecto de la casilla si lo hay
                while(equipo.getFichas()[fichaSel].getPosicion().getEfecto()!=0){
                    equipo.getFichas()[fichaSel].setAvance(equipo.getFichas()[fichaSel].getAvance()+equipo.getFichas()[fichaSel].getPosicion().getEfecto());
                    equipo.getFichas()[fichaSel].setPosicion(tablero.mapearCasillas(equipo.getFichas()[fichaSel].getColor(), equipo.getFichas()[fichaSel].getAvance()));
                    if(equipo.getFichas()[fichaSel].getPosicion().getTipo().equals("SALIDA")||equipo.getFichas()[fichaSel].getPosicion().getTipo().equals("SEGURO")){
                        equipo.getFichas()[fichaSel].setProtegido(true);
                    }else{
                        equipo.getFichas()[fichaSel].setProtegido(false);
                    }
                } 
                bandera=true;
            }
        }while(bandera==false);
        
        
        if(equipo.getColor().equals("VERDE") && equipo.isHabilidadDisponible()==true && equipo.getFichas()[fichaSel].getPosicion().getTipo().equals("REGULAR")){
            System.out.println("El equipo VERDE puede proteger la ficha por una unica vez. Desea usar esta habilidad?\n");
            System.out.println("\t(1)Si\t(2)No\n");
            int sel = lector.nextInt();
            if(sel == 1){
                equipo.getFichas()[fichaSel].setProtegido(true);
                equipo.setHabilidadDisponible(false);
            }                
        }        
    }
    
    public void jugarTurno(Equipo equipo){
        Scanner lector = new Scanner(System.in);
        int[] dados = {0,0};
        int vidas = 0;
        int pares = 0;
        int oportunidades = 1;
        
        if(contarFichasJugando(equipo.getFichas())==0){
            vidas = 3;
            System.out.printf("Turno jugador %s sin fichas en juego. Tiene tres oportunidades.\n",equipo.getColor());
        }
        
        do{
            System.out.printf("Turno jugador %s.\n", equipo.getColor());
            System.out.printf("Jugador %s, presione \"ENTER\" para lanzar dados.\n",equipo.getColor());
            presionarEnter();
            dados[0] = lanzarDado();
            dados[1] = lanzarDado();
            System.out.println("Ud lanzo los dados : " + Integer.toString(dados[0]) + ", "+ Integer.toString(dados[1]) + "\n");
            if(equipo.getColor().equals("AZUL") && equipo.isHabilidadDisponible()==true){
                System.out.println("El equipo AZUL puede lanzar de nuevo un dado por una unica vez. Desea usar esta habilidad?\n");
                System.out.println("\t(1)Si\t(2)No\n");
                int sel = lector.nextInt();
                if(sel == 1){
                    System.out.printf("Presione (1) para lanzar de nuevo el dado con valor %d.\n",dados[0]);
                    System.out.printf("Presione (2) para lanzar de nuevo el dado con valor %d.\n\n",dados[1]);
                    sel = lector.nextInt();
                    presionarEnter();
                    dados[sel-1]=lanzarDado();
                    System.out.println("Ud lanzo el dado con resultado: " + Integer.toString(dados[sel-1]));
                    System.out.println("Resultado final: " + Integer.toString(dados[0]) + ", "+ Integer.toString(dados[1]));
                    equipo.setHabilidadDisponible(false);
                }                
            }
            oportunidades--;
            //Si saca par
            if(dados[0] == dados[1]){
                System.out.println("Saco par.\n");
                oportunidades++;
                vidas = 0;
                pares++;
                if(contarFichasJugando(equipo.getFichas())==0){
                    sacarFichas(equipo.getFichas(), dados);
                }else{
                    if(contarFichasJugando(equipo.getFichas())==4){
                        avanzarFichas(equipo, dados);
                    }else{
                        System.out.print("Por favor indique si desea sacar fichas de la carcel (1) o avanzar con las fichas en juego (2).\n");
                        int opcion = lector.nextInt();
                        if(opcion==1){
                            sacarFichas(equipo.getFichas(), dados);
                        }else{
                            avanzarFichas(equipo, dados);
                        }  
                    }
                }
            }else{//Si no saca par
                System.out.println("No saco par.\n");
                vidas--;
                if(contarFichasJugando(equipo.getFichas())==0 && vidas > 0){//Si no hay fichas en juego y tiene vidas se le da otro turno
                    oportunidades++;
                }else{//Si no hay vidas pero si hay fichas en juego
                    if(contarFichasJugando(equipo.getFichas()) > 0){
                        avanzarFichas(equipo, dados);                    
                    }//Si no hay vidas ni fichas en juego se termina el turno
                }
            }
        }while(oportunidades > 0);       
          
        if(equipo.getColor().equals("VERDE") && equipo.isHabilidadDisponible() == false){
            for(int i=0; i<4;i++){
                if(equipo.getFichas()[i].getPosicion().getTipo().equals("REGULAR")){
                    equipo.getFichas()[i].setProtegido(false);
                }
            }        
        }
        
    }
    
    public boolean verificarGanador(Equipo[] equipos){
        int cont = 0;
        boolean ganador = false;
        for(int i=0; i<4;i++){
            for(int j=0; j<4;j++){
                if(equipos[i].getFichas()[j].getAvance()==72){
                    cont++;
                }
            }
            System.out.printf("Equipo %s tiene %d fichas en la meta.\n", equipos[i].getColor(),cont);
            if(cont==4){
                System.out.printf("Equipo %s gana", equipos[i].getColor());
                ganador = true;
                break;
            }else{
                cont=0;
                ganador = false;
            }            
        }
        
        return ganador;
    }
}
