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

/**
 *
 * @author hp
 */
public class UI {
    
    public int imprimirBienvenida(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Bienvenido a un juego de parqués diferente");
        System.out.println("Por favor ingresa el numero de jugadores 2, 3 ó 4");
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
                System.out.println("Por favor ingresa el color deseado: ");
                int seleccion = lector.nextInt()-1;
                if(jugadores[seleccion].isJugador() == false){
                    System.out.println("El color ha sido seleccionado.");
                    jugadores[seleccion].setJugador(true);
                    jugadores[seleccion].setNombre(nombre);               
                    bandera = true;
                }else{
                    System.out.println("El color ya ha sido seleccionado previamente.");
                    bandera = false;
                }
            }while(bandera == false);
        }
        
        return jugadores;
    }
    
    
}
