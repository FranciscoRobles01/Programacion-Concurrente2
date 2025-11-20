/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParqueVecinal;

/**
 *
 * @author roble
 */
public class Escuela  extends Thread{
 
    private int num;
    private int capacidad;
    private Parque parque;
    
    public Escuela(int num, int capacidad, Parque parque){
        this.num = num;
        this.capacidad=capacidad;
        this.parque = parque;
    }
    
    public void run(){
    
        try{
            parque.haceFilaEscuela(num);
            parque.entraEscuela(num, num);
            Thread.sleep(1000);
            parque.saleEscuela(num, num);
        }catch(Exception e){
            System.out.println("Error 7 nose");
        }
    }
}
