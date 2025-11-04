/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FerryLocks;

/**
 *
 * @author roble
 */
public class FerryLocks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ferry ferry = new Ferry(4);
        Pasajero pasajeros[] = new Pasajero[5];
        Auto autos[] = new Auto[10];
        ControlFerry control = new ControlFerry(ferry);
        
        
        for(int i=0; i<pasajeros.length; i++){
            pasajeros[i]= new Pasajero((i+1), ferry);
        }
        
        for(int i=0; i < autos.length; i++){
            autos[i]= new Auto((i+1),2,ferry);
        }
        
        control.start();
        
        for(int i=0; i<pasajeros.length; i++){
            pasajeros[i].start();
        }
        
        for(int i=0; i < autos.length; i++){
            autos[i].start();
        }
    }
    
}
