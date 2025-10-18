/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recu2023;

/**
 *
 * @author roble
 */
public class Pequenio extends Thread {

    private int numPequenio;
    private Mesa mesa;

    public Pequenio(int numPequenio, Mesa mesa) {
        this.numPequenio = numPequenio;
        this.mesa = mesa;
    }

    public void run() {
        int banquito;
        try {
            while (true) {
                banquito = mesa.intentarSentarse(numPequenio);
                mesa.avisarAMayor(numPequenio);
                mesa.comer(numPequenio);
                mesa.terminarDeComer(numPequenio, banquito);
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            System.out.println("Error en pequenio");

        }
    }
}
