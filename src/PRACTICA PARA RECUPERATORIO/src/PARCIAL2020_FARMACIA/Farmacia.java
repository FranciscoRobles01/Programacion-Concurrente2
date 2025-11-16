/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2020_FARMACIA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
/**
 *
 * @author roble
 */
public class Farmacia {

    private Queue <Ficha>fichaGeneral;
    private List <Ficha>lista;
    private Queue <Ficha>fichaContable;
    private Queue <Ficha>fichaEncargado;
    private Queue <Ficha>recetas;
    private int pizarra;
    private int sumaTotal;

    public Farmacia() {
        fichaGeneral = new LinkedList();
        fichaContable = new LinkedList();
        fichaEncargado = new LinkedList();
        recetas = new LinkedList();
        pizarra = 0;
        sumaTotal = 0;
    }

    public synchronized void dejarReceta(int num,int importe) {
        System.out.println("Un cliente ha dejado una receta");
        Ficha ficha = new Ficha(num,importe);
        recetas.add(ficha);
        notifyAll();
    }
    
    public synchronized void depositarReceta(int num){
        try{
            while(recetas.isEmpty()){
                System.out.println("El auxiliar "+num+" de farmacia esta haciendo cosas de auxiliar de farmacia");
                this.wait();
            }
            System.out.println("El auxiliar numero "+num+" ha dejado una receta en el canasto general");
            fichaGeneral.add(recetas.peek());
            recetas.poll();
            System.out.println("Las recetas en canasto son "+fichaGeneral.toString());
            notifyAll();
        }catch(InterruptedException e){
            System.out.println("Error");
        }  
    }
    
    public synchronized void tomarReceta(int num){
        try{
            while(fichaGeneral.isEmpty() && fichaContable.isEmpty()){
                this.wait();
            }
            
            if(!fichaGeneral.isEmpty()){
                System.out.println("El auxiliarContable numero "+num+" anota en la pizarra el importe nuevo para el medico numero");
                if(lista.isEmpty()){
                    lista.add(fichaGeneral.peek());
                }else{
                    int indice = lista -1){.indexOf(fichaGeneral.peek().getNum());
                    if(indice ==
                        lista.add(fichaGeneral.peek());
                    }else{
                        Ficha ficha = lista.get(indice);
                        ficha.setImporte(fichaGeneral.peek().getImporte());
                        lista.set(indice, ficha);
                    }
                }
            }
        }catch(InterruptedException e){
            System.out.println("Error");
        }
    }
    
    }
}
