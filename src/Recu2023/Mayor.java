/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recu2023;

/**
 *
 * @author roble
 */
public class Mayor extends Thread{
    
    private String nombre;
    private Mesa mesa;
    
    public Mayor(String nombre, Mesa mesa){
        this.nombre = nombre;
        this.mesa = mesa;
    }

    
    public void run(){
        boolean puedeServir;
        while(true){       
            puedeServir=mesa.cocinar();
            if(puedeServir){mesa.servir();};
        }
        
    }
}
