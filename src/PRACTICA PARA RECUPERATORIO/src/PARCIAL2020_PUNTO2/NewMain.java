/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PARCIAL2020_PUNTO2;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Buque buq = new Buque(2);
        Auto autos[] = new Auto[10];
        ControlBuqe control = new ControlBuqe(buq);
        
        for(int i=0; i < autos.length;i++){
            autos[i] = new Auto((i+1),buq);
        }
        control.start();
        for(int i=0; i < autos.length;i++){
            autos[i].start();
        }
        
    }
    
}
