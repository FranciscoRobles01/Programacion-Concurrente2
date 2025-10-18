/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PollosHermanos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class Confiteria {

    private Semaphore banquito;
    private Semaphore servir;
    private Semaphore comer;
    private Semaphore terminarComer;

    public Confiteria() {
        banquito = new Semaphore(1);
        servir = new Semaphore(0);
        terminarComer = new Semaphore(0);
        comer = new Semaphore(0);
    }

    public void sentarse(int id) {
        try {
            banquito.acquire();
            System.out.println("El empleado " + id + " se encuentra sentado y listo para pedir...");
            servir.release();
        } catch (InterruptedException e) {
            System.out.println("ERROR EN SENTARSE");
        }
    }

    public boolean servirComida() {
        boolean atendio=true;
        try {
            
            if (servir.tryAcquire()) {
                System.out.println("El mozo esta cocinando... ");
                Thread.sleep(500);
                System.out.println("El mozo le sirve el pedido solicitado al empleado...");
                comer.release();
            } else {
                System.out.println("El mozo esta inventando nuevas versiones de pollo");
                Thread.sleep(1000);
                atendio = false;
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR EN SERVIR COMIDA");
        }
        return atendio;
    }

    public void comer() {
        try {
            comer.acquire();
            System.out.println("El empleado se encuentra comiendo...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("HA OCURRIDO UN ERROR EN COMER");
        }
    }

    public void terminarDeComer() {
        System.out.println("El empleado ha terminado de comer y agradece la comida...");
        terminarComer.release();
        banquito.release();
    }

    public void esperarEmpleado() {
        try {
            terminarComer.acquire();
            System.out.println("El mozo se despide del empleado");
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error en esperarEmpleado");
        }
    }
}
