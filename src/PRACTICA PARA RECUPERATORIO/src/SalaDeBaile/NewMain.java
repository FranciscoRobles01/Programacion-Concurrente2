/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SalaDeBaile;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SalaBaile sala = new SalaBaile();
        GestorBaile gestor = new GestorBaile(sala);
        
         PersonaSola d[] = new PersonaSola[4];
        PersonaSola z[] = new PersonaSola[4];
        
        for(int i=0; i < d.length;i++){
            d[i] = new PersonaSola((i+1),1,sala);
        }
        
        for(int i=0; i < z.length;i++){
            z[i] = new PersonaSola((i+1),0,sala);
        }
       
        gestor.start();
        
        for(int i=0; i < d.length;i++){
            d[i].start();
        }
        
        for(int i=0; i < z.length;i++){
            z[i].start();
        }
    }
    
}
