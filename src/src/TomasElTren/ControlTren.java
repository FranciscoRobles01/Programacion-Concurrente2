/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TomasElTren;

/**
 *
 * @author roble
 */
public class ControlTren extends Thread{
    
    private Tren tren;
    
    public ControlTren(Tren tren){
        this.tren = tren;
    }
    
    public void run(){
        try{
        while(true){
            tren.empiezaViaje();
            Thread.sleep(2000);
            tren.finalizarViaje();
        }
        }catch(InterruptedException e){
            System.out.println("Error en run");
        }
    }
}
