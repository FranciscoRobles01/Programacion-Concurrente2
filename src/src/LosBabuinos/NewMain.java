/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package LosBabuinos;

/**
 *
 * @author robles
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Babuinos babuinos[] = new Babuinos[10];
        BabuinosIzq babuinosIzq[] = new BabuinosIzq[5];
        Cuerda cuerda = new Cuerda();
        
        for(int i=0; i < babuinos.length; i++){
            babuinos[i] = new Babuinos((i+1),cuerda);
        }
        
        for(int i=0; i < babuinosIzq.length; i++){
            babuinosIzq[i] = new BabuinosIzq((i+1),cuerda);
        }
        
        for(int i=0; i < babuinos.length; i++){
            babuinos[i].start();
            
        }
        for(int i=0; i < babuinosIzq.length; i++){
            babuinosIzq[i].start();
        }
    }
    
}
