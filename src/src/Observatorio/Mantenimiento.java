/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observatorio;

/**
 *
 * @author roble
 */
public class Mantenimiento extends Thread{
    private int num;
    private Sala sala;
    
    public Mantenimiento(int num, Sala sala){
        this.num = num;
        this.sala = sala;
    }
    
    public void run(){
        try{
        sala.entraMantenimiento(num);
        Thread.sleep(2000);
        sala.saleMantenimiento(num);
        Thread.sleep(800);
        }catch(InterruptedException e){
            System.out.println("Error en run mantenimiento");
        }
    }
}
