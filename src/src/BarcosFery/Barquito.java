/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BarcosFery;

/**
 *
 * @author roble
 */
public class Barquito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ferry ferry = new Ferry(4, 4);
        Pasajero pasajeros[] = new Pasajero[10];
        Automovil automoviles[] = new Automovil[10];
        Capitan capitan = new Capitan(1, ferry);
        capitan.start();
        for (int i = 0; i < pasajeros.length; i++) {
            pasajeros[i] = new Pasajero((i + 1), ferry);
        }

        for (int i = 0; i < automoviles.length; i++) {
            automoviles[i] = new Automovil((i + 1), ferry);
        }

        for (int i = 0; i < pasajeros.length; i++) {
            pasajeros[i].start();
        }

        for (int i = 0; i < automoviles.length; i++) {
            automoviles[i].start();
        }
    }

}
