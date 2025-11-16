/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2020_FARMACIA;

/**
 *
 * @author roble
 */
public class HiloAuxiliar extends Thread{
    
    private Farmacia farmacia;


    public HiloAuxiliar(Farmacia farmacia){
        this.farmacia=farmacia;
    }
    
    public void run(){
        try{
        int i=0;
        while(true){
            Thread.sleep(1500);
            farmacia.dejarReceta(i);
            i++;
        }
        }catch(InterruptedException e){
            System.out.println("ERROR");
        }
    }
}
