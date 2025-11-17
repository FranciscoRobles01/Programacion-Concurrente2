/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalaDeBaile;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class SalaBaile {

    private Queue fila1;
    private Queue fila2;
    private Semaphore pasa;
    private Semaphore sale;
    private Semaphore mutex;
    private Semaphore ingresaFila1;
    private Semaphore ingresaFila2;
    
    public SalaBaile() {
        
        fila1 = new LinkedList();
        fila2 = new LinkedList();
        pasa = new Semaphore(1);
        sale = new Semaphore(1);
        mutex = new Semaphore(1);
        ingresaFila1 = new Semaphore(0);
        ingresaFila2 = new Semaphore(0);
    }

    public void hacerFilaSolo(int num, int fila) {

        try {
            pasa.acquire();
            mutex.acquire();
            System.out.println("La persona numero " + num + " vino sola a bailar, se encuentra haciendo fila");
            if (fila == 1) {
                System.out.println("La persona " + num + " se encuentra en la fila" + fila);
                fila1.add(num);
                ingresaFila1.release();
            } else {
                System.out.println("La persona " + num + " se encuentra en la fila" + fila);
                fila2.add(num);
                ingresaFila2.release();
            }
            mutex.acquire();
            pasa.release();
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        }
    }

    public void hacerFilaPareja(int num, int num2) {
        try {
            pasa.acquire();
            mutex.acquire();
            System.out.println("La pareja conformada por " + num + " y " + num2 + " vinieron a bailar");
            System.out.println("La persona de la pareja numero " + num + " se encuentra en la fila 1");
            fila1.add(num);
            System.out.println("La persona de la pareja numero " + num2 + " se encuentra en la fila 2");
            fila2.add(num2);
            mutex.release();
            ingresaFila1.release();
            ingresaFila2.release();
            pasa.release();

        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }

    public void entrarBailar(int id) {
        boolean enA;

        try {
            // Determinar fila
            mutex.acquire();
            enA = fila1.contains(id);
            mutex.release();

            if (!enA) { // está en B
                mutex.acquire();
                enA = false;
                mutex.release();
            }

            while (true) {
                if (enA) {
                    hayaParejaDesdeA(id);
                    break;
                } else {
                    hayaParejaDesdeB(id);
                    break;
                }
            }

            // Espera a ser elegido
            // Cuando lo liberan, sale a bailar
        } catch (InterruptedException e) {}
    }

    //---- LO QUE HACE CADA FILA PARA FORMAR PAREJA ----//

    private void hayaParejaDesdeA(int id) {
        try {
            ingresaFila1.acquire(); // esperar turno en A

            mutex.acquire();
            if ((int)fila1.peek() == id) { // Está primero
                // Ver si hay alguien en B
                if (ingresaFila2.tryAcquire()) {
                    int otro = (int)fila2.poll(); // saca uno de B

                    fila1.poll(); // saca este de A

                    System.out.println("→ " + id + " sale a bailar con " + otro);

                } else {
                    // No había nadie en la otra fila → re-encolar
                    ingresaFila1.release();
                }
            }
            mutex.release();
        } catch (InterruptedException e) {}
    }

    private void hayaParejaDesdeB(int id) {
        try {
            ingresaFila2.acquire();

            mutex.acquire();
            if ((int)fila2.peek() == id) {
                if (ingresaFila1.tryAcquire()) {
                    int otro = (int)fila1.poll();

                    fila2.poll();

                    System.out.println("→ " + id + " sale a bailar con " + otro);

                } else {
                    ingresaFila2.release();
                }
            }
            mutex.release();
        } catch (InterruptedException e) {}
    }
}
    

