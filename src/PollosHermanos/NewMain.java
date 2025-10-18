/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PollosHermanos;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Confiteria confiteria = new Confiteria();
        Mozo mozo = new Mozo(1, confiteria);
        mozo.start();
        Empleado empleado1 = new Empleado(1,confiteria);
        
        Empleado empleado2 = new Empleado(2,confiteria);
        
        Empleado empleado3 = new Empleado(3,confiteria);
        
        empleado1.start();
        empleado2.start();
        empleado3.start();
    
    }
    
}
