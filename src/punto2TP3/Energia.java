/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto2TP3;

/**
 *
 * @author roble
 */
public class Energia {
    private int vida;
    
    public Energia(){
        this.vida = 10;
    }
    
    public synchronized void drenaEnergia(int drena){
        this.vida = vida-drena;
        System.out.println("Se ha reducido la energia, energia actual: "+vida);
    }
    
    public synchronized void revitaliza(int revi){
        this.vida = vida+revi;
        System.out.println("Se ha aumentado la energia, energia actual: "+vida);
    }

    public synchronized int getVida(){
        return vida;
    }
    
}
