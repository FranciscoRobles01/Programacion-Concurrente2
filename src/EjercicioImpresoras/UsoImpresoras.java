/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EjercicioImpresoras;

/**
 *
 * @author roble
 */
public class UsoImpresoras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorImpresora gestor = new GestorImpresora(2);
        
        Cliente cliente1 = new Cliente(1,gestor,6);
        Cliente cliente2 = new Cliente(2,gestor,2);
        Cliente cliente3 = new Cliente(3,gestor,4);
        Cliente cliente4 = new Cliente(4,gestor,1);
        Cliente cliente5 = new Cliente(5,gestor,5);
        Cliente cliente6 = new Cliente(6,gestor,3);
        
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
        cliente6.start();
    }
    
}
