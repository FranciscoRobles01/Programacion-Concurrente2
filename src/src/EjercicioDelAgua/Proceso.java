/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioDelAgua;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class Proceso {

    private int recipiente;
    private Semaphore aguaLista;
    private Semaphore hidrogenoListo;
    private Semaphore semAgua;
    private Semaphore semHidrogeno;
    private Semaphore mutex;
    private Semaphore mutex2;
    private int cantHidrogeno;
    private int cantAgua;
    private int cantActual;

    public Proceso(int cant) {
        this.recipiente = cant;
        aguaLista = new Semaphore(0);
        hidrogenoListo = new Semaphore(0);
        semAgua = new Semaphore(1);
        semHidrogeno = new Semaphore(2);
        mutex = new Semaphore(1);
        cantHidrogeno = 0;
        cantAgua = 0;
        cantActual = 0;
    }

    public void Olisto(int numAgua) {
        try {
            semAgua.acquire();
            mutex.acquire();
            System.out.println("La molecula de agua numero " + numAgua + " se encuentra en el proceso Olisto");
            cantAgua++;
            if (cantAgua == 1) {
                cantAgua = 0;
                aguaLista.release();
            }
            mutex.release();
            semAgua.release();
        } catch (InterruptedException e) {
            System.out.println("Ocurrio un error en Olisto");
        }
    }

    public void Hlisto(int numHidrogeno) {
        try {
            semHidrogeno.acquire();
            mutex.acquire();
            System.out.println("La molecula de hidrogeno numero " + numHidrogeno + " se encuentra en el proceso Hlisto");
            cantHidrogeno++;
            if (cantHidrogeno == 2) {
                cantHidrogeno = 0;
                hidrogenoListo.release();
            }
            mutex.release();
            semHidrogeno.release();
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error en Hlisto");
        }
    }

    public void hacerAgua() {
        try {
            if (cantActual == recipiente) {
                System.out.println("El recipiente se encuentra lleno, se procede a poner uno nuevo");
                cantActual = 0;
                Thread.sleep(1000);
                System.out.println("Recipiente Nuevo, ahora se sigue con el proceso de agua");
            }
            aguaLista.acquire(1);
            hidrogenoListo.acquire(1);
            System.out.println("Hay uno de agua y dos de hidrogeno, se procede hacer el proceso de agua");
            Thread.sleep(2000);
            cantActual++;
            System.out.println("Ha finalizado el proceso de agua se aumenta la cantidad en el recipiente...");

        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error");
        }
    }
}
