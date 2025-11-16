/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PLANTAEMBOTELLADORA2021;

/**
 *
 * @author roble
 */
public class Embotellador extends Thread{

    private int num;
    private Planta planta;
    
    public Embotellador(int num, Planta planta){
        this.num =num;
        this.planta = planta;
    }
    
    public void run(){
        try{
        while(true){
            planta.ponerBotellaA(num);
            Thread.sleep(1000);
        }
        }catch(InterruptedException e){
            System.out.println("Error");
        }
    }
}
