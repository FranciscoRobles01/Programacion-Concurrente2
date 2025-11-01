/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LosBabuinos;

/**
 *
 * @author roble
 */
public class BabuinosIzq extends Thread{

    private int num;
    private Cuerda cuerda;

    public BabuinosIzq(int num, Cuerda cuerda) {
        this.num = num;
        this.cuerda = cuerda;
    }

 
    public void run() {
        try {
            cuerda.avisarCruceIzquierdaDerecha();
            cuerda.tomarCuerda(num, "izquierda a derecha");
            Thread.sleep(1000);
            cuerda.bajarCuerdaIzquierda();
            cuerda.soltarCuerda(num,"izquierda a derecha");
            
        } catch (InterruptedException e) {
            System.out.println("Error en run babuinos");
        }
    }
}

