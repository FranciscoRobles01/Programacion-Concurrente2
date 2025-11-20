/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CentroHemoterapia;

/**
 *
 * @author roble
 */
public class Clinico extends Thread{
    
    
    private Centro centro;
    
    public Clinico(Centro centro){
        this.centro = centro;
    }

    
    public void run(){
        try{
        while(true){
            
            centro.hacerEntrevista();
            Thread.sleep(1000);
            centro.terminarEntrevista();
        }
        }catch(Exception e){
            System.out.println("ERROr");
        }
    }
}
