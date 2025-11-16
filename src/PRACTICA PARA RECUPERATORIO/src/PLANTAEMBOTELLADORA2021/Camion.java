/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PLANTAEMBOTELLADORA2021;

/**
 *
 * @author roble
 */
public class Camion extends Thread{
    
    private Planta planta;
    
    public Camion(Planta planta){
        this.planta = planta;
    }
    
    public void run(){
        try{
            while(true){
                planta.vaciarAlmacen();
                Thread.sleep(1500);
            }
            
        }catch(InterruptedException e){
            System.out.println("Error");
        }
    }
}
