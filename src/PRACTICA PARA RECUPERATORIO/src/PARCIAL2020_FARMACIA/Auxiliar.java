/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2020_FARMACIA;

/**
 *
 * @author roble
 */
public class Auxiliar extends Thread{

    private Farmacia farmacia;
    private int num;
    
    public Auxiliar(int num, Farmacia farmacia){
        this.num = num;
        this.farmacia = farmacia;
    }
    
    public void run(){
        try{
        while(true){
            farmacia.depositarReceta(num);
            Thread.sleep(1500);
        }
        }catch(InterruptedException e){
            System.out.println("Error");
        }
    }
    
}
