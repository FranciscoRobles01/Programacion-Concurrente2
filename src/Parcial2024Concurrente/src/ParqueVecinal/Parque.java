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
    private int capacidadActual;
    private Lock lock;
    private int escuelaEsperando;
    private int residenteEsperando;
    private boolean escuela;
    private Condition esperaEscuela;
    private Condition esperaVisitante;
    private Condition esperaResidente;

    public Parque(int capacidad) {

        capacidadMax = capacidad;
        capacidadActual = 0;
        lock = new ReentrantLock();
        esperaEscuela = lock.newCondition();
        esperaVisitante = lock.newCondition();
        esperaResidente = lock.newCondition();
        escuelaEsperando = 0;
        residenteEsperando = 0;
        escuela = false;
    }

    public void pasaVisitante(int num) {
        lock.lock();
        try {
            while (escuela || capacidadActual >= capacidadMax || residenteEsperando > 0) {
                esperaVisitante.await();
            }
            capacidadActual++;
            System.out.println("El visitante numero " + num + " se encuentra dentro del parque");
            esperaEscuela.signalAll();
            esperaResidente.signalAll();
            esperaVisitante.signalAll();

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
            while (escuela || capacidadActual >= capacidadMax) {
                esperaResidente.await();
            }
            residenteEsperando--;
            capacidadActual++;

            System.out.println("El residente numero" + num + " se encuentra dentro del parque");
            esperaEscuela.signalAll();
            esperaResidente.signalAll();
            esperaVisitante.signalAll();
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
            while (escuela || cantChicos + capacidadActual >= capacidadMax) {
                esperaEscuela.await();
            }
            escuelaEsperando--;
            escuela = true;
            capacidadMax = capacidadMax-capacidadAReducir;
            System.out.println("La escuela numero " + num + " con " + cantChicos + " estudiantes ha ingresado al parque.(El parque se ha reducido a " + capacidadAReducir + ")");
            esperaEscuela.signalAll();
            esperaResidente.signalAll();
            esperaVisitante.signalAll();
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
            esperaEscuela.signalAll();
            esperaResidente.signalAll();
            esperaVisitante.signalAll();
        } finally {
            lock.unlock();
        }
    }
    
    public void saleResidente(int num){
        lock.lock();
        try{
            System.out.println("El residente numero "+num+" se esta retirando del parque");
            capacidadActual--;
            esperaEscuela.signalAll();
            esperaResidente.signalAll();
            esperaVisitante.signalAll();
        }finally{
            lock.unlock();
        }
    }
    
    public void saleEscuela(int num, int capacidadAReducir){
    
        lock.lock();
        try{
            System.out.println("La escuela numero "+num+" se esta retirando del parque y la capacidad del parque vuelve a la normalidad");
            escuela= false;
            capacidadMax = capacidadMax+capacidadAReducir;
            esperaEscuela.signalAll();
            esperaResidente.signalAll();
            esperaVisitante.signalAll();
        
        }finally{
            lock.unlock();
        }
    }
}
