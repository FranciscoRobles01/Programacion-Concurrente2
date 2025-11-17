/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalaDeBaile;

/**
 *
 * @author roble
 */
public class Pareja extends Thread{
    
     private int num;
     private int num2;
    private SalaBaile sala;
    
    public Pareja(int num, int num2,SalaBaile sala){
        this.num = num;
        this.sala = sala;
        this.num2=num2;
    }
    
    public void run(){
    
        sala.hacerFilaPareja(num, num2);
        sala.entrarBailar(num);
    }
}

