/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FerryLocks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author roble
 */
public class Ferry {

    private int espacioActual;
    private final int cantMax;
    private final Lock ocupar = new ReentrantLock();
    private final Condition hayLugar = ocupar.newCondition();
    private final Condition desembarcar = ocupar.newCondition();
    private final Condition puedeZarpar = ocupar.newCondition();
    private boolean zarpar;

    public Ferry(int cant) {
        cantMax = cant;
        zarpar = false;
        espacioActual = 0;
    }

    public void ocuparEspacio(int num) {
        try {
            ocupar.lock();
            while (espacioActual + 1 > cantMax || zarpar) {
                hayLugar.await();
            }
            espacioActual++;
            System.out.println("El pasajero numero " + num + " ha ocupado un espacio en el Ferry");
            if(espacioActual > 0){
                puedeZarpar.signalAll();
            }
        } catch (InterruptedException e) {
            System.out.println("Error en ocupar espacio");
        } finally {
            ocupar.unlock();
        }
    }

    public void ocuparEspacioAuto(int num, int espacio) {

        try {
            ocupar.lock();
            while (espacio + espacioActual > cantMax || zarpar) {
                hayLugar.await();
            }
            espacioActual = espacioActual + espacio;
            System.out.println("El auto numero " + num + " ha ocupado " + espacio + " espacios en el ferry");
            
            if(espacioActual > 0){
                puedeZarpar.signalAll();
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR OCUPA ESPACIO AUTO");
        } finally {
            ocupar.unlock();
        }
    }

    public void bajarFerryPasajero(int num) {
        try {
            ocupar.lock();
            while (!zarpar) {
                desembarcar.await();
            }
            System.out.println("El pasajero numero " + num + " ha bajado del ferry");
            espacioActual--;
            if(espacioActual ==0){
                puedeZarpar.signalAll();
            }
        } catch (InterruptedException e) {
            System.out.println("Error en desocuparLugar");
        }finally{
            ocupar.unlock();
        }
    }

    public void bajarFerryAuto(int num, int espacio) {
        try {
            ocupar.lock();
            while (!zarpar) {
                desembarcar.await();
            }
            System.out.println("El auto numero " + num + " ha bajado del ferry");
            espacioActual = espacioActual - espacio;
            if(espacioActual ==0){
                puedeZarpar.signalAll();
            }
        } catch (InterruptedException e) {
            System.out.println("Error en desocuparLugar");
        }finally{
            ocupar.unlock();
        }
    }

    public void zarpar() {
        try {
            ocupar.lock();
            while (espacioActual == 0) {
                puedeZarpar.await();
            }

            System.out.println("El ferry se encuentra en viaje con " + espacioActual + " espacio ocupados");
        } catch (InterruptedException e) {
            System.out.println("Error en zarpar");
        } finally {
            ocupar.unlock();
        }
    }

    public void llegaDestino(){
   
            ocupar.lock();
        try {
            System.out.println("El ferry llego a destino");
            zarpar=true;
            desembarcar.signalAll();
            
        } finally {       
            ocupar.unlock();
        }
        
    }
    public void desembarco() {
        try {
            ocupar.lock();
            while (espacioActual > 0) {
                puedeZarpar.await();
            }
         
            System.out.println("El ferry ha terminado su viaje, espera a que se suban pasajeros y autos");
            zarpar=false;
            hayLugar.signalAll();
        } catch (InterruptedException e) {
            System.out.println("Error");
        } finally {
            ocupar.unlock();
        }
    }
}
