/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2020;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class BufferOscilante {

    private Queue colaInserta = new LinkedList();
    private Queue colaExtrae = new LinkedList();
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore mutex;

    public BufferOscilante() {
        sem1 = new Semaphore(1);
        mutex = new Semaphore(1);
        sem2 = new Semaphore(1);

    }

    public void insertar(int i) {
        try {
            sem1.acquire();
            mutex.acquire();
            System.out.println("Se esta insertando el elemento "+i);
            colaInserta.offer(i);
            System.out.println("Cola Extrae: "+colaExtrae.toString()+"\n"+"Cola Inserta: "+colaInserta.toString() );
            mutex.release();
            sem1.release();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
    
    public void extraer(){
        try{
            sem1.acquire();
            mutex.acquire();
            if(colaExtrae.isEmpty()){
                System.out.println("Intercambia valores de las colas");
                Queue aux = colaInserta;
                colaInserta = colaExtrae;
                colaExtrae = aux;
                System.out.println("Cola Extrae: "+colaExtrae.toString()+"\n"+"Cola Inserta: "+colaInserta.toString() );
            }else{
                System.out.println("Se quito un elemento");
                colaExtrae.poll();
            }
            mutex.release();
            sem1.release();
        }catch(InterruptedException e){
            System.out.println("");
        }
    }

}
