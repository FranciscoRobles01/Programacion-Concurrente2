/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2020_PUNTO2;

/**
 *
 * @author roble
 */
public class Auto extends Thread {

    private int num;
    private Buque buq;

    public Auto(int num, Buque buq) {
        this.num = num;
        this.buq = buq;
    }

    public void run() {
        try {
            buq.subir(num);
            Thread.sleep(1800);
            buq.bajar(num);

            Thread.sleep(1800);

        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
}
