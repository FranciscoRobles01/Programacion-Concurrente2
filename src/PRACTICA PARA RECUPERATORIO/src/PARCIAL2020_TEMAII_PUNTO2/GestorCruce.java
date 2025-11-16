/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2020_TEMAII_PUNTO2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class GestorCruce {

    private Semaphore cruceN;
    private Semaphore cruceO;
    private Semaphore mutex;
    private Semaphore espera;
    private boolean pasaN;
    private boolean pasaO;

    public GestorCruce() {

        cruceN = new Semaphore(1);
        cruceO = new Semaphore(0);
        mutex = new Semaphore(1);
        espera = new Semaphore(0);
        pasaN = true;
        pasaO = true;
    }

    public void llegaNorte() {
        try {
            cruceN.acquire();
            mutex.acquire();
            if (!pasaN) {
                cruceN.acquire();
            }
            System.out.println("Un auto esta llegando se dirige de N a S");
            mutex.release();

        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }

    public void llegaOeste() {

        try {
            cruceO.acquire();
            mutex.acquire();
            if (pasaO) {
                cruceO.acquire();
            }
            System.out.println("Un auto esta pasando de O a E");
            mutex.release();

        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }

    public void sale() {
        try {
            mutex.acquire();
            if (pasaN) {
                System.out.println("Un auto se encuentra saliendo del cruce de N a S");
                cruceN.release();
            } else {
                System.out.println("Un auto se encuentra saliendo del cruce de O a E");
                cruceO.release();
            }
            mutex.release();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }

    public synchronized void cambiaSemaforos() {

        try {
            mutex.acquire();
            if (pasaN) {
                pasaN = false;
                cruceO.release();
            } else {
                pasaO = true;
                pasaN = false;
                cruceN.release();
            }
            mutex.release();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
}
