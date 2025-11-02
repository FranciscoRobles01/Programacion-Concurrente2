/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author roble
 */
public class Cinta {

    private int caja;
    private int capacidad;
    private int pastelA;
    private boolean reemplazar;
    private boolean habilitado;
    private int pastelB;
    private int pastelC;

    public Cinta() {
        capacidad = 100;
        pastelA = 0;
        pastelB = 0;
        pastelC = 0;
        caja = 0;
        reemplazar = false;
        habilitado=true;
    }

    public synchronized void hornearPastel(char tipo) {

        if (tipo == 'A') {
            pastelA++;
        } else if (tipo == 'B') {
            pastelB++;
        } else {
            pastelC++;
        }
        notifyAll();
    }

    public synchronized void tomarPastel(int num) {
        try {
            while ((pastelA == 0 && pastelB == 0 && pastelC == 0) || !habilitado) {
                this.wait();
            }
            if (pastelA != 0) {
                while(!verificaCaja(20)){
                    this.wait();
                }
                System.out.println("El robot " + num + " ha agarrado un pastel de tipo A y lo guardo en la caja (Ocupo 20 de espacio)");
                caja = caja + 20;
                pastelA--;
            } else if (pastelB != 0) {
                while(!verificaCaja(25)){
                    this.wait();
                }
                System.out.println("El robot " + num + " ha agarrado un pastel de tipo B y lo guardo en la caja (Ocupo 25 de espacio)");
                caja = caja + 25;
                pastelB--;
            } else {
                while(!verificaCaja(15)){
                    this.wait();
                }
                System.out.println("El robot " + num + " ha agarrado un pastel de tipo C y lo guardo en la caja (ocupo 15 de espacio)");
                caja = caja + 15;
                pastelC--;
            }
            notifyAll();
        } catch (InterruptedException e) {
            System.out.println("Error en tomar pastel");
        }
    }

    public synchronized boolean verificaCaja(int num) {
        boolean aux=true;
            if ((num + caja) > capacidad) {
                reemplazar = true;
                aux=false;
            }
            return aux;
    }

    public synchronized void retirarCaja(int num) {
        try {
            while (!reemplazar) {
                this.wait();
            }
            System.out.println("El brazo numero " + num + " se encuentra cambiando la caja...");

        } catch (InterruptedException e) {
            System.out.println("Error en retirar caja");
        }
    }

    public synchronized void poneCaja(int num) {
        System.out.println("El brazo numero " + num + " ha colocado una caja nueva");
        caja = 0;
        reemplazar = false;
        notifyAll();
    }
}
