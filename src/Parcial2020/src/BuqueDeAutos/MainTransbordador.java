/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BuqueDeAutos;

/**
 *
 * @author roble
 */
public class MainTransbordador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Transbordador buque = new Transbordador();
        
        ControlBuque control = new ControlBuque(buque);
        
        Auto autos[] = new Auto[20];
        
        control.start();
        for(int i=0; i < autos.length; i++){
            autos[i]= new Auto((i+1), buque);
        }
        
        for(int i=0; i < autos.length; i++){
            autos[i].start();
        }
    }
    
}
