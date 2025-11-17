/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PARCIAL2025;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mesa mesa = new Mesa(10,20,30,40);
        Album album = new Album();
        
        GeneradorCanciones generador = new GeneradorCanciones(mesa);
        Productor productorB = new Productor(0,mesa,album,"Blues");
        Productor productorR = new Productor(1,mesa,album,"Rock");
        Productor productorF = new Productor(2,mesa,album,"Folk");
        Productor productorC = new Productor(3,mesa,album,"Country");
        
        Manager manager = new Manager(album, "HOLa",100);
        
        generador.start();
        manager.start();
        productorB.start();
        productorR.start();
        productorF.start();
        productorC.start();
    }
    
}
