/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ParqueVecinal;

/**
 *
 * @author roble
 */
public class SimulaParque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parque parque = new Parque(6);
        Visitante visitantes[] = new Visitante[10];
        Residente residentes[] = new Residente[10];
        Escuela escuelas[] = new Escuela[2];
        
        for(int i =0; i < visitantes.length;i++){
            visitantes[i]= new Visitante((i+1),parque);
        }
        
        for(int i = 0; i < residentes.length;i++){
            residentes[i]= new Residente((i+1),parque);
        }
        
        for(int i =0; i < escuelas.length; i++){
            escuelas[i]= new Escuela((i+1),3,4, parque);
        }
        
         for(int i =0; i < visitantes.length;i++){
            visitantes[i].start();
        }
         
         for(int i = 0; i < residentes.length;i++){
            residentes[i].start();
        }
         
          for(int i =0; i < escuelas.length; i++){
            escuelas[i].start();
        }
    }
    
}
