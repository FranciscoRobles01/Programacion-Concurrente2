/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EscritoresYLectores;

/**
 *
 * @author roble
 */
public class Lector extends Thread {

    private int numLector;
    private Libro libro;

    public Lector(int numLector, Libro libro) {
        this.numLector = numLector;
        this.libro = libro;
    }

    public void run() {
        int i = 0;
        while (!libro.libroFinalizado()) {
            try{
            libro.empezarALeer(numLector);
            libro.terminarLeer(numLector);
            Thread.sleep(500);
            
            }catch(InterruptedException e){
                System.out.println("Ha ocurrido un error");
        }
        }
    }
}
