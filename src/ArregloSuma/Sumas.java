/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ArregloSuma;

import java.util.Random;

/**
 *
 * @author roble
 */
public class Sumas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] arreglo = new int[10];
        int cantHilos = 3;
        int[] resultado = new int[cantHilos];
        Random rand = new Random();
        hiloSumador[] hilosSumadores = new hiloSumador[cantHilos];

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = rand.nextInt(10) + 1;
        }

        int segmento = arreglo.length / cantHilos;

        for (int i = 0; i < hilosSumadores.length; i++) {
            int inicio = segmento * i;
            int fin;
            
            if (i == hilosSumadores.length - 1) {
                fin = arreglo.length;
            } else {
                fin = segmento + inicio;
            }
            hilosSumadores[i] = new hiloSumador(arreglo, inicio, fin, resultado, i);
            hilosSumadores[i].start();
        }
        try {
            for (int i = 0; i < hilosSumadores.length; i++) {

                hilosSumadores[i].join();

            }
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error en el join");

        }
        int sumaTotal = 0;

        for (int i = 0; i < resultado.length; i++) {
            sumaTotal = sumaTotal + resultado[i];
        }
        System.out.println("La suma total es: " + sumaTotal);
    }
}
