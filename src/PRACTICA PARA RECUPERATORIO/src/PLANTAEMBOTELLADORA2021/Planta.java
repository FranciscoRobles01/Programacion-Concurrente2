/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PLANTAEMBOTELLADORA2021;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class Planta {

    private final int almacen;
    private int cantActual;
    private int cantVinos;
    private int cantAgua;
    private int vinoMaduro;
    private int vinoNoMaduro;
    private Semaphore madurar;
    private Semaphore mutex;
    private Semaphore mutex2;
    private Semaphore semVino;
    private Semaphore semAgua;
    private Semaphore cambiaCaja;
    private Semaphore mandarCamion;

    public Planta() {
        almacen = 5;
        cantVinos = 0;
        cantAgua = 0;
        cantActual = 0;
        vinoNoMaduro = 0;
        vinoMaduro = 0;
        madurar = new Semaphore(0);
        mutex = new Semaphore(1);
        mutex2 = new Semaphore(1);
        semVino = new Semaphore(1);
        semAgua = new Semaphore(1);
        cambiaCaja = new Semaphore(0);
        mandarCamion = new Semaphore(0);
    }

    public void ponerBotellaV(int num) {
        try {
            semVino.acquire();
            mutex.acquire();
            System.out.println("El embotellador de vino numero " + num + " ha ingresado una botella a la cajaV");
            cantVinos++;
            if (cantVinos == 5) {
                System.out.println("Se ha agregado la ultima botella a la caja, se solicita cambio de cajaV");
                mutex.release();
                cambiaCaja.release();
            } else {
                mutex.release();
                semVino.release();
            }

        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }

    public void ponerBotellaA(int num) {
        try {
            semAgua.acquire();
            mutex2.acquire();
            System.out.println("El embotellador de agua numero " + num + " ha ingresado una botella a la cajaA");
            cantAgua++;
            if (cantAgua == 5) {
                System.out.println("Se ha agregado la ultima botella a la caja, se solicita cambio de cajaA");
                mutex2.release();
                cambiaCaja.release();
            } else {
                mutex2.release();
                semAgua.release();
            }
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }

    public void cambiarCaja() {
        try {
            cambiaCaja.acquire();
            if (cantAgua == 5) {
                System.out.println("El empaquetador sella la caja de agua");
                cantAgua = 0;
                cantActual++;
                System.out.println("Se coloco una caja nueva de agua");
                semAgua.release();
            } else if (cantVinos == 5) {
                System.out.println("El empaquetador sella la caja de vino");
                cantVinos = 0;
                vinoNoMaduro++;
                System.out.println("se coloco una caja nueva de vino");
                semVino.release();
            }
            
            if(vinoMaduro >0){
                if(cantActual+vinoMaduro <= almacen){
                    System.out.println("Ingresa a almacen un vino maduro");
                    vinoMaduro--;
                    cantActual++;
                }
            }
            
            System.out.println("LA CANTIDAD ACTUAL DEL ALMACEN ES: "+cantActual);
            if (cantActual == almacen) {
                mandarCamion.release();
            }
    
            if(vinoNoMaduro > 0){
                madurar.release();
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        }
    }

    public void vaciarAlmacen() {
        try {
            mandarCamion.acquire();
            System.out.println("El camion se esta llevando las cajas de bebidas-------------------------------------");
            cantActual = 0;
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }

        public void madurarVino() {
        try {
            madurar.acquire();
            System.out.println("El vino esta madurando...");
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }

    public void vinoMadurado() {
        vinoMaduro++;
        vinoNoMaduro--;
        System.out.println("El vino ha madurado...");

    }
}
