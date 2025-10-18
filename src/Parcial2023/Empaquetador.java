/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial2023;

/**
 *
 * @author roble
 */
public class Empaquetador extends Thread{
    
    private int id;
    private Planta planta;
    
    public Empaquetador(int id, Planta planta){
        this.id = id;
        this.planta = planta;
    }
    
    public void run(){
        try{
            while(true){
                planta.empaquetar();
                Thread.sleep(1000);
            }
               }catch(InterruptedException e){
            System.out.println("Ha ocurrido un error en el hilo empaquetador...");
        }
    }
    
}
