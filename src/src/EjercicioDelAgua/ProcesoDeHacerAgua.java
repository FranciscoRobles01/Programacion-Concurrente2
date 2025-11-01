/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EjercicioDelAgua;

/**
 *
 * @author roble
 */
public class ProcesoDeHacerAgua {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Proceso proceso = new Proceso(10);
        
        Hidrogeno hidrogenos[] = new Hidrogeno[6];
        Oxigeno oxigenos[] = new Oxigeno[3];
        
        for(int i=0; i< hidrogenos.length;i++){
            hidrogenos[i] = new Hidrogeno((i+1),proceso);
        }
        
        for(int i=0; i < oxigenos.length;i++){
            oxigenos[i] = new Oxigeno((i+1),proceso);
        }
     
        for(int i=0; i < oxigenos.length;i++){
            oxigenos[i].start();
        }
        for(int i=0; i < hidrogenos.length;i++){
            hidrogenos[i].start();
        }
    }
    
}
