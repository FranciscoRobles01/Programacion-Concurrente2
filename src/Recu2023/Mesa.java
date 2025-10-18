/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recu2023;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class Mesa {

    private Semaphore[] banquito = new Semaphore[4];
    private Semaphore prepararComida;
    private Semaphore comidaLista;
    private Semaphore finComida;

    public Mesa() {

        for (int i = 0; i < banquito.length; i++) {
            banquito[i] = new Semaphore(1);
        }
        prepararComida = new Semaphore(0);
        comidaLista = new Semaphore(0);
        finComida = new Semaphore(0);
    }

    public int intentarSentarse(int numAnimalito) {
        int i = 0;
        boolean sentado = false;
        while (!sentado) {

            if (banquito[i].tryAcquire()) {
                sentado = true;
                System.out.println("El animalito numero "+numAnimalito+ " se encuentra sentado...");
            } else if (i == banquito.length - 1) {
                i = 0;
            } else {
                i++;
            }
        }
        return i;
    }

    public void avisarAMayor(int numAnimalito) {
        System.out.println("El animalito "+numAnimalito+" le avisa al animalito mayor que quiere comer...");
        prepararComida.release();
    }

    public boolean  cocinar() {
        boolean prepara= prepararComida.tryAcquire();
        try {
            
            if(!prepara){
                System.out.println("El animalito mayor se encuentra dibujando....");
                Thread.sleep(1000);
            }else{
                System.out.println("El animalito mayor se encuentra cocinando...");
                Thread.sleep(500);
            }
            
        } catch (Exception e) {
            System.out.println("Error");
        }
        return prepara;
    }
    
    public void servir(){
        try{
            System.out.println("El animalito mayor esta sirviendo la comida...");
            Thread.sleep(800);
            comidaLista.release();
        }catch(InterruptedException e){
            System.out.println("Error servir");
        }
    }

    public void comer(int nombre) {
        try {
            comidaLista.acquire();
            System.out.println("El pequenio " + nombre + " se encuentra comiendo...");
            Thread.sleep(1000);
            
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error en comer");
        }
    }

    public void terminarDeComer(int nombre, int i) {
        System.out.println("El pequenio " + nombre + " ha terminado de comer, despeja el banquito " + (i + 1) + " y se va a jugar...");
        banquito[i].release();
    }
}
