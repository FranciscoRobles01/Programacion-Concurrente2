/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PARCIAL2020;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferOscilante buf = new BufferOscilante();
        Inserta hilo = new Inserta(buf);
        Extrae hilo2 = new Extrae(buf);
        
        hilo.start();
        hilo2.start();
        
    }
    
}
