/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PollosHermanosII;

/**
 *
 * @author roble
 */
public class Mozo extends Thread {

    private Confiteria confiteria;

    public Mozo(Confiteria confiteria) {
        this.confiteria = confiteria;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("El mozo esta haciendo su hobby habitual");
                Thread.sleep(1000);
                confiteria.prepararBebida();
                confiteria.terminarBebida();
            }
        } catch (InterruptedException e) {
            System.out.println("Error en run de Mozo");
        }
    }
}
