/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElCruceDeAutos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class Cruce {

    private Semaphore salidaS;
    private Semaphore entradaN;
    private Semaphore salidaE;
    private Semaphore entradaO;
    private Semaphore deNS;
    private Semaphore deOE;
    private boolean pasaN;

    public Cruce() {
        salidaS = new Semaphore(1);
        entradaN = new Semaphore(1);
        deNS = new Semaphore(1);
        entradaO = new Semaphore(0);
        salidaE = new Semaphore(0);     
        deOE = new Semaphore(0);
        pasaN = true;
    }

    public void llegaNorte() {
        try {
            deNS.acquire();
            entradaN.acquire();
            System.out.println("Un auto de N a S esta llegando al cruce");
            entradaN.release();
            deNS.release();
        } catch (Exception e) {

            System.out.println("Error");
        }
    }

    public void llegaOeste() {
        try {
            deOE.acquire();
            entradaO.acquire();
            System.out.println("Un auto de O a E esta llegando al cruce");
            entradaO.release();
            deOE.release();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void sale() {
        try {
            if (pasaN) {
                salidaS.acquire();
                System.out.println("Un auto de N a S se esta yendo del cruce");
                salidaS.release();
            } else {
                salidaE.acquire();
                System.out.println("Un auto de O a E se esta yendo del cruce");
                salidaE.release();
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void cambiaSemaforos() {
        try {
            if (pasaN) {
                salidaS.acquire();
                System.out.println("El semaforo de N a S se puso rojo, se habilita el paso de O a E");
                pasaN = false;
                
                salidaE.release();
                entradaO.release();
                deOE.release();
                
            } else {
                salidaE.acquire();
                System.out.println("El semaforo de O a E se puso rojo, se habilita el paso de N a S");
                pasaN=true;
                
                salidaS.release();
                entradaN.release();
                deNS.release();
                
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        }
    }

}
