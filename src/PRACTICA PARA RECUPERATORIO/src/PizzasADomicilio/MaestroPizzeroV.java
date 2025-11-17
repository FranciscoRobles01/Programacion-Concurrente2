/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PizzasADomicilio;

/**
 *
 * @author roble
 */
public class MaestroPizzeroV extends Thread{
    
    private int num;
    private Mostrador mostrador;
    
    public MaestroPizzeroV(int num, Mostrador mostrador){
        this.num = num;
        this.mostrador = mostrador;
    }
    
    public void run(){
        try{
        while(true){
            mostrador.prepararPizzaV(num);
            Thread.sleep(1500);
            mostrador.pizzaVTerminada(num);
        }
        }catch(InterruptedException e){
            System.out.println("Error");
        }
    }
}
