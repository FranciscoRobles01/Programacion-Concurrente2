/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda2;

/**
 *
 * @author roble
 */
public class Cajero extends Thread {

    private String nombre;
    private Cliente cliente;
    private long initialTime;
// Constructor, y métodos de acceso

    public Cajero(String nombre, Cliente cliente) {
        this.nombre = nombre;
        this.cliente = cliente;
    }

    public void esperarXsegundos(int i) {

        try {
            Thread.sleep(i * 1000);
        } catch (Exception e) {
            System.out.println("Error en el escaneo de productos");
        }
    }

    public void run() {
        System.out.println("El cajero " + this.nombre
                + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + "del cliente " + this.cliente.getNombre() + "->Tiempo: "
                    + (System.currentTimeMillis() - this.initialTime) / 1000
                    + "seg");
        }
        System.out.println("El cajero" + this.nombre + "HA TERMINADO DE PROCESAR" + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000
                + "seg");

    }
}
