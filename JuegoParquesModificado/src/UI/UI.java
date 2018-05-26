/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Scanner;
import data.Equipo;
import data.Rojo;
import data.Verde;
import data.Azul;
import data.Amarillo;
import data.Ficha;

/**
 *
 * @author hp
 */
public class UI {
    
    public int imprimirBienvenida(){
        Scanner leer = new Scanner(System.in);
        System.out.println("BIENVENIDO A UN PARQUES DIFERENTE\n");
        System.out.println("Por favor ingresa el numero de jugadores 2, 3 ó 4.");
        return leer.nextInt();
    }
    
    public Equipo[] crearJugadores(int numJugadores){
        Scanner lector = new Scanner(System.in);
        boolean bandera = false;
        
        Rojo rojo = new Rojo();
        Verde verde = new Verde();
        Azul azul = new Azul();
        Amarillo amarillo = new Amarillo();
        
        Equipo[] jugadores = new Equipo[4];
        jugadores[0] = rojo;
        jugadores[1] = verde;
        jugadores[2] = azul;
        jugadores[3] = amarillo;
        
        for(int turno = 1 ; turno <= numJugadores ; turno++){
            System.out.println("Por favor ingresa tu nombre: ");
            String nombre = lector.next();
            do{
                System.out.println("Por favor ingresa el color deseado:\n");
                for(int i=0;i<4;i++){
                    if(jugadores[i].isJugador() == false){
                        System.out.printf("\t%d. %s\t",i+1,jugadores[i].getColor());
                    }
                }
                System.out.println("\n");
                int seleccion = lector.nextInt()-1;
                if(jugadores[seleccion].isJugador() == false){
                    System.out.printf("El color %s ha sido seleccionado.\n\n",jugadores[seleccion].getColor());
                    jugadores[seleccion].setJugador(true);
                    jugadores[seleccion].setNombre(nombre);               
                    bandera = true;
                }else{
                    System.out.printf("El color %s ya ha sido seleccionado previamente.\n\n",jugadores[seleccion].getColor());
                    bandera = false;
                }
            }while(bandera == false);
        }
        
        return jugadores;
    }
    
    public void imprimirFichas(Ficha[] fichas){
        for(int i = 0; i < 4; i++){
            System.out.printf("FICHA NUMERO %d :\n", i+1);
            System.out.print(fichas[i]);
        }
    }
    
}
