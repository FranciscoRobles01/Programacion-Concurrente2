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
public class P3 extends Thread{
    
    private Semaphore sem3;
    private Semaphore sem2;

    public P3(Semaphore sem3, Semaphore sem2) {
        this.sem3 = sem3;
        this.sem2 = sem2;
    }

    public void run() {
        try {
            sem3.acquire();
            System.out.println("El P3 se esta ejecutando...");
            Thread.sleep(1000);
            System.out.println("El P3 ha terminado...");
            sem3.release();
            sem2.release();

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error chaval, revisa P3");
        }
    }
}
