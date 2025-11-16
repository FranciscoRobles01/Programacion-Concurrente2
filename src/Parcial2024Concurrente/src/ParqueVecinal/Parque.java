/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParqueVecinal;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/**
 *
 * @author roble
 */
public class Parque {

    private int capacidadMax;
    private int capacidadMaxAux;
    private int capacidadActual;
    private Lock lock;
    private int escuelaEsperando;
    private int residenteEsperando;
    private int capacidadReducidaActual;
    private Condition esperaEscuela;
    private Condition esperaVisitante;
    private Condition esperaResidente;

    public Parque(int capacidad) {
        capacidadMaxAux = capacidad;
        capacidadMax = capacidad;
        capacidadActual = 0;
        lock = new ReentrantLock();
        esperaEscuela = lock.newCondition();
        esperaVisitante = lock.newCondition();
        esperaResidente = lock.newCondition();
        escuelaEsperando = 0;
        residenteEsperando = 0;
        capacidadReducidaActual = 0;
    }

    public void pasaVisitante(int num) {
        lock.lock();
        try {
            while (escuelaEsperando > 0 || capacidadActual >= capacidadMax || residenteEsperando > 0) {
                esperaVisitante.await();
            }
            capacidadActual++;
            System.out.println("El visitante numero " + num + " se encuentra dentro del parque");

        } catch (InterruptedException e) {
            System.out.println("Error");
        } finally {
            lock.unlock();
        }
    }

    public void pasaResidente(int num) {
        lock.lock();
        try {
            residenteEsperando++;
            while (escuelaEsperando > 0 || capacidadActual >= capacidadMax) {
                esperaResidente.await();
            }
            residenteEsperando--;
            capacidadActual++;

            System.out.println("El residente numero " + num + " se encuentra dentro del parque");

        } catch (InterruptedException e) {
            System.out.println("Error");
        } finally {
            lock.unlock();
        }
    }

    public void pasaEscuela(int num, int cantChicos, int capacidadAReducir) {
        lock.lock();
        try {
            escuelaEsperando++;
            while (cantChicos + capacidadActual > capacidadMax || capacidadReducidaActual > capacidadAReducir) {
                esperaEscuela.await();
            }
            escuelaEsperando--;
            capacidadReducidaActual = capacidadAReducir;
            capacidadMax = capacidadAReducir;
            capacidadActual = capacidadActual + cantChicos;
            System.out.println("La escuela numero " + num + " con " + cantChicos + " estudiantes ha ingresado al parque.(El parque se ha reducido a " + capacidadAReducir + ")");

        } catch (InterruptedException e) {
            System.out.println("Error en pasaEscuela");
        } finally {
            lock.unlock();
        }
    }

    public void saleVisitante(int num) {
        lock.lock();
        try {
            System.out.println("El visitante numero " + num + " se esta retirando del parque");
            capacidadActual--;
            esperaResidente.signalAll();
            esperaEscuela.signalAll();
            esperaVisitante.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public void saleResidente(int num) {
        lock.lock();
        try {
            System.out.println("El residente numero " + num + " se esta retirando del parque" + capacidadMax);
            capacidadActual--;
            esperaVisitante.signalAll();
            esperaResidente.signalAll();
            esperaEscuela.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public void saleEscuela(int num, int chicos) {

        lock.lock();
        try {
            capacidadActual = capacidadActual - chicos;
            capacidadMax = capacidadMaxAux;
            capacidadReducidaActual = 0;
            System.out.println("La escuela numero " + num + " se esta retirando del parque y la capacidad del parque vuelve a la normalidad " + capacidadMax);
            esperaVisitante.signalAll();
            esperaResidente.signalAll();

            esperaEscuela.signalAll();

        } finally {
            lock.unlock();
        }
    }
}
