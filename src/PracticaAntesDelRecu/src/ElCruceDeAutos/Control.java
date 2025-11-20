/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElCruceDeAutos;

/**
 *
 * @author roble
 */
public class Control extends Thread {

    private Cruce cruce;

    public Control(Cruce cruce) {
        this.cruce = cruce;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                cruce.cambiaSemaforos();

            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
