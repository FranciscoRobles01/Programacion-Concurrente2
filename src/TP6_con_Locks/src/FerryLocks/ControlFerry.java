/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FerryLocks;

/**
 *
 * @author roble
 */
public class ControlFerry extends Thread{
    
    private Ferry ferry;
    
    public ControlFerry(Ferry ferry){
        this.ferry = ferry;
    }
    
    public void run(){
        try{
        while(true){
            ferry.zarpar();
            Thread.sleep(1000);
            ferry.llegaDestino();
            ferry.desembarco();
            
        }
        }catch(InterruptedException e){
            System.out.println("Error en run de control ferry");
        }
    }
}
