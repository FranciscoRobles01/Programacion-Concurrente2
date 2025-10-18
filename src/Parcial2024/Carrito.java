/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial2024;

/**
 *
 * @author roble
 */
public class Carrito extends Thread {

    private MontaniaRusa montania;
    private int cantVueltas;

    public Carrito(MontaniaRusa montania, int cantVueltas) {
        this.montania = montania;
        this.cantVueltas = cantVueltas;
    }

    public void run() {
        int i = 0;
        try {
            while (i < cantVueltas) {

                montania.dejarSubir();
                montania.empezarViaje();
                System.out.println("El carrito empezara con la vuelta " + (i + 1));
                Thread.sleep(3000);
                System.out.println("El carrito termino la vuelta " + (i + 1));
                montania.dejarBajar();
                Thread.sleep(800);
                cantVueltas++;i++;
            }
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error en carrito");
        }
    }
}
