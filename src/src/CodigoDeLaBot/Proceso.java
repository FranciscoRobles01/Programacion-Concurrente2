/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodigoDeLaBot;
import java.util.concurrent.Semaphore;
import java.util.Random;
/**
 *
 * @author roble
 */
public class Proceso {
    private Semaphore semOxigeno = new Semaphore(1);
    private Semaphore semHidrogeno = new Semaphore(2);
    private Semaphore semAgua = new Semaphore(0);
    private Random random = new Random();
    private int recipiente;
    private int cantActual = 0;

    public Proceso(int recipiente) {
        this.recipiente = recipiente;
    }

    public void olisto(String nombre) {
        try {
            System.out.println(nombre + " esta preparandose para estar Olisto");
            semOxigeno.acquire();
            System.out.println(nombre + " esta  Olisto");
            hacerAgua();
            System.out.println("EL OXIGENO: " + nombre + " FUE LIBERADO");
            semOxigeno.release();
            
        } catch (InterruptedException e) {
            System.out.println(nombre + " fue interrumpido");
        }
    }

    public void hilisto(String nombre) {
        try {
            System.out.println(nombre + " esta preparandose para estar Hlisto");
            semHidrogeno.acquire();
            System.out.println(nombre + " esta  Hlisto");
            semAgua.release();
        } catch (InterruptedException e) {
            System.out.println(nombre + " fue interrumpido");
        }
    }

    public void hacerAgua() {
        System.out.println("se esta haciendo agua");
        int cantAgua = random.nextInt(10) + 1;
        cantActual += cantActual + cantAgua;
        if (cantActual == recipiente) {
            System.out.println("el recipiente se esta envasando para su distribucion");
            cantActual = 0;
        }
    }
}

