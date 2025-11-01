/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PollosHermanosII;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class Confiteria {

    private final Semaphore silla;
    private final Semaphore bebidaLista;
    private final Semaphore comidaLista;
    private final Semaphore servir;
    private final Semaphore cocinar;

    public Confiteria() {

        silla = new Semaphore(2);
        bebidaLista = new Semaphore(0);
        cocinar = new Semaphore(0);
        servir = new Semaphore(0);
        comidaLista = new Semaphore(0);
    }

    public void tomarAsiento(String nombre) {
        try {
            silla.acquire();
            System.out.println("El empleado " + nombre + " se encuentra sentado y listo para ordenar..");

        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error en tomar asiento");
        }
    }

    public void ordenar(String nombre, char opcion) {

        switch (opcion) {

            case 'c':
                System.out.println("El empleado " + nombre + " avisa al cocinero que quiere comer...");
                cocinar.release();
                break;

            case 't':
                System.out.println("El empleado " + nombre + " avisa al mozo que quiere tomar algo...");
                servir.release();
                break;
        }
    }

    public void comer(String nombre) {
        try {
            comidaLista.acquire();
            System.out.println("La comida del empleado " + nombre + " ya esta lista...");
            System.out.println("El empleado " + nombre + " se encuentra comiendo...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error en esperaComer");
        }
    }

    public void tomarBebida(String nombre) {
        try {
            bebidaLista.acquire();
            System.out.println("La bebida del empleado " + nombre + " se encuentra lista...");
            System.out.println("El empleado " + nombre + " se encuentra tomando su bebida...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error en esperaBebida");
        }
    }

    public void dejarSilla(String nombre) {
        System.out.println("El empleado "+nombre+" a terminado de comer su comida o termino de tomar su bebida, agradece el servicio y libera la silla");
        silla.release();
    }

    public void prepararComida() {
        try {
            cocinar.acquire();
            System.out.println("El cocinero se encuentra preparando la comida...");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            System.out.println("Error en prepararComida");

        }
    }

    public void terminarComida() {
        System.out.println("El cocinero ha terminado de cocinar la comida...");
        comidaLista.release();
    }
    
    public void prepararBebida(){
        try{
            servir.acquire();
            System.out.println("El mozo se encuentra preparando una bebida...");
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println("Error en prepararBebida");
        }
    }
    
    public void terminarBebida(){
        System.out.println("El mozo ha terminado la bebida...");
        bebidaLista.release();
    }
}
