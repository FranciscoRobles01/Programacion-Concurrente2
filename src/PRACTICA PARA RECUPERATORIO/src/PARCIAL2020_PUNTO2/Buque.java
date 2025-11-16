/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2020_PUNTO2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author roble
 */
public class Buque {

    private int capacidad;
    private Lock lock;
    private Condition baja;
    private Condition sube;
    private Condition arrancar;
    private int capacidadActual;
    private boolean viajeTerminado;
    private boolean dejarSubir;
    
    public Buque(int capacidad) {
        this.capacidad = capacidad;
        lock = new ReentrantLock();
        baja = lock.newCondition();
        sube = lock.newCondition();
        arrancar = lock.newCondition();
        capacidadActual = 0;
        viajeTerminado = false;
        dejarSubir = false;
    }

    public void dejarSubir(){
        try{
            lock.lock();
            System.out.println("El buque se encuentra en el puerto, permite subir a los autos");
            dejarSubir = true;
            sube.signalAll();
        }finally{
            lock.unlock();
        }
    }
    
    public void subir(int i) {
        try {
            lock.lock();
            while (capacidadActual >= capacidad || !dejarSubir) {
                sube.await();
            }
            System.out.println("El auto numero " + i + " esta abordando el buque");
            capacidadActual++;

            arrancar.signal();
            sube.signalAll();
        } catch (InterruptedException e) {
            System.out.println("Error");
        } finally {
            lock.unlock();
        }
    }

    public void ir() {
        try {
            lock.lock();
            while (capacidadActual < capacidad) {
                arrancar.await();
            }
            dejarSubir=false;
            System.out.println("El buque esta completo, se procede con el viaje...");
        } catch (InterruptedException e) {
            System.out.println("Error");
        } finally {
            lock.unlock();
        }
    }

    public void dejarBajar() {
        try {
            lock.lock();
            System.out.println("El buque ha llegado a destino, deja bajar a los autos");
            viajeTerminado = true;
            baja.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void bajar(int i) {
        try {
            lock.lock();
            while (!viajeTerminado) {
                baja.await();
            }
            System.out.println("El auto numero " + i + " se esta bajando del buque");
            capacidadActual--;
            baja.signalAll();
            arrancar.signal();
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        } finally {
            lock.unlock();
        }
    }
    
    public void volver(){
        try{
            lock.lock();
            while(capacidadActual >0){
                arrancar.await();
            }
            System.out.println("El buque se ha descargado, procede a volver puerto...");
            viajeTerminado = false;
        }catch(InterruptedException e){
            System.out.println("Error");
        }finally{
            lock.unlock();
        }
    }

}
