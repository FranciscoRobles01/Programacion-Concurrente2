/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial2023;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class Planta {

    private int cajaA;
    private int cajaV;

    private int almacen;
    private Semaphore transportar;
    private Semaphore embotellaA;
    private Semaphore embotellaV;
    private Semaphore empaquetar;

    public Planta() {
        cajaA = 0;
        cajaV = 0;
        transportar = new Semaphore(0);
        embotellaA = new Semaphore(1);
        embotellaV = new Semaphore(1);
        empaquetar = new Semaphore(0);
    }

    public void embotellar(int id, char tipo) {
        try {
            if (tipo == 'A') {
                embotellaA.acquire();
                System.out.println("El embotellador se encuentra embotellando agua saborizada...");
                Thread.sleep(1000);
                cajaA++;
                if (cajaA == 5) {
                    System.out.println("La caja de agua saborizada esta llena, se le avisa a empaquetador...");
                    empaquetar.release();
                } else {
                    System.out.println("El embotellador termino de embotella el agua saborizada...");
                    embotellaA.release();
                }
            } else if (tipo == 'V') {
                embotellaV.acquire();
                System.out.println("El embotellador se encuentra embotellando vino");
                Thread.sleep(1000);
                cajaV++;
                if (cajaV == 5) {
                    System.out.println("La caja de vino esta llena, se le avisa al empaquetador...");
                    empaquetar.release();
                } else {
                    System.out.println("El embotellador termino de embotellar el vino");
                    embotellaV.release();
                }
            }

        } catch (InterruptedException e) {
            System.out.println("Ocurrio un error");
        }
    }

    public void empaquetar() {
        try {
            empaquetar.acquire();
            if(almacen == 3){
                System.out.println("El almacen se encuentra lleno, se solicita al transportador...");
                transportar.release();
            }
            if (cajaA == 5) {
                System.out.println("El empaquetador esta cerrando la caja de agua saborizada...");
                Thread.sleep(500);
                System.out.println("El empaquetador esta llevando la caja de agua saborizada al almacen...");
                Thread.sleep(1000);
                almacen++;
                System.out.println("El empaquetador le deja una caja nueva al embotellador de agua saborizada...");
                cajaA = 0;
                embotellaA.release();
            }

            if (cajaV == 5) {
                System.out.println("El empaquetador esta cerrando la caja de vino...");
                Thread.sleep(500);
                System.out.println("El empaquetador esta llevando la caja de vino al almacen...");
                Thread.sleep(1000);
                almacen++;
                System.out.println("El empaquetador le deja una caja nueva al embotellador de vino...");
                cajaV = 0;
                embotellaV.release();
            }
        } catch (InterruptedException e) {
            System.out.println("Error en el metodo empaquetar");

        }
    }
    
    public void transportar(){
        try{
            transportar.acquire();
            almacen=0;
            System.out.println("El camion se ha llevado todo el cargamento del almacen...");
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println("Ha ocurrido un error en transportar..");
        }
    }
}
