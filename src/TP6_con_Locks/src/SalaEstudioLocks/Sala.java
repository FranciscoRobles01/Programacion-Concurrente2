/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalaEstudioLocks;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author roble
 */
public class Sala {
    
    private  int cantMax;
    private int cantActual;
    
    private Lock mesa = new ReentrantLock();
    private Condition mesaLibre = mesa.newCondition();
    
    public Sala(int cant){
        cantMax = cant;
    }
    
    public void ocuparMesa(int num){
        mesa.lock();
        try{
        while(cantActual == cantMax){
            mesaLibre.await();
        }
        cantActual++;
            System.out.println("El estudiante numero "+num+" ha ocupado una mesa");
        }catch(InterruptedException e){
            System.out.println("Error ocupa mesa");
        }finally{
            mesa.unlock();
        }
    }
    
    public void desocuparMesa(int num ){
        mesa.lock();
        try {
            System.out.println("El estudiante numero "+num+" ha desocupado la mesa..");
            cantActual--;
            mesaLibre.signalAll();
        } finally {
            mesa.unlock();
        }
    }
}
