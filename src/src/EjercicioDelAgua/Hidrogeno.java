/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioDelAgua;

/**
 *
 * @author roble
 */
public class Hidrogeno extends Thread{
    
    private Proceso proceso;
    private int numHidrogeno;
    
    public Hidrogeno(int numHidrogeno, Proceso proceso){
        this.proceso = proceso;
        this.numHidrogeno= numHidrogeno;
    }
    
    
    public void run(){
       
            try{
                proceso.Hlisto(numHidrogeno);
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Error en run hidrogeno");
            }
      
    }
    
}
