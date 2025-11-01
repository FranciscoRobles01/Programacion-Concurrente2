/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoSalaEstudio;

/**
 *
 * @author roble
 */
public class Estudiante extends Thread{
    
    private int num;
    private Sala sala;
    
    public Estudiante(int num, Sala sala){
        this.num = num;
        this.sala = sala;
    }
    
    public void run(){
        try{
        sala.ocuparMesa(num);
        Thread.sleep(1000);
        sala.dejarMesa(num);
    }catch(InterruptedException e){
            System.out.println("Error en run");
    }
    }
}
