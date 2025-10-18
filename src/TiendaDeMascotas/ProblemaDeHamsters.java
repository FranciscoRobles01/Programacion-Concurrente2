/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TiendaDeMascotas;

/**
 *
 * @author roble
 */
public class ProblemaDeHamsters {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;
        Jaula jaula = new Jaula();
        Hamster []hamsters = new Hamster[6];
        
        for(i = 0; i < hamsters.length;i++){
            hamsters[i] = new Hamster(i,jaula);
        }
        
        try{
            for(i =0; i < hamsters.length; i++){
   
                hamsters[i].start();
            }
    }catch(Exception error){
            System.out.println("Ha ocurrido un error en el main");
    }
      
    }
}
