/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParqueVecinal;

/**
 *
 * @author roble
 */
public class Escuela extends Thread {

    private int num;
    private int capacidad;
    private int capacidadAReducir;
    private Parque parque;

    public Escuela(int num, int capacidad, int capacidadAReducir, Parque parque) {
        this.num = num;
        this.capacidad = capacidad;
        this.capacidadAReducir = capacidadAReducir;
        this.parque = parque;
    }

  

    public void run() {
        try {
            parque.pasaEscuela(num, capacidad, capacidadAReducir);
            Thread.sleep(1500);
            parque.saleEscuela(num, capacidad);
        } catch (InterruptedException e) {
            System.out.println("Error en escuela run");
        }
    }

}
