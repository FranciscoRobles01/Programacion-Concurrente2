/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoSalaEstudio;

/**
 *
 * @author roble
 */
public class Sala {

    private int mesas;
    private int mesasOcupadas;

    public Sala(int cantMesas) {
        mesas = cantMesas;
        mesasOcupadas = 0;
    }

    public synchronized void ocuparMesa(int num) {
        try {
            while (mesasOcupadas == mesas) {
                this.wait();
            }
            System.out.println("El alumno numero " + num + " ha ocupada un silla...");
            mesasOcupadas++;
        } catch (InterruptedException e) {
            System.out.println("Error en ocupar mesa");
        }
    }
    
    public synchronized void dejarMesa(int num){
        System.out.println("El alumno numero "+num+" ha dejado su silla");
        mesasOcupadas--;
        this.notify();
    }
}
