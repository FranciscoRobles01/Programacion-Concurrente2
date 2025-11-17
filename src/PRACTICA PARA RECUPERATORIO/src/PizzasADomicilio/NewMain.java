/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PizzasADomicilio;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mostrador mostrador = new Mostrador();
        GeneradorPedido generador = new GeneradorPedido("Juan","Napolitana", mostrador);
        GeneradorPedido generador2 = new GeneradorPedido("Mario","Vegana", mostrador);
        
        MaestroPizzeroN maestro1[] = new MaestroPizzeroN[1];
        MaestroPizzeroV maestro2[] = new MaestroPizzeroV[1];
        
        Repartidor repartidor[] = new Repartidor[1];
    
        for(int i=0; i < maestro1.length;i++){
            maestro1[i]= new MaestroPizzeroN((i+1),mostrador);
        }
        
        for(int i=0; i < maestro2.length;i++){
            maestro2[i]= new MaestroPizzeroV((i+1),mostrador);
        }
        
        for(int i=0; i < repartidor.length;i++){
            repartidor[i]= new Repartidor((i+1),mostrador);
        }
        
        generador.start();
        generador2.start();
        for(int i=0; i < maestro1.length;i++){
            maestro1[i].start();
        }
        
        for(int i=0; i < maestro2.length;i++){
            maestro2[i].start();
        }
        
        for(int i=0; i < repartidor.length;i++){
            repartidor[i].start();
        }
    }
    
}
