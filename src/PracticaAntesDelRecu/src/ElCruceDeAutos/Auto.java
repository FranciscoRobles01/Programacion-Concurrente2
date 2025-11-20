/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElCruceDeAutos;

/**
 *
 * @author roble
 */
public class Auto   extends Thread {
    private int num;
    private Cruce cruce;

    public Auto(int num, Cruce cruce) {
        this.num = num;
        this.cruce = cruce;
    }

    public void run() {
        try {
            cruce.llegaNorte();
            Thread.sleep(3000);
            cruce.sale();
        } catch (Exception e) {
            System.out.println("ERROr");
        }
    }
}
