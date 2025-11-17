/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PizzasADomicilio;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author roble
 */
public class Mostrador {

    private Lock lock;
    private Condition hacerPizzaN;
    private Condition hacerPizzaV;
    private int pizzasMostrador;
    private Condition hacerReparto;
    private Queue<Cliente> ordenesListas;
    private Queue<Cliente> ordenesV;
    private Queue<Cliente> ordenesN;

    public Mostrador() {
        lock = new ReentrantLock();
        ordenesN = new LinkedList();
        ordenesV = new LinkedList();
        ordenesListas = new LinkedList();
        hacerPizzaN = lock.newCondition();
        hacerPizzaV = lock.newCondition();
        hacerReparto = lock.newCondition();

    }

    public void generarPedido(String tipo, String nom) {
        try {
            lock.lock();
            if (tipo.equalsIgnoreCase("napolitana")) {
                System.out.println("El cliente " + nom + " esta solicitando pizza napolitana");
                ordenesN.add(new Cliente(tipo, nom));
            } else {
                System.out.println("El cliente " + nom + " esta solicitando pizza vegana");
                ordenesV.add(new Cliente(tipo, nom));
            }
            hacerPizzaN.signalAll();
            hacerPizzaV.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void prepararPizzaN(int num) {
        try {
            lock.lock();
            while (pizzasMostrador == 10 || ordenesN.isEmpty()) {
                hacerPizzaN.await();
            }
            System.out.println("El maestro pizzero " + num + " de napolitana, se encuentra haciendo un pizza");
        } catch (InterruptedException e) {
            System.out.println("Error");
        } finally {
            lock.unlock();
        }
    }

    public void prepararPizzaV(int num) {
        try {
            lock.lock();
            while (pizzasMostrador == 10 || ordenesV.isEmpty()) {
                hacerPizzaV.await();
            }
            System.out.println("El maestro pizzero " + num + " de pizza vegana, se encuentra haciendo dos pizzas");
        } catch (InterruptedException e) {
            System.out.println("Error");
        } finally {
            lock.unlock();
        }
    }

    public void pizzaVTerminada(int num) {
        try {
            lock.lock();
            System.out.println("El maestro pizzero vegano " + num + " ha terminado de hacer dos pizzas veganas y las deja en el mostrador");
            pizzasMostrador = pizzasMostrador + 2;
            ordenesListas.add(ordenesV.peek());
            ordenesV.poll();
            hacerReparto.signalAll();
        } finally {
            lock.unlock();
        }
    }
    
    public void pizzaNTerminada(int num) {
        try {
            lock.lock();
            System.out.println("El maestro pizzero napolitano " + num + " ha terminado de hacer una pizza napolitana y la deja en el mostrador");
            pizzasMostrador = pizzasMostrador + 1;
            ordenesListas.add(ordenesN.peek());
            ordenesN.poll();
            hacerReparto.signalAll();
        } finally {
            lock.unlock();
        }
    }
    
    public void repartir(int num){
        try{
            lock.lock();
            while(ordenesListas.isEmpty()){
                hacerReparto.await();
            }
            System.out.println("El repartidor numero "+num+" recoge un pedido de "+ordenesListas.peek().getOrden()+" y se la lleva al cliente "+ ordenesListas.peek().getNombre());
            ordenesListas.poll();
        }catch(InterruptedException e){
            System.out.println("ERROR");
        }finally{
            lock.unlock();
        }
    }
    
    public void darPedido(int num){
        try{
            lock.lock();           
            System.out.println("El repartidor"+num+" llego a la casa del cliente y le entrega su pedido");
        }finally{
            lock.unlock();
        }
    }
}
