/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2020_TEMAII_PUNTO2;

/**
 *
 * @author roble
 */
public class Auto extends Thread {

    private int num;
    private GestorCruce gestor;

    public Auto(int num, GestorCruce gestor) {
        this.num = num;
        this.gestor = gestor;
    }

    public void run() {
        try {
            gestor.llegaNorte();
            Thread.sleep(1000);
            gestor.sale();
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }
}
