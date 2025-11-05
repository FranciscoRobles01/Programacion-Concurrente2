/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObservatorioLocks;

/**
 *
 * @author roble
 */
public class Visitante extends Thread {

    private int num;
    private Observatorio observatorio;
    private char tipo;

    public Visitante(int num, Observatorio observatorio, char tipo) {
        this.num = num;
        this.observatorio = observatorio;
        this.tipo = tipo;
    }

    public void run() {
        try {
            observatorio.pasaVisitante(num, tipo);
            Thread.sleep(2000);
            observatorio.abandonaVisitante(num, tipo);
        } catch (InterruptedException e) {
            System.out.println("Error en run visitante");
        }
    }

}
