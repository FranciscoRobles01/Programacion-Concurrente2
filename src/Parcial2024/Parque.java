/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Parcial2024;

/**
 *
 * @author roble
 */
public class Parque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MontaniaRusa montania = new MontaniaRusa(5);
        Carrito carrito = new Carrito(montania, 4);
        carrito.start();
        Pasajero pasajeros[] = new Pasajero[20];
        
        for(int i=0; i < pasajeros.length;i++){
            pasajeros[i] = new Pasajero((i+1),montania);
        }
        
        for(int i=0; i < pasajeros.length;i++){
            pasajeros[i].start();
        }
        
    }
    
}
