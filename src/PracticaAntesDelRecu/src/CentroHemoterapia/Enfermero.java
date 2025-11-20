/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CentroHemoterapia;

/**
 *
 * @author roble
 */
public class Enfermero extends Thread{
    
    private Centro centro;
    
    public Enfermero(Centro centro){
        this.centro = centro;
    }

 
    
    public void run(){
        try{
            while(true){
                centro.hacerExtraccion();
                Thread.sleep(1000);
                centro.finalizarExtraccion();
            }
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
}
