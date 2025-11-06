/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParqueVecinal;

/**
 *
 * @author roble
 */
public class Residente extends Thread{
    
    private int num;
    private Parque parque;
    
    public Residente(int num, Parque parque){
        this.num = num;
        this.parque=parque;
    }
    
    public void run(){
        try{
            parque.pasaResidente(num);
            Thread.sleep(2500);
            parque.saleResidente(num);
        }catch(InterruptedException e){
            System.out.println("Error");
        }
    }
}

