/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BuqueDeAutos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class Transbordador {

    private Semaphore capacidad;
    private int cantActual;
    private Semaphore bajar;
    private Semaphore mutex;
    private Semaphore volver;
    private Semaphore arrancar;

    public Transbordador() {
        capacidad = new Semaphore(0);
        cantActual = 0;
        volver = new Semaphore(0);
        bajar = new Semaphore(0);
        mutex = new Semaphore(1);
        arrancar = new Semaphore(0);
    }

    public void dejarSubir() {
        System.out.println("El buque se prepara para zarpar, deja subir a los autos");
        capacidad.release(10);

    }

    public void subirBuque(int num) {
        try {
            capacidad.acquire();
            mutex.acquire();
            cantActual++;
            System.out.println("El auto numero " + num + " ha subido al buque");

            if (cantActual == 10) {
                arrancar.release();
            }
            mutex.release();
        } catch (InterruptedException e) {
            System.out.println("Subir buq");
        }
    }

    public void ir() {
        try {
            arrancar.acquire();
            System.out.println("La capacidad del buque ha sido alcanzada, se procede con el viaje");
        } catch (InterruptedException e) {
            System.out.println("IR");
        }
    }

    public void dejarBajar() {
        System.out.println("Se ha llegado a destino, se le avisa a los autos que pueden bajar");
        bajar.release();
    }

    public void bajarBuque(int num) {
        try {
            bajar.acquire();
            mutex.acquire();
            System.out.println("El auto numero" + num + " ha bajado del buque");
            cantActual--;
            if (cantActual == 0) {
                mutex.release();
                volver.release();
            } else {
                mutex.release();
                bajar.release();
            }
        } catch (InterruptedException e) {
            System.out.println("Error bajarBuqe");
        }
    }

    public void volverDelViaje() {
        try {
            volver.acquire();
            System.out.println("Todos los autos han bajado del buque, se vuelve a punto de inicio");
        } catch (InterruptedException e) {
            System.out.println("Error volverViaje");
        }
    }
}
