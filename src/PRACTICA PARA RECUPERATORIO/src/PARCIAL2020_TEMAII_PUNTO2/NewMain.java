/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PARCIAL2020_TEMAII_PUNTO2;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorCruce cruce = new GestorCruce();
        
        Auto autosNorte[] = new Auto[15];
        AutoO autosOeste[] = new AutoO[15];
        ControlSemaforos control = new ControlSemaforos(cruce);
        for(int i=0; i < autosNorte.length; i++){
            autosNorte[i] = new Auto((i+1),cruce);
        }
        
        for(int i=0; i<autosOeste.length; i++){
            autosOeste[i] = new AutoO((i+1), cruce);
        }
    
        control.start();
        for(int i=0; i < autosNorte.length; i++){
            autosNorte[i].start();
        }
        
         for(int i=0; i<autosOeste.length; i++){
            autosOeste[i].start();
        }
    }
    
}
