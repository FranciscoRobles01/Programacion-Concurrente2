/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author roble
 */
public class BrazoMecanico extends Thread{
    private Cinta cinta;
    private int num;
    public BrazoMecanico(int num,Cinta cinta){
        this.cinta = cinta;
        this.num = num;
    }

    
    
    public void run(){
        try{
        while(true){
            cinta.retirarCaja(num);
            Thread.sleep(1000);
            cinta.poneCaja(num);
        }
        }catch(InterruptedException e){
            System.out.println("Error en run brazo mecanico");
        }
    }
}
