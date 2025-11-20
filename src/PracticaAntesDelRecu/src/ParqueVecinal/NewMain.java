/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ParqueVecinal;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parque parque = new Parque(5);
        
        Visitante visitantes[] = new Visitante[5];
        Residente residentes[] = new Residente[5];
        Escuela escuela1 = new Escuela(1,5,parque);
        Escuela escuela2 = new Escuela(2,7,parque);
        Escuela escuela3 = new Escuela(3,8,parque);
        
        for(int i =0; i < residentes.length;i++){
            residentes[i]= new Residente((i+1),parque);
        }
        
        for(int i =0; i < visitantes.length;i++){
            visitantes[i]= new Visitante((i+1),parque);
        }
        
        
        for(int i =0; i < residentes.length;i++){
            residentes[i].start();
        }
        
        for(int i =0; i < visitantes.length;i++){
            visitantes[i].start();
        }
        
        escuela1.start();
        escuela2.start();
        escuela3.start();
    }
    
}
