/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Taxista;

/**
 *
 * @author roble
 */
public class Usted extends Thread{
    
    private int id;
    private Taxi taxi;
    
    public Usted(int id, Taxi taxi){
        this.id = id;
        this.taxi = taxi;
    }
    
    public void run(){
        try{
            while(true){
                Thread.sleep(1000);
                taxi.solicitaTaxi(id);
                taxi.bajarTaxi();
            
            }
        }catch(InterruptedException e){
            System.out.println("Error en run usted");
        }
    }
}
