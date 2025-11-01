/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PollosHermanosII;

/**
 *
 * @author roble
 */
public class Cocinero extends Thread {

    private Confiteria confiteria;

    public Cocinero(Confiteria confiteria) {
        this.confiteria = confiteria;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("El cocinero esta probando nuevas recetas...");
                Thread.sleep(1000);
                confiteria.prepararComida();
                confiteria.terminarComida();
            }
        } catch (InterruptedException e) {
            System.out.println("Error en cocinero Run");
        }
    }
}
