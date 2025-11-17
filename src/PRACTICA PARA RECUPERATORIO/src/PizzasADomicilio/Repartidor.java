/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PizzasADomicilio;

/**
 *
 * @author roble
 */
public class Repartidor extends Thread{
    
    private Mostrador mostrador;
    private int num;
    private Cliente pedido;
    private int pedidosRealizados;
    
    public Repartidor(int num, Mostrador mostrador){
        this.num =num;
        this.mostrador = mostrador;
        pedidosRealizados =0;
    }
    
    public void run(){
        try{
        int i=0;
        while(true){
            if(i==10){
                System.out.println("El repartidor numero "+num+" se encuentra descansando");
                Thread.sleep(3000);
            }else{
                mostrador.repartir(num);
                Thread.sleep(1000);
                mostrador.darPedido(num);
                i++;
            }
            
        }
        }catch(InterruptedException e){
            System.out.println("Error");
        }
    }
    
    public void setPedido(Cliente pedido){
        this.pedido = pedido;
    }
    
    public Cliente getPedido(){
        return pedido;
    }
}
