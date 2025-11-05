/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObservatorioLocks;

/**
 *
 * @author roble
 */
public class Mantenimiento extends Thread {

    private int num;
    private Observatorio observatorio;

    public Mantenimiento(int num, Observatorio observatorio) {
        this.num = num;
        this.observatorio = observatorio;
    }

    public void run() {
        try {
            int i=0;
            while (i < 3) {
                observatorio.pasaMantenimiento(num);
                Thread.sleep(1000);
                observatorio.abandonaMatenimiento(num);
                Thread.sleep(2000);
                i++;
            }
        } catch (InterruptedException e) {
            System.out.println("Erro en run mantenimiento");
        }
    }
}
