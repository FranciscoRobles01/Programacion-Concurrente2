/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2025;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.Random;

public class Mesa {

    private int[] duraciones = new int[4];
    private int[] cantCancionesTipo = new int[4];
    private Lock lock;
    private Condition espera;

    public Mesa(int duracionR, int duracionF, int duracionC, int duracionB) {
        lock = new ReentrantLock();
        espera = lock.newCondition();
        duraciones[2] = duracionR;
        duraciones[1] = duracionF;
        duraciones[3] = duracionC;
        duraciones[0] = duracionB;

        cantCancionesTipo[0] = 0;
        cantCancionesTipo[1] = 0;
        cantCancionesTipo[2] = 0;
        cantCancionesTipo[3] = 0;
    }

    public void colocarCanciones(String tipo) {
        try {
            lock.lock();
            switch (tipo) {
                case "Blues":
                    cantCancionesTipo[0]++;
                    break;
                case "Flok":
                    cantCancionesTipo[1]++;
                    break;
                case "Rock":
                    cantCancionesTipo[2]++;
                    break;
                case "Country":
                    cantCancionesTipo[3]++;
                    break;
                default:
                    System.out.println("Error tipo");
                    break;
            }
            espera.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int agarrarCancion(int num, String tipo) {
        int r = 0;
        try {
            lock.lock();
            while ((tipo.equals("Blues") && cantCancionesTipo[0] == 0)
                    || (tipo.equals("Rock") && cantCancionesTipo[2] == 0) || (tipo.equals("Folk") && cantCancionesTipo[1] == 0) || (tipo.equals("Country") && cantCancionesTipo[3] == 0)) {
                espera.await();

            }
            System.out.println("El productor numero " + num + " de tipo " + tipo + " ha agarrado una cancion");

            switch (tipo) {
                case "Rock":
                    cantCancionesTipo[2]--;
                    r = duraciones[2];
                    break;
                case "Folk":
                    cantCancionesTipo[1]--;
                    r = duraciones[1];
                    break;
                case "Country":
                    cantCancionesTipo[3]--;
                    r = duraciones[3];
                    break;
                case "Blues":
                    cantCancionesTipo[0]--;
                    r = duraciones[0];
                    break;
            }
        } catch (InterruptedException e) {
            System.out.println("Error1");
        } finally {
            lock.unlock();
        }
        return r;
    }

    public void llevarCancion(int num, String tipo) {
        try {
            lock.lock();
            System.out.println("El productor numero " + num + " de tipo " + tipo + " abandona la mesa");
            espera.signalAll();
        } finally {
            lock.unlock();
        }
    }

}
