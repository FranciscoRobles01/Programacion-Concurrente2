/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CentroHemoterapia;

/**
 *
 * @author roble
 */
public class Recepcionista extends Thread{
    
    private Centro centro;
    
    public Recepcionista(Centro centro){
        this.centro = centro;
    }

    
    public void run(){
    try{
        while(true){
            centro.atenderLlamada();
            Thread.sleep(1000);
            centro.finalizarLlamada();
        }
    }catch(InterruptedException e){
        System.out.println("ERROR");
    }
    }
}
