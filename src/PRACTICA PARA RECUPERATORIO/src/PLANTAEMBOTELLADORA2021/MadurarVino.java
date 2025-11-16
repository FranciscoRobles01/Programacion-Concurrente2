/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PLANTAEMBOTELLADORA2021;

/**
 *
 * @author roble
 */
public class MadurarVino extends Thread{
    
    private Planta planta;
    private int time;
    public MadurarVino(Planta planta, int time){
        this.planta=planta;
        this.time = time;
    }
    
    public void run(){
        try{
            while(true){
                planta.madurarVino();
                Thread.sleep(time);
                planta.vinoMadurado();
            }
        }catch(InterruptedException e){
            System.out.println("Error");
        }
    }
}
