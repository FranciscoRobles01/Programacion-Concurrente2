/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2020_TEMAII_PUNTO2;

/**
 *
 * @author roble
 */
public class ControlSemaforos extends Thread{
    
    private GestorCruce gestor;
    
    public ControlSemaforos(GestorCruce gestor){
        this.gestor = gestor;
    }
    
    public void run(){
        try{
            while(true){
                Thread.sleep(3000);
                gestor.cambiaSemaforos();
            }
        
        }catch(InterruptedException e){
            System.out.println("Error");
        }
        
    }
}
