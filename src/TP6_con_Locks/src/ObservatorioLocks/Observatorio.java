/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObservatorioLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Observatorio {

    private int cantVisitante;
    private int cantInvestigador;
    private int cantMantenimiento;
    private int cantVisitanteSilla;
    private int capacidadMax;
    private final Lock lock;
    private Condition pasaVisitante;
    private Condition pasaInvestigador;
    private Condition pasaMantenimiento;

    public Observatorio() {
        cantVisitante = 0;
        cantMantenimiento = 0;
        cantInvestigador = 0;
        capacidadMax = 5;
        cantVisitanteSilla = 0;
        lock = new ReentrantLock();
        pasaVisitante = lock.newCondition();
        pasaMantenimiento = lock.newCondition();
        pasaInvestigador = lock.newCondition();
    }

    public void pasaInvestigador(int num) {
        lock.lock();
        try {
            while (cantVisitante > 0 || cantMantenimiento > 0 || cantInvestigador == capacidadMax) {
                pasaInvestigador.await();
            }
            cantInvestigador++;
            System.out.println("El investigador numero " + num + " ha ingresado al observatorio");
        } catch (InterruptedException e) {
            System.out.println("Error en pasaInvestigador");
        } finally {
            lock.unlock();
        }
    }

    public void pasaVisitante(int num, char tipo) {

        lock.lock();
        try {
            if (tipo == '1') {
                while (cantInvestigador > 0 || cantMantenimiento > 0 || cantVisitante >= 3) {
                    pasaVisitante.await();
                }
                cantVisitanteSilla++;
                capacidadMax = 3;
            } else {
                while (cantInvestigador > 0 || cantMantenimiento > 0 || cantVisitante == capacidadMax) {
                    pasaVisitante.await();
                }
            }
            cantVisitante++;

            System.out.println("El visitante tipo " + tipo + " y numero " + num + " ha ingresado al observatorio");

        } catch (InterruptedException e) {
            System.out.println("Error pasa visitante");
        } finally {
            lock.unlock();
        }
    }

    public void pasaMantenimiento(int num) {
        lock.lock();
        try {
            while (cantVisitante > 0 || cantInvestigador > 0 || cantMantenimiento == capacidadMax) {
                pasaMantenimiento.await();
            }
            cantMantenimiento++;
            System.out.println("El personal de mantenimiento numero " + num + " ha ingresado al observatorio");
        } catch (InterruptedException e) {
            System.out.println("Error en pasa matenimiento");
        } finally {
            lock.unlock();
        }
    }

    public void abandonaVisitante(int num, char tipo) {

        lock.lock();
        try {
            cantVisitante--;
            if (tipo == '1') {
                cantVisitanteSilla--;
                if (cantVisitanteSilla == 0) {
                    capacidadMax = 5;
                }
            }
            System.out.println("El visitante tipo " + tipo + " y numero " + num + " esta abandonando el observatorio");

            pasaMantenimiento.signalAll();
            pasaInvestigador.signalAll();
            pasaVisitante.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void abandonaInvestigador(int num) {

        lock.lock();
        try {
            cantInvestigador--;

            System.out.println("El investigador numero " + num + "esta abandonando el observatorio");

            pasaVisitante.signalAll();
            pasaMantenimiento.signalAll();
            pasaInvestigador.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void abandonaMatenimiento(int num) {

        lock.lock();
        try {
            cantMantenimiento--;
            System.out.println("El personal de mantenimiento numero " + num + " esta abandonando el observatorio");

            pasaVisitante.signalAll();

            pasaInvestigador.signalAll();
            pasaMantenimiento.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
