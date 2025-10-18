/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tienda2;

/**
 *
 * @author roble
 */
public class Tienda2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5,
            2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1,
            1});
        Cajero cajero1 = new Cajero("Cajero 1", cliente1);
        Cajero cajero2 = new Cajero("Cajero 2", cliente2);
        
        cajero1.start();
        cajero2.start();
    }

}
