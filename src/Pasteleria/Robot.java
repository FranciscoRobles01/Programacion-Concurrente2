/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author roble
 */
public class Robot extends Thread{
    
    private Cinta cinta;
    private int num;
    
    public Robot(int num, Cinta cinta){
        this.cinta = cinta;
        this.num = num;
    }
    
    public void run(){
        try{
        while(true){
        
            cinta.tomarPastel(num);
            Thread.sleep(1000);
            
        }
        }catch(InterruptedException e){
            System.out.println("ERROR RUN ROBOT");
        }
    }
    
}
