/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EscritoresYLectores;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class Libro {

    private int cantPaginas;
    private int cantPaginasTotal;
    private int cantLectores;
    private Semaphore lector;
    private Semaphore libro;

    public Libro(int cantPaginasTotal) {
        this.cantPaginas =0;
        this.cantLectores = 0;
        this.lector = new Semaphore(1);
        this.libro = new Semaphore(1);
        this.cantPaginasTotal = cantPaginasTotal;
    }

    public void empezarAEscribir(int numEscritor) {
        try {
            libro.acquire();
            if(cantPaginas <= cantPaginasTotal){
                System.out.println("El escritor " + numEscritor + " se encuentra escribiendo...");
                Thread.sleep(500);
            }else{
                libro.release();
            }
        } catch (InterruptedException e) {
            System.out.println("Ocurrio un error");
        }
    }

    public void empezarALeer(int numLector) {
        try {
            lector.acquire();
            cantLectores++;

            if (cantLectores == 1) {
                libro.acquire();
            }

            

            System.out.println("El lector " + numLector + " ha empezado a leer el libro...");
            Thread.sleep(1000);
            lector.release();
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error en empezar a leer");
        }
    }

    public void terminarEscribir(int numEscritor) {

        synchronized(this){
            cantPaginas++;
            System.out.println("El escritor " + numEscritor + " ha terminado de escribir...(cantPaginas"+cantPaginas+")");       
        }
        libro.release();

    }

    public void terminarLeer(int numLector) {
        try {
            lector.acquire();
            System.out.println("El lector " + numLector + " ha terminado de leer...");
            cantLectores--;
            if (cantLectores == 0) {
                libro.release();
            }
            lector.release();
        } catch (InterruptedException e) {
            System.out.println("Error en terminar de leer...");
        }
    }

    public int getCantidadTotal() {
        return cantPaginasTotal;
    }
    
    public synchronized boolean libroFinalizado(){
        return cantPaginas == cantPaginasTotal;
    } 
}
