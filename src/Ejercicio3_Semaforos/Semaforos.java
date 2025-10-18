/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio3_Semaforos;
import java.util.concurrent.Semaphore;
/**
 *
 * @author roble
 */
public class Semaforos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Semaphore sem = new Semaphore(1);
        Semaphore sem2 = new Semaphore(0);
        Semaphore sem3 = new Semaphore(0);
        
        P1 p1 = new P1(sem,sem3);
        P3 p3 = new P3(sem3,sem2);
        P2 p2 = new P2(sem2,sem);
        
        p1.start();
        p2.start();
        p3.start();
    }
    
}
