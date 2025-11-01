/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observatorio;

/**
 *
 * @author roble
 */
public class Investigador extends Thread{
    private int num;
    private Sala sala;
    
    public Investigador(int num, Sala sala){
        this.num = num;
        this.sala =sala;    
    }
    
    public void run(){
        try{
        sala.entraInvestigador(num);
        Thread.sleep(1000);
        sala.saleInvestigador(num);
        Thread.sleep(800);
        }catch(InterruptedException e){
            System.out.println("Error en run investigador");
        }
    }
}
