/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EscritoresYLectores;

/**
 *
 * @author roble
 */
public class Escritor extends Thread {

    private int numEscritor;
    private Libro libro;

    public Escritor(int numEscritor, Libro libro) {
        this.numEscritor = numEscritor;
        this.libro = libro;
    }

    public void run() {

        boolean corte = true;
        while (corte) {
            try {
                if(!libro.libroFinalizado()){
                    libro.empezarAEscribir(numEscritor);             
                    libro.terminarEscribir(numEscritor);
                    Thread.sleep(500);
                }else{
                    corte = false;
                }
            } catch (InterruptedException e) {
                System.out.println("Ha ocurrido un error");

            }
        }
    }
}
