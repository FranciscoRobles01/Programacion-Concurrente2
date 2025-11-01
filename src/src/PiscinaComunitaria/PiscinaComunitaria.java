/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PiscinaComunitaria;

/**
 *
 * @author roble
 */
public class PiscinaComunitaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona []personas = new Persona[10];
        Piscina piscina = new Piscina(3);
        
        for(int i =0; i < personas.length; i++){
            personas[i] = new Persona((i+1),piscina);
        }
        
        for(int i=0; i < personas.length;i++){
            personas[i].start();
        }
    }
    
}
