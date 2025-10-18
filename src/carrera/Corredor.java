/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrera;
import java.util.Random;
/**
 *
 * @author roble
 */
public class Corredor implements Runnable{
    
    private int nombre;
    private int distancia;
    private int pasosTotales = 100;
    private Random aleatorio = new Random();
    
    public Corredor(int nombre){
        this.nombre = nombre;
        this.distancia = 0;
}
    public int getPasos(){
        return distancia;
    }
    
    public int getNombre(){
        return nombre;
    }
    
    public void run(){
        for(int i =1; i <= pasosTotales;i++){
            try{
                int avance = aleatorio.nextInt(10)+1;
                distancia = distancia+avance;
                System.out.println("El corredor:"+nombre+" en el paso:"+i+" avanzo:"+avance);               
                Thread.sleep(200);
                
            }catch(Exception e){
                System.out.println("Ocurrio un error con el hilo del corredor "+i);
            }
        }
    }
}
