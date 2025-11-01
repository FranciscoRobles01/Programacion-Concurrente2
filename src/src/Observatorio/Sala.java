/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observatorio;

/**
 *
 * @author roble
 */
public class Sala {

    private int cantVisitante;
    private int cantMantenimiento;
    private int cantInvestigadores;
    private int capacidad;
    private int cantVisitanteB;

    public Sala() {
        this.capacidad = 5;
        cantVisitante = 0;
        cantVisitanteB = 0;
        cantMantenimiento = 0;
        cantInvestigadores = 0;
    }

    public synchronized void ingresaVisitante(int num, char tipo) {
        try {
            if (tipo == 'A') {
                while (cantMantenimiento > 0 || cantInvestigadores > 0 || cantVisitante >= capacidad) {
                    this.wait();
                }
            } else if (tipo == 'B') {
                while (cantMantenimiento > 0 || cantInvestigadores > 0 || cantVisitante >= 3) {
                    this.wait();
                }
                capacidad = 3;
                cantVisitanteB++;
            }
            cantVisitante++;
            System.out.println("El visitante numero " + num + " de tipo " + tipo + " ha ingresado a la sala");
            notifyAll();
        } catch (InterruptedException e) {
            System.out.println("Error en ingresa visitante");
        }
    }

    public synchronized void saleVisitante(int num, char tipo) {

        if (tipo == 'B') {
            cantVisitanteB--;
            if (cantVisitanteB == 0) {
                capacidad = 5;
            }
        }
        cantVisitante--;
        System.out.println("El visitante numero " + num + " de tipo " + tipo + " ha salido de la sala");
        notifyAll();
    }

    public synchronized void entraMantenimiento(int num) {
        try {
            while (cantVisitante > 0 || cantInvestigadores > 0 || cantMantenimiento == capacidad) {
                this.wait();
            }
            cantMantenimiento++;
            System.out.println("El empleado de mantenimiento " + num + " se encuentra aseando la sala...");
            notifyAll();
        } catch (InterruptedException e) {
            System.out.println("Error entrar mantenimiento");
        }
    }
    
    
    public synchronized void saleMantenimiento(int num){
        cantMantenimiento--;
        System.out.println("El empleado de mantenimiento "+num+" esta saliendo de la sala...");
        notifyAll();
    }

        public synchronized void entraInvestigador(int num) {
        try {
            while (cantVisitante > 0 || cantMantenimiento > 0 || cantInvestigadores == capacidad) {
                this.wait();
            }
            cantInvestigadores++;
            System.out.println("El investigador " + num + " se encuentra en la sala...");
            notifyAll();
        } catch (InterruptedException e) {
            System.out.println("Error entrar mantenimiento");
        }
    }
    
    
    public synchronized void saleInvestigador(int num){
        cantInvestigadores--;
        System.out.println("El investigador "+num+" esta saliendo de la sala...");
        notifyAll();
    }
}
