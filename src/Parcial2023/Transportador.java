/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial2023;

/**
 *
 * @author roble
 */
public class Transportador extends Thread{
    
    private Planta planta;
    private int patente;
    
    public Transportador(int patente, Planta planta){
        this.planta = planta;
        this.patente = patente;
    }


    
    public void run(){
        try{
            while(true){
                planta.transportar();
                Thread.sleep(1000);
            
            }
        }catch(InterruptedException e){
            System.out.println("Ha ocurrido un error en el hilo transportador..");
        }
    }
}
