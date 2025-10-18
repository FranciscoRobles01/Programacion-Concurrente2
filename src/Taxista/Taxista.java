/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Taxista;

/**
 *
 * @author roble
 */
public class Taxista extends Thread {

    private Taxi taxi;
    private int id;

    public Taxista(int id, Taxi taxi) {
        this.taxi = taxi;
        this.id = id;
    }

    public void run() {
        while (true) {

            taxi.realizarViaje();
            taxi.finalizarViaje();
            taxi.dormir();

        }
    }
}
