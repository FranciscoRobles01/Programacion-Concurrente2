/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EscritoresYLectores;

/**
 *
 * @author roble
 */
public class EjecucionLectorEscritor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i,j;
        Escritor []escritores = new Escritor[3];
        Lector []lectores = new Lector[3];
        Libro libro = new Libro(10);
        
        for(i=0; i < 3;i++){
            escritores[i] = new Escritor(i+1,libro);
        }
        
        for(j=0; j < 3;j++){
            lectores[j] = new Lector(j+1,libro);
        }
    
        for(i=0; i < 3;i++){            
            escritores[i].start();
            lectores[i].start();       
        }
    
    
    }   
}
