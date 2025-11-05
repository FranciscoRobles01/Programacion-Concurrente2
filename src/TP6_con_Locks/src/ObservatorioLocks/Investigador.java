/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObservatorioLocks;

/**
 *
 * @author roble
 */
public class Investigador extends Thread{
    
    private int num;
    private Observatorio observatorio;
    
    public Investigador(int num, Observatorio observatorio){
        this.num =num;
        this.observatorio = observatorio;
    }
    
    public void run(){
        try{    
        observatorio.pasaInvestigador(num);
        Thread.sleep(1500);
        observatorio.abandonaInvestigador(num);
        }catch(InterruptedException e){
            System.out.println("Error run investigador");
        }
    }
}
