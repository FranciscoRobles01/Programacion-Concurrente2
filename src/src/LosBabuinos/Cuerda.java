/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LosBabuinos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class Cuerda {
    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore mutex2 = new Semaphore(1);
    private final Semaphore cuerda = new Semaphore(5);
    private final Semaphore ladoD = new Semaphore(1);
    private final Semaphore ladoI = new Semaphore(1);
    private int cantTotal;
    private int cantActual;
    
    public Cuerda(){    
        cantTotal = 0;
        cantActual =0;
    }
    
    public void avisarCruceDerechaIzquierda(){
    
        try{
            ladoD.acquire();
            mutex.acquire();
            cantActual++;
            
            if(cantActual ==1){
                ladoI.acquire();
            }
            cantTotal = cantActual +cantTotal;
            mutex.release();
            ladoD.release();
        
        }catch(InterruptedException e){
            System.out.println("ERROR EN DERECHA A IZQUIERDA");
        }   
    }
    
    public void tomarCuerda(int num, String dir){
        try{
            cuerda.acquire();
            System.out.println("El babuino "+num+" esta cruzando de " + dir);
        }catch(InterruptedException e){
            System.out.println("Error en tomar cuerda");
        }
    }
    
    public void bajarCuerdaDerecha(){
        try{
            ladoD.acquire();
            mutex.acquire();
            cantActual--;

            if(cantActual ==0){
                ladoI.release();
            }
            mutex.release();
            ladoD.release();
        }catch(InterruptedException e){
            System.out.println("Error en soltar Cuerda Derecha");
        }
    }
    
        public void avisarCruceIzquierdaDerecha(){
    
        try{
            ladoI.acquire();
            mutex2.acquire();
            cantActual++;
            
            if(cantActual ==1){
                ladoD.acquire();
            }
            cantTotal = cantActual +cantTotal;
            mutex2.release();
            ladoI.release();
        
        }catch(InterruptedException e){
            System.out.println("ERROR EN DERECHA A IZQUIERDA");
        }   
    }
    
    public void bajarCuerdaIzquierda(){
        try{
            ladoI.acquire();
            mutex2.acquire();
            cantActual--;
            
            if(cantActual ==0){
                ladoD.release();
            }
            
            mutex2.release();
            ladoI.release();
        }catch(InterruptedException e){
            System.out.println("Error en soltar Cuerda Derecha");
        }
    }
    public void soltarCuerda(int num, String dir){
        System.out.println("El babuino "+num+" esta dejando la cuerda ya cruzo de "+dir);
        cuerda.release();
    }
    
}
