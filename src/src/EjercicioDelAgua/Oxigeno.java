/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioDelAgua;

/**
 *
 * @author roble
 */
public class Oxigeno extends Thread {

    private int numOxigeno;
    private Proceso proceso;

    public Oxigeno(int numOxigeno, Proceso proceso) {
        this.numOxigeno = numOxigeno;
        this.proceso = proceso;
    }

    public void run() {
            try {
                proceso.Olisto(numOxigeno);
                proceso.hacerAgua();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error en run de oxigeno");
            }
        }
    }


