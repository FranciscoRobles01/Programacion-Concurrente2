/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Taxista;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Taxi taxi = new Taxi(1);
        Taxista taxista = new Taxista(1,taxi);
        Usted usted = new Usted(1,taxi);
        
        taxista.start();
        usted.start();
    }
    
}
