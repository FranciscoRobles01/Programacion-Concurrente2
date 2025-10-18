/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Parcial2023;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Planta planta = new Planta();
        Empaquetador empaquetador = new Empaquetador(1,planta);
        Embotellador embotellador = new Embotellador(1,'V',planta);
        Embotellador embotellador2 = new Embotellador(1,'A',planta);
        Transportador transporte = new Transportador(123,planta);
        
        empaquetador.start();
        embotellador.start();
        embotellador2.start();
        transporte.start();
    }
    
}
