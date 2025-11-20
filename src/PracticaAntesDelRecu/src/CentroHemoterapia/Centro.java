/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CentroHemoterapia;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.LinkedList;
import java.util.Queue;

public class Centro {

    private int cantTotal;
    private int cantActual;
    private Queue<Integer> sillas;
    private Queue<Integer> entrevista;
    private Queue<Integer> extraccion;
    private Queue<Integer> llamadas;
    private boolean enLlamada;
    private boolean enEntrevista;
    private boolean enExtraccion;
    private boolean presentarse;
    private Lock lock;
    private Lock lock2;
    private Condition esperaTurno; //lock1
    private Condition esperaSilla; //lock1
    private Condition esperaLlamada; // lock2
    private Condition esperaRecepcionista; //lock2
    private Condition esperaEntrevista; //lock1
    private Condition hacerExtraccion;
    private Condition esperaConfirmacion;

    public Centro(int cantTotal) {
        cantActual = 0;
        this.cantTotal = cantTotal;

        sillas = new LinkedList();
        entrevista = new LinkedList();
        extraccion = new LinkedList();
        llamadas = new LinkedList();

        enLlamada = false;
        enEntrevista = false;
        presentarse = false;

        lock = new ReentrantLock();
        lock2 = new ReentrantLock();

        esperaTurno = lock.newCondition();
        esperaSilla = lock.newCondition();
        esperaConfirmacion = lock2.newCondition();
        esperaLlamada = lock2.newCondition();
        esperaRecepcionista = lock2.newCondition();
        esperaEntrevista = lock.newCondition();
        hacerExtraccion = lock.newCondition();

    }

    public void atenderLlamada() {
        try {
            lock2.lock();
            while (llamadas.isEmpty()) {
                System.out.println("El recepcionista esta procesando la sangre");
                esperaLlamada.await();
            }
            enLlamada = true;
            System.out.println("El recepcionista esta en llamada con el donador " + llamadas.peek());
        } catch (Exception e) {
            System.out.println("Error1");
        } finally {
            lock2.unlock();
        }
    }

    public void finalizarLlamada() {
        try {
            lock2.lock();
            System.out.println("El recepcionista le dice al donador " + llamadas.peek() + " que se presente al centro");
            llamadas.poll();
            enLlamada = false;
            presentarse = true;
            esperaConfirmacion.signalAll();
            esperaRecepcionista.signalAll();
        } finally {
            lock2.unlock();
        }
    }

    public void realizarLlamada(int i) {
        try {
            lock2.lock();
            while (enLlamada) {
                esperaRecepcionista.await();
            }
            System.out.println("El donador numero " + i + " esta llamando al recepcionista");
            llamadas.add(i);
            esperaLlamada.signal();
        } catch (Exception e) {
            System.out.println("ERROR............");
        } finally {
            lock2.unlock();
        }
    }

    public void irCentro(int i) {
        try {
            lock2.lock();
            while (!presentarse) {
                esperaConfirmacion.await();
            }
            presentarse = false;
            System.out.println("El donador numero " + i + " se esta dirigiendo al centro");
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            lock2.unlock();
        }
    }

    public void irSilla(int i) {
        try {
            lock.lock();
            while (cantActual + 1 > cantTotal) {
                esperaSilla.await();
            }
            System.out.println("El donador numero " + i + " se encuentra esperando en una silla");
            cantActual++;
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            lock.unlock();
        }
    }

    public void irEntrevista(int i) {
        try {
            lock.lock();
            while (enEntrevista) {
                esperaTurno.await();
            }
            System.out.println("El donante " + i + " abandona su silla y se dirige a su entrevista...");
            sillas.poll();
            enEntrevista = true;
            cantActual--;

            entrevista.add(i);
            esperaSilla.signalAll();
            esperaEntrevista.signalAll();
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            lock.unlock();
        }
    }

    public void hacerEntrevista() {
        try {
            lock.lock();
            while (entrevista.isEmpty()) {
                esperaEntrevista.await();
            }
            System.out.println("El clinico le esta haciendo una entrevista al donador " + entrevista.peek());
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            lock.unlock();
        }
    }

    public void terminarEntrevista() {
        try {
            lock.lock();
            System.out.println("El clinico ha finalizado la entrevista al donador " + entrevista.peek() + " lo agrega a la cola de extraccion");
            extraccion.add(entrevista.peek());
            entrevista.poll();
            enEntrevista = false;
            esperaTurno.signalAll();
            hacerExtraccion.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void hacerExtraccion() {
        try {
            lock.lock();
            while (extraccion.isEmpty()) {
                hacerExtraccion.await();
            }

            System.out.println("El enfermero le esta extrayendo la sangre al donante " + extraccion.peek());
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            lock.unlock();
        }
    }

    public void finalizarExtraccion() {
        try {
            lock.lock();
            System.out.println("El enfermero termino la extracion, le da el certificado al donante, un desayuno y se despide");
            extraccion.poll();
        } finally {
            lock.unlock();
        }
    }
}
