/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodigoDeLaBot;
import java.util.Random;
/**
 *
 * @author roble
 */
public class Hidrogeno extends Thread{
     private Random random = new Random();
    private Proceso proceso;
    private String nombre;

    public Hidrogeno(String nombre, Proceso proceso) {
        this.proceso = proceso;
        this.nombre = nombre;
    }

    public void run() {

        try {
            int tiempo = random.nextInt(5000) + 1;
            Thread.sleep(tiempo); // simula el tiempo que vagan en el espacio
            proceso.hilisto(nombre);
        } catch (InterruptedException e) {
            System.out.println("el atomo fue interrumpido");
        }
    }

}

