/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TomasElTren;
import java.util.concurrent.Semaphore;
/**
 *
 * @author roble
 */
public class Tren {
    private Semaphore bajar; //pasajero
    private Semaphore adquirirTicket; //pasajero
    private Semaphore mutex; //Tren
    private int capacidad; // tren
    private int capacidadActual;
    private Semaphore arrancar; // tren
    private Semaphore controlCapacidad;
    private Semaphore habilitaVenta;
    
    public Tren(int capacidad){
        this.capacidad = capacidad;
        this.capacidadActual =0;
        bajar = new Semaphore(0);
        mutex = new Semaphore(1);
        arrancar = new Semaphore(0);
        adquirirTicket = new Semaphore(0);
        controlCapacidad = new Semaphore(0);
        habilitaVenta = new Semaphore(1);
    }
    

    public void adquirirTicket(int num){
        try{
            adquirirTicket.acquire();
            System.out.println("El pasajero "+num+" ha comprado un ticket...");
        }catch(InterruptedException e){
            System.out.println("Error en adquirir ticket");
        }
    }
    
    public void ocuparAsiento(int num){
    
        try{
            controlCapacidad.acquire();
            mutex.acquire();
            System.out.println("El pasajero "+num+" se subio al tren...");
            capacidadActual++;
            if(capacidadActual == capacidad){
                arrancar.release();
            }
            mutex.release();
        }catch(InterruptedException e){
            System.out.println("Error en ocupar asiento");
        }
    }
    
    public void venderTicket(){
        try{
            habilitaVenta.acquire();
            System.out.println("El vendedor habilita la venta de "+capacidad+" tickets");
            adquirirTicket.release(capacidad);
            controlCapacidad.release(capacidad);
        }catch(InterruptedException e){
            System.out.println("Error vender Ticket");
        }
    }
    
    public void empiezaViaje(){
        try{
            arrancar.acquire();
            System.out.println("El tren se encuentra lleno, se procede hacer el viaje...");
        }catch(InterruptedException e){
            System.out.println("Error en empiezaViaje");
        }
    }
    
    public void finalizarViaje(){
        try{
            mutex.acquire();
            System.out.println("El tren tomas ha terminado su recorrido, le avisa a los pasajeros que pueden bajar");
            capacidadActual =0;
            System.out.println("El maquinista avisa al vendedor de tickets que puede seguir vendiendo...");
            mutex.release();
            habilitaVenta.release();
            
        }catch(InterruptedException e){
            System.out.println("Ha ocurrido un error en finalizar viaje");
        }
    }
}
