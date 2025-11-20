/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParqueVecinal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author roble
 */
public class Parque {
    
    private Queue <Integer>visitantes;
    private Queue <Integer>residentes;
    private Queue <Integer>escuelas;
    private Lock lock;
    private Condition esperaVisitante;
    private Condition esperaResidente;
    private Condition esperaEscuela;
    private int cantActual;
    private int cantTotal;
    private int auxCant;
    private boolean escuelaDentro;
    
    public Parque(int cantMax){
        visitantes = new LinkedList();
        residentes = new LinkedList();
        escuelas = new LinkedList();
        lock = new ReentrantLock();
        esperaEscuela = lock.newCondition();
        esperaVisitante = lock.newCondition();
        esperaResidente = lock.newCondition();
        cantActual =0;
        auxCant=0;
        cantTotal = cantMax;
        escuelaDentro =false;
    }
    
    
    public void haceFilaResidente(int i){
        try{
            lock.lock();
            System.out.println("El residente numero "+i+" se encuentra haciendo la fila");
            residentes.add(i);
        }finally{
            lock.unlock();
        }
    }
    
        public void haceFilaVisitante(int i){
        try{
            lock.lock();
            System.out.println("El visitante numero "+i+" se encuentra haciendo la fila");
            visitantes.add(i);
        }finally{
            lock.unlock();
        }
    }
        
            public void haceFilaEscuela(int i){
        try{
            lock.lock();
            System.out.println("La escuela numero "+i+" se encuentra haciendo la fila");
            escuelas.add(i);
        }finally{
            lock.unlock();
        }
    }
    public void entraVisitante(int i){
        try{
            lock.lock();
            while(!residentes.isEmpty() || !escuelas.isEmpty() || cantActual +1 > cantTotal){
                esperaVisitante.await();
            } 
            System.out.println("El visitante numero "+i+" esta entrando al parque");
            System.out.println("CAPACIDAD ACTUAL: "+cantActual+"----------");
            visitantes.poll();
            cantActual++;
          
            esperaEscuela.signalAll();
            esperaResidente.signalAll();
            esperaVisitante.signalAll();
        }catch(InterruptedException e){
            System.out.println("Error1");
        }finally{
            lock.unlock();
        }
    }
    
    public void entraResidente(int i){
        try{
            lock.lock();
            while(!escuelas.isEmpty() || cantActual+1 > cantTotal){
                esperaResidente.await();
            }
            System.out.println("El residente numero "+i+" ha ingresado al parque");
            residentes.poll();
            cantActual++;
            System.out.println("CAPACIDAD ACTUAL: "+cantActual+"----------");
            esperaEscuela.signalAll();
            esperaResidente.signalAll();
            esperaVisitante.signalAll();
        }catch(Exception e){
            System.out.println("Error2");
        }finally{
            lock.unlock();
        }
    }
    
    public void entraEscuela(int i, int cant){
        try{
            lock.lock();
            while(cant+cantActual > cantTotal){
                esperaEscuela.await();
            }
            System.out.println("La escuela numero "+i+"ha entrado al parque con "+cant+" de chicos");
            escuelas.poll();
            cantActual = cantActual + cant;
            System.out.println("CAPACIDAD ACTUAL: "+cantActual+"----------");
            esperaEscuela.signalAll();
            esperaResidente.signalAll();
            esperaVisitante.signalAll();
        }catch(Exception e){
            System.out.println("Error3");
        }finally{
            lock.unlock();
        }
    }
    
    public void saleResidente(int i){
        try{
            lock.lock();
            System.out.println("El residente numero "+i+" esta saliendo del parque");
            cantActual--;
            esperaEscuela.signalAll();
            esperaResidente.signalAll();
            esperaVisitante.signalAll();
        }finally{
            lock.unlock();
        }
    }
    
    public void saleVisitante(int i){
        try{
            lock.lock();
            System.out.println("El visitante numero "+i+" esta saliendo del parque");
            cantActual--;
            esperaEscuela.signalAll();
            esperaResidente.signalAll();
            esperaVisitante.signalAll();
        }finally{
            lock.unlock();
        }
    }
    
    
    public void saleEscuela(int i, int cant){
    
        try{
            lock.lock();
            System.out.println("La escuela numero "+i+" esta saliendo con "+cant+" chicos del parque");
            cantActual = cantActual - cant;
            esperaEscuela.signalAll();
            esperaResidente.signalAll();
            esperaVisitante.signalAll();
        }finally{
            lock.unlock();
        }
    }
}
