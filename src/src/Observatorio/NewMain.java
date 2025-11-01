/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Observatorio;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sala sala = new Sala();

        Visitante visitantesA[] = new Visitante[8];
        Visitante visitantesB[] = new Visitante[3];
        Investigador investigadores[] = new Investigador[8];
        Mantenimiento empleados[] = new Mantenimiento[6];

        for (int i = 0; i < investigadores.length; i++) {
            investigadores[i] = new Investigador((i + 1), sala);
        }

        for (int i = 0; i < empleados.length; i++) {
            empleados[i] = new Mantenimiento((i + 1), sala);
        }

        for (int i = 0; i < visitantesA.length; i++) {
            visitantesA[i] = new Visitante((i + 1), 'A', sala);
        }

        for (int i = 0; i < visitantesB.length; i++) {
            visitantesB[i] = new Visitante((i + 1), 'B', sala);
        }

        for (int i = 0; i < visitantesA.length; i++) {
            visitantesA[i].start();
        }

        for (int i = 0; i < visitantesB.length; i++) {
            visitantesB[i].start();
        }

        for (int i = 0; i < investigadores.length; i++) {
            investigadores[i].start();
        }

        for (int i = 0; i < empleados.length; i++) {
            empleados[i].start();
        }
    }

}
