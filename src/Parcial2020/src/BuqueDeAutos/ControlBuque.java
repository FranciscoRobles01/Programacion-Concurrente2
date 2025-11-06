/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BuqueDeAutos;

/**
 *
 * @author roble
 */
public class ControlBuque extends Thread{
    
    private Transbordador buque;
    
    public ControlBuque(Transbordador buque){
        this.buque = buque;
    }
    
    public void run(){
        try{
        while(true){
            buque.dejarSubir();
            buque.ir();
            Thread.sleep(1000);
            buque.dejarBajar();
            buque.volverDelViaje();
            Thread.sleep(1000);
        }
    }catch(InterruptedException e){
            System.out.println("Error run buq");
    }
}
}
