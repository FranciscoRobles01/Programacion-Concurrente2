/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BarcosFery;

/**
 *
 * @author roble
 */
public class Ferry {

    private int capacidadAutos;
    private int capacidadPasajeros;
    private int capacidadActualAutos;
    private int capacidadActualPasajeros;
    private boolean zarpo;
    private boolean destino;

    public Ferry(int capacidadAutos, int capacidadPasajeros) {
        this.capacidadAutos = capacidadAutos;
        this.capacidadPasajeros = capacidadPasajeros;
        capacidadActualAutos = 0;
        capacidadActualPasajeros = 0;
        zarpo = false;
        destino = false;
    }

    public synchronized void ocuparPasajero(int num) {

        try {
            while (capacidadActualPasajeros == capacidadPasajeros || zarpo) {
                this.wait();
            }
            capacidadActualPasajeros++;
            System.out.println("El pasajero num " + num + " ha ocupado un lugar...");
            this.notifyAll();
        } catch (InterruptedException e) {
            System.out.println("Error en ocupa pasajeros");
        }
    }

    public synchronized void bajarPasajero(int num) {
        try {
            while (!destino) {
                this.wait();
            }
            capacidadActualPasajeros--;
            System.out.println("El pasajero numero " + num + " ha bajado de ferry");
            notifyAll();
        } catch (InterruptedException e) {
            System.out.println("Error bajar Pasajero");
        }
    }

    public synchronized void ocuparAuto(int num) {
        try {
            while (capacidadAutos == capacidadActualAutos || zarpo) {
                this.wait();
            }
            capacidadActualAutos++;
            System.out.println("El auto numero " + num + " ha ocupado un lugar");
            notifyAll();
        } catch (InterruptedException e) {
            System.out.println("Erro en ocupa auto");
        }
    }

    public synchronized void bajarAuto(int num) {
        try {
            while (!destino) {
                this.wait();
            }
            System.out.println("El auto numero " + num + " ha bajado de ferry");
            capacidadActualAutos--;
            notifyAll();
        } catch (InterruptedException e) {
            System.out.println("Error bajar Pasajero");
        }
    }

    public synchronized void zarpar() {
        try {
            while ((capacidadActualPasajeros < 1 || capacidadActualAutos < 1)) {
                this.wait();
            }
            zarpo = true;
            destino = false;
            System.out.println("El Ferry esta listo para zapar");
            notifyAll();
        } catch (InterruptedException e) {
            System.out.println("Error en zapar");
        }
    }

    public synchronized void terminarRecorrido() {
        System.out.println("El ferry ha terminado de hacer el recorrido");
        destino = true;
        notifyAll();
    }
    
    public synchronized void esperarDesembarque(){
        try{
            while(capacidadActualPasajeros !=0 || capacidadActualAutos !=0){
                this.wait();
            }
            zarpo=false;
            destino = false;
            notifyAll();
        }catch(InterruptedException e){
            System.out.println("Error en desembarco");
        }
    }
}
