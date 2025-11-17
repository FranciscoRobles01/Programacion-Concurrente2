/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PizzasADomicilio;

/**
 *
 * @author roble
 */
public class GeneradorPedido extends Thread{
    private String nom;
    private String tipo;
    private Mostrador mostrador;
    
    public GeneradorPedido(String nom, String tipo, Mostrador mostrador){
        this.nom = nom;
        this.tipo = tipo;
        this.mostrador=mostrador;
    }
    
    public void run(){
        try{
            while(true){
                mostrador.generarPedido(tipo, nom);
                Thread.sleep(2000);
            }
        }catch(InterruptedException e){
            System.out.println("Error");
        }
    }
}
