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
public class P2 extends Thread{
    private Semaphore sem2;
    private Semaphore sem1;

    public P2(Semaphore sem2, Semaphore sem1) {
        this.sem2 = sem2;
        this.sem1 = sem1;
    }

    public void run() {
        try {
            sem2.acquire();
            System.out.println("El P2 se esta ejecutando...");
            Thread.sleep(1000);
            System.out.println("El P2 ha terminado...");
            sem2.release();
            sem1.release();

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error chaval, revisa P1");
        }
    }
}
