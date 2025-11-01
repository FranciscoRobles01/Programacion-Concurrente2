/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TomasElTren;

/**
 *
 * @author roble
 */
public class Vendedor extends Thread{
    
    private Tren tren;
    private String nombre;
    
    
    public Vendedor(String nombre, Tren tren){
        this.tren = tren;
        this.nombre = nombre;
    }
    
    public void run(){
       while(true){
           tren.venderTicket();
       }
       
    }
}
