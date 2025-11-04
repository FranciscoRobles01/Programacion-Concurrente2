/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FerryLocks;

/**
 *
 * @author roble
 */
public class Pasajero extends Thread{
    
    private int num;
    private Ferry ferry;
    
    public Pasajero(int num, Ferry ferry){
        this.num = num;
        this.ferry = ferry;
    }
    
    public void run(){
        ferry.ocuparEspacio(num);
        ferry.bajarFerryPasajero(num);
    }
}
