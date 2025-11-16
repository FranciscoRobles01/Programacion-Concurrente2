/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PLANTAEMBOTELLADORA2021;

/**
 *
 * @author roble
 */
public class Empaquetador extends Thread{
    
    private Planta planta;
    
    public Empaquetador(Planta planta){
        this.planta = planta;
    }
    
    public void run(){
        try{
        while(true){
            planta.cambiarCaja();
            Thread.sleep(1000);
        }
        }catch(InterruptedException e){
            System.out.println("Error");
        }
    }
}

