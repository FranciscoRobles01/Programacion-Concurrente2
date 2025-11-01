/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TomasElTren;

/**
 *
 * @author roble
 */
public class Tomas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Tren tren = new Tren(5);
       Vendedor vendedor = new Vendedor("Tomas",tren);
       ControlTren control = new ControlTren(tren);
       vendedor.start();
       control.start();
       Pasajero pasajeros[] = new Pasajero[10];
       
       for(int i=0; i < pasajeros.length;i++){
          pasajeros[i] = new Pasajero((i+1), tren);
       }
       
       for(int i=0; i < pasajeros.length;i++){
           pasajeros[i].start();
       }
    }
    
}
