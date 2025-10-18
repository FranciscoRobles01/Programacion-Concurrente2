/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioImpresoras;

/**
 *
 * @author roble
 */
public class Cliente extends Thread {

    private int numCliente;
    private GestorImpresora gestor;
    private int cantCopias;

    public Cliente(int numCliente, GestorImpresora gestor, int cantCopias) {

        this.numCliente = numCliente;
        this.gestor = gestor;
        this.cantCopias = cantCopias;
    }

    public void run() {

        System.out.println("El cliente " + numCliente + " esta en busca de una impresora...");
        int numImpresora = gestor.tomarImpresora();
        System.out.println("El cliente " + numCliente + " ha adquirido la impresora numero " + (numImpresora + 1));

        try {
            for (int i = 1; i <= cantCopias; i++) {
                System.out.println("El cliente numero " + numCliente + " empezo a imprimir la copia numero " + i);
                Thread.sleep(1000);
            }
            
            System.out.println("El cliente "+numCliente+" ha terminado de imprimir sus copias, deja libre la impresora "+numImpresora+1);
            gestor.terminarDeImprimir(numImpresora);
            
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error en la impresion del cliente " + numCliente);
        }
    }
}
