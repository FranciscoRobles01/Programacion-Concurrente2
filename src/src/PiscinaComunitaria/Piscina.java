/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PiscinaComunitaria;
import java.util.concurrent.Semaphore;
/**
 *
 * @author roble
 */
public class Piscina {
    
    private final Semaphore entrada;

    
    public Piscina(int capacidad){
        entrada = new Semaphore(capacidad);

    }
    
    public void entrar(){
        try{
            entrada.acquire();
        }catch(InterruptedException e){
            System.out.println("ERROR en entrar");
        }
    }
    
    public void salir(){
            entrada.release();
    }
}
