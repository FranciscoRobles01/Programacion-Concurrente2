/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observatorio;

/**
 *
 * @author roble
 */
public class Visitante extends Thread {

    private int num;
    private char tipo;
    private Sala sala;

    public Visitante(int num, char tipo, Sala sala) {
        this.num = num;
        this.tipo = tipo;
        this.sala = sala;
    }

    public void run() {
        try {
            sala.ingresaVisitante(num, tipo);
            Thread.sleep(1500);
            sala.saleVisitante(num, tipo);
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            System.out.println("Error en run visitante");
        }
    }
}
