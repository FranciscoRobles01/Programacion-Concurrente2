/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiendaDeMascotas;

/**
 *
 * @author roble
 */
public class Jaula {
    
    public synchronized void plato(int i){
        System.out.println("El hamster "+i+" se encuentra comiendo...");
        try{
            Thread.sleep(1000);
            System.out.println("El hamster "+i+" ha terminado de comer...");
        }catch(InterruptedException error){
            System.out.println("Se ha interrumpido la alimentacion del hamster");
        }
    }
    
    public synchronized void rueda(int i){
        System.out.println("El hamster "+i+" se encuentra haciendo ejercicio en la rueda...");
        try{
            Thread.sleep(1000);
            System.out.println("El hamster "+i+" ha terminado de hacer ejercicio en la rueda...");
        }catch(InterruptedException error){
            System.out.println("Ha ocurrido una excepcion en la rueda");
        }
    }
    
    public synchronized void hamaca(int i){
        System.out.println("El hamster "+i+" se encuentra durmiendo en la hamaca...");
        try{
            Thread.sleep(2000);
            System.out.println("El hamster "+i+" se ha despertado de su siesta...");

        }catch(InterruptedException e){
            System.out.println("Ha ocurrido una excepcion en la hamaca");
        }
    
    }
}
