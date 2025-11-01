/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BarcosFery;

/**
 *
 * @author roble
 */
public class Capitan extends Thread{
    private int num;
    private Ferry ferry;
    
    public Capitan(int num, Ferry ferry){
        this.num = num;
        this.ferry = ferry;
    }


    
    public void run(){
    try{
        while(true){
            ferry.zarpar();
            Thread.sleep(1000);
            ferry.terminarRecorrido();
            ferry.esperarDesembarque();
        }
    }catch(InterruptedException e){
        System.out.println("Error ");
    }
    }
    
}
