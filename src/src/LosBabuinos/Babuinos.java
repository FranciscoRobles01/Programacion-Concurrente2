/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LosBabuinos;

/**
 *
 * @author roble
 */
public class Babuinos extends Thread{
    
    private int num;
    private Cuerda cuerda;

    public Babuinos(int num, Cuerda cuerda) {
        this.num = num;
        this.cuerda = cuerda;
    }


    public void run() {
        try {
            cuerda.avisarCruceDerechaIzquierda();
            cuerda.tomarCuerda(num,"derecha a izquierda");
            Thread.sleep(1000);
            cuerda.bajarCuerdaDerecha();
            cuerda.soltarCuerda(num,"derecha a izquierda");
            
        } catch (InterruptedException e) {
            System.out.println("Error en run babuinos");
        }
    }
}
