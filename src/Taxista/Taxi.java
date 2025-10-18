/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Taxista;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class Taxi {

    private int id;
    private Semaphore solicita;
    private Semaphore destino;
    private Semaphore dormir;

    public Taxi(int id) {
        this.solicita = new Semaphore(0);
        this.destino = new Semaphore(0);
        this.dormir = new Semaphore(0);
    }

    public void solicitaTaxi(int num) {
        try {
            System.out.println("El pasajero solicita un taxi...");
            Thread.sleep(1000);
            solicita.release();
        } catch (InterruptedException e) {
            System.out.println("ERROR EN SOLICITATAXI");
        }
    }

    public void realizarViaje() {
        try{
            solicita.acquire();
            System.out.println("El taxista desperto y realiza el viaje");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error");
        }
 
    }

    public void finalizarViaje() {
        System.out.println("El viaje a terminado y se llego a destino, el taxista le avisa al pasajero...");
        destino.release();
    }

    public void bajarTaxi() {
        try {
            destino.acquire();
            System.out.println("El pasajero, paga, saluda y sale del taxi");
            Thread.sleep(500);
            dormir.release();
        } catch (InterruptedException e) {
            System.out.println("ERROR EN BAJAR TAXI");
        }
    }
    
    public void dormir(){
        try{
            dormir.acquire();
            System.out.println("El taxista esta durmiendo....");
            Thread.sleep(1000);
    }catch(InterruptedException e){
            System.out.println("El metodo dormi esta fallando");
    }
    }
}
