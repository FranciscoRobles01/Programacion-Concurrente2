/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PiscinaComunitaria;
import java.util.Random;
/**
 *
 * @author roble
 */
public class Persona extends Thread {

    private Piscina piscina;
    private int id;

    public Persona(int id, Piscina piscina) {
        this.id = id;
        this.piscina = piscina;
    }

    public void run() {
        Random rand = new Random();
        try {
            System.out.println("La persona " + id + " esta esperando a entrar a la piscina");
            piscina.entrar();
            System.out.println("La persona " + id + " se encuentra dentro de la piscina...");
            Thread.sleep(rand.nextInt(1500,2000));
            System.out.println("La persona "+id+" abandona la piscina y libera un espacio..");
            piscina.salir();
        } catch (InterruptedException e) {
            System.out.println("ERROR en run");

        }
    }

}
