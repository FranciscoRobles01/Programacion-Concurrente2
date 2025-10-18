/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PollosHermanos;

/**
 *
 * @author roble
 */
public class Mozo extends Thread {

    private int id;
    private Confiteria confiteria;

    public Mozo(int id, Confiteria confiteria) {
        this.id = id;
        this.confiteria = confiteria;
    }

    public void run() {
        boolean atendio;
        try {

            while (true) {
                atendio = confiteria.servirComida();

                if (atendio) {
                    confiteria.esperarEmpleado();
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error en MOZO");
        }
    }
}
