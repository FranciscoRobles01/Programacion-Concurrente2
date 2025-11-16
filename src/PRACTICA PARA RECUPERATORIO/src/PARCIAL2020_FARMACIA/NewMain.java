/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PARCIAL2020_FARMACIA;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Farmacia farmacia = new Farmacia();
        HiloAuxiliar aux = new HiloAuxiliar(farmacia);
        Auxiliar auxiliares[] = new Auxiliar[4];
        
        for(int i=0; i < auxiliares.length; i++){
            auxiliares[i] = new Auxiliar((i+1),farmacia);
        }
        
        aux.start();
        for(int i=0; i < auxiliares.length; i++){
            auxiliares[i].start();
        }
        
        
    }
    
}
