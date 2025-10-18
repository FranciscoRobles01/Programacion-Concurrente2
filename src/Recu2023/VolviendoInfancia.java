/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Recu2023;

/**
 *
 * @author roble
 */
public class VolviendoInfancia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        Mayor mayor = new Mayor("Ross", mesa);
        mayor.start();
        Pequenio pequenios[] = new Pequenio[8];
        
        for(int i=0; i < pequenios.length;i++){
            pequenios[i]= new Pequenio((i+1),mesa);
        }
          
        for(int i=0; i < pequenios.length;i++){
            pequenios[i].start();
        }
       
    }
    
}
