/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2020_PUNTO2;

/**
 *
 * @author roble
 */
public class ControlBuqe extends Thread{
    
    private Buque buq;
    
    public ControlBuqe(Buque buq){
        this.buq = buq;
    }
    
    public void run(){
        try{
        while(true){
            buq.dejarSubir();
            buq.ir();
            Thread.sleep(1500);
            buq.dejarBajar();
            buq.volver();
            Thread.sleep(1500);
        }
    }catch(InterruptedException e){
            System.out.println("Error");
    }
    
    }
}
