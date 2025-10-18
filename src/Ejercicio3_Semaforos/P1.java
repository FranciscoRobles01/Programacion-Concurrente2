/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3_Semaforos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class P1 extends Thread{
    private Semaphore sem1;
    private Semaphore sem3;

    public P1(Semaphore sem1, Semaphore sem3) {
        this.sem1 = sem1;
        this.sem3 = sem3;
    }

    public void run() {
        try {
            sem1.acquire();
            System.out.println("El P1 se esta ejecutando...");
            Thread.sleep(1000);
            System.out.println("El P1 ha terminado...");
            sem1.release();
            sem3.release();

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error chaval, revisa P1");
        }
    }
}
