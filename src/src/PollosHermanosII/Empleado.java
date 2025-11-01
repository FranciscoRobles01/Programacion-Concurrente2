/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PollosHermanosII;

/**
 *
 * @author roble
 */
public class Empleado extends Thread{

    private String nombre;
    private Confiteria confiteria;
    private char pedido;
    
    public Empleado(String nombre, Confiteria confiteria, char pedido){
        this.nombre = nombre;
        this.confiteria = confiteria;
        this.pedido = pedido;
    }
    
    public void run(){
    
        confiteria.tomarAsiento(nombre);
        
        switch (pedido) {
            case 'c':
                confiteria.ordenar(nombre,pedido);
                confiteria.comer(nombre);
                confiteria.dejarSilla(nombre);
                break;
            case 't':
                confiteria.ordenar(nombre,pedido);
                confiteria.tomarBebida(nombre);
                confiteria.dejarSilla(nombre);
                break;
            default:
                confiteria.ordenar(nombre,'t');
                confiteria.tomarBebida(nombre);
                confiteria.ordenar(nombre,'c');
                confiteria.comer(nombre);
                
                confiteria.dejarSilla(nombre);
                break;
        }
    }
    
    
}
