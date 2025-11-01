/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TomasElTren;

/**
 *
 * @author roble
 */
public class Pasajero extends Thread{
    private int numPasajero;
    private Tren tren;
    
    public Pasajero(int numPasajero, Tren tren){
        this.numPasajero= numPasajero;
        this.tren = tren;
    }
    
    public void run(){
        tren.adquirirTicket(numPasajero);
        tren.ocuparAsiento(numPasajero);
    }
}
