/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SalaEstudioLocks;

/**
 *
 * @author roble
 */
public class SalaEstudianteLock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Sala sala = new Sala(4);
       
       Estudiante estudiantes[] = new Estudiante[10];
       
       for(int i=0; i < estudiantes.length;i++){
           estudiantes[i] = new Estudiante((i+1),sala);
       }
       
       for(int i=0; i < estudiantes.length;i++){
           estudiantes[i].start();
       }
    }
    
}
