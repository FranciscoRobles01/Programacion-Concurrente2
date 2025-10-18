/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiendaDeMascotas;

/**
 *
 * @author roble
 */
public class Hamster extends Thread{
    private int i;
    private Jaula jaula;
    
    public Hamster(int i, Jaula jaula){
        this.i = i;
        this.jaula = jaula;
    }
    
    public void run(){
    
        jaula.plato(i);
        jaula.rueda(i);
        jaula.hamaca(i);
    }
}
