/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParqueVecinal;

/**
 *
 * @author roble
 */
public class Visitante extends Thread {

    private int num;
    private Parque parque;

    public Visitante(int num, Parque parque) {

        this.num = num;
        this.parque = parque;
    }

    public void run() {
        try {
            parque.haceFilaVisitante(num);
            parque.entraVisitante(num);
            Thread.sleep(1000);
            parque.saleVisitante(num);
        } catch (Exception e) {
            System.out.println("eRROR5");
        }
    }
}
