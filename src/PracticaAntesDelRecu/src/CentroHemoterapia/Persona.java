/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CentroHemoterapia;

/**
 *
 * @author roble
 */
public class Persona extends Thread {

    private int num;
    private Centro centro;

    public Persona(int num, Centro centro) {
        this.num = num;
        this.centro = centro;
    }

    public void run() {

        centro.realizarLlamada(num);
        centro.irCentro(num);
        centro.irSilla(num);
        centro.irEntrevista(num);
    }
}
