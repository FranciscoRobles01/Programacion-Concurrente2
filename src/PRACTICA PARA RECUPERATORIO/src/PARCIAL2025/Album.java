/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2025;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author roble
 */
public class Album {

    private int duracion;
    private int duracionActual;
    private String nombre;

    private Lock lock = new ReentrantLock();
    private Condition ponerMusica = lock.newCondition();
    private Condition esperaManager = lock.newCondition();

    private boolean colocandoMusica;
    private boolean escribiendoNombre;
    private boolean cortePromocion = false;

    public Album() {
        duracion = 0;
        duracionActual = 0;
        nombre = "";
        colocandoMusica = false;
        escribiendoNombre = true;
    }

    public void escribirNombre(String nombre, int duracion) {
        try {
            lock.lock();
            while (colocandoMusica) {
                esperaManager.await();
            }
            System.out.println("El manager esta escribiendo el nombre al album...");
            this.nombre = nombre;
            this.duracion = duracion;
        } catch (InterruptedException e) {
            System.out.println("Error3");
        } finally {
            lock.unlock();
        }
    }

    public void nombreEscrito(String nombre) {
        try {
            lock.lock();
            System.out.println("El manager le coloco el nombre " + nombre + " al album");
            escribiendoNombre = false;
            cortePromocion = false;
            colocandoMusica = true;
            ponerMusica.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void colocarCancion(int num, int duracion, String tipo) {
        try {
            lock.lock();
            while (cortePromocion || escribiendoNombre || duracionActual > this.duracion) {

                ponerMusica.await();
            }
            if (duracion + duracionActual > this.duracion) {
                System.out.println("El album se ha completado," + num + "," + tipo + " se le avisa al manager");
                colocandoMusica = false;
                cortePromocion = true;
                esperaManager.signal();

            } else {
                System.out.println("El productor " + num + " esta agregando una cancion de tipo " + tipo + " al album");
                duracionActual = duracionActual + duracion;
                ponerMusica.signalAll();
            }
        } catch (Exception e) {
            System.out.println("Error2");
        } finally {
            lock.unlock();
        }
    }

    public void promocionarAlbum() {
        try {
            lock.lock();
            while (colocandoMusica) {
                esperaManager.await();
            }
            System.out.println("El manager esta promocionando el album+++++++++++++++++++++++++++");
        } catch (Exception e) {
            System.out.println("Error4");
        } finally {
            lock.unlock();
        }
    }

    public void terminarPromocion() {
        try {
            lock.lock();
            System.out.println("El manager termino de promocionar el album--------------------");
            duracionActual = 0;
            duracion = 0;
            nombre = "";
            escribiendoNombre = true;
            cortePromocion = false;
        } finally {
            lock.unlock();
        }
    }

    public void pensandoNombre() {
        try {
            lock.lock();
            System.out.println("El manager se encuentra pensando en un nombre para el album...");

        } finally {
            lock.unlock();
        }
    }

}
