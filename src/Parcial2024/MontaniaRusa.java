/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial2024;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class MontaniaRusa {

    private Semaphore dejarSubir = new Semaphore(0);
    private Semaphore dejarBajar = new Semaphore(0);
    private Semaphore lleno = new Semaphore(0);
    private Semaphore mutex = new Semaphore(1);
    private int capacidad;
    private int capacidadActual;

    public MontaniaRusa(int capacidad) {
        this.capacidad = capacidad;
        this.capacidadActual = 0;
    }

    public void dejarSubir() {
        System.out.println("Carrito permite subir a los pasajeros....");
        dejarSubir.release();
    }

    public void subir(int i) {
        try {
            dejarSubir.acquire();
            mutex.acquire();
            System.out.println("El pasajero " + i + " se ha subido al carrito");
            capacidadActual++;
            if (capacidadActual == capacidad) {
                System.out.println("Carrito lleno...");
                lleno.release();
            } else {       
                dejarSubir.release();
            }
            mutex.release();
        } catch (InterruptedException e) {
            System.out.println("Error en SUBIR");
        }
    }

    public void empezarViaje() {
        try {
            lleno.acquire();
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error en EMPEZAR VIAJE");
        }
    }

    public void dejarBajar() {
        dejarBajar.release();
    }

    public void bajar(int i) {
        try {
            dejarBajar.acquire();
            mutex.acquire();
            System.out.println("El pasajero " + i + " se esta bajando del carrito");

            capacidadActual--;
            if (capacidadActual == 0) {
                System.out.println("Todos los pasajeros han bajado del carrito");
            } else {
                dejarBajar.release();
            }
            mutex.release();

        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error en BAJAR");
        }
    }

}
