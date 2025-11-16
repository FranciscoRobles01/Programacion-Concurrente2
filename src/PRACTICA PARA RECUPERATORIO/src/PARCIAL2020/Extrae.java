/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2020;

/**
 *
 * @author roble
 */
public class Extrae extends Thread{
    
    private BufferOscilante buffer;
    
    public Extrae(BufferOscilante buf){
           buffer=buf;
    }

    
    public void run(){
        try{
        while(true){
            
                buffer.extraer();
                Thread.sleep(1000);
        }
        }catch(InterruptedException e){
            System.out.println("error");
        }
    }
}
