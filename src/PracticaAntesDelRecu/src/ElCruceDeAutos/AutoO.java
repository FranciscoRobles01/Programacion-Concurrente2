/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElCruceDeAutos;

/**
 *
 * @author roble
 */
public class AutoO extends Thread{

    private int num;
    private Cruce cruce;

    public AutoO(int num, Cruce cruce) {
        this.num = num;
        this.cruce = cruce;
    }

    public void run() {
        try {
            cruce.llegaOeste();
            Thread.sleep(3000);
            cruce.sale();
        } catch (Exception e) {
            System.out.println("ERROr");
        }
    }
}
