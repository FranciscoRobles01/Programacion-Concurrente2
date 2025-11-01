/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PollosHermanosII;

/**
 *
 * @author roble
 */
public class ejecutarConfiteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Confiteria confiteria = new Confiteria();
        Mozo mozo = new Mozo(confiteria);
        Cocinero cocinero1 = new Cocinero(confiteria);
        Cocinero cocinero2 = new Cocinero(confiteria);
        
        mozo.start();
        cocinero1.start();
        cocinero2.start();
        
        Empleado empleado1 = new Empleado("Diego",confiteria,'a');
        Empleado empleado2 = new Empleado("Armando",confiteria,'a');
        Empleado empleado3 = new Empleado("Rodolfo",confiteria,'a');
        Empleado empleado4 = new Empleado("Agustina",confiteria,'a');
        Empleado empleado5 = new Empleado("Mili",confiteria,'a');
        Empleado empleado6 = new Empleado("Franco",confiteria,'a');
        Empleado empleado7 = new Empleado("Mia",confiteria,'a');
        Empleado empleado8 = new Empleado("Zowie",confiteria,'a');
        Empleado empleado9 = new Empleado("Caro",confiteria,'a');
        Empleado empleado10 = new Empleado("Dominic",confiteria,'a');
        
        empleado1.start();
        empleado2.start();
        empleado3.start();
        empleado4.start();
        empleado5.start();
        empleado6.start();
        empleado7.start();
        empleado8.start();
        empleado9.start();
        empleado10.start();
        
    }
    
}
