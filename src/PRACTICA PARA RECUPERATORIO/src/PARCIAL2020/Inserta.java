/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2020;

/**
 *
 * @author roble
 */
public class Inserta extends Thread{
    
    private BufferOscilante buffer;
    
    public Inserta(BufferOscilante buf){
        buffer=buf;
    }
    
    public void run(){
        int i=0;
        try{
        while(true){
            buffer.insertar(i);
            i++;
            Thread.sleep(1000);
        }
        }catch(InterruptedException e){
            System.out.println("Error");
        }
    }
    
}
