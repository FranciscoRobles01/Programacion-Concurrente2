/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial2024;

/**
 *
 * @author roble
 */
public class Pasajero extends Thread {

    private int numPasajero;
    private MontaniaRusa montania;

    public Pasajero(int numPasajero, MontaniaRusa montania) {
        this.numPasajero = numPasajero;
        this.montania = montania;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                montania.subir(numPasajero);
                montania.bajar(numPasajero);
          
            }
        } catch (InterruptedException e) {
            System.out.println("Error en CLASE PASAJERO");
        }
    }
}
