/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PollosHermanos;

/**
 *
 * @author roble
 */
public class Empleado extends Thread{
    
    private int id;
    private Confiteria confiteria;
    
    public Empleado(int id, Confiteria confiteria){
        this.id = id;
        this.confiteria=confiteria;
    }
    
    public void run(){
        try{
            confiteria.sentarse(id);
            confiteria.comer();
            confiteria.terminarDeComer();
            Thread.sleep(10000);
        }catch(InterruptedException e){
            System.out.println("Ha ocurrido un error");
        }
    
    }
    
}
