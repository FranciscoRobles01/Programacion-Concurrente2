/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalaDeBaile;

/**
 *
 * @author roble
 */
public class PersonaSola extends Thread{
    
    private int num;
    private SalaBaile sala;
    private int fila;
    
    public PersonaSola(int num, int fila,SalaBaile sala){
        this.num = num;
        this.sala = sala;
        this.fila=fila;
    }
    
    public void run(){
    
        sala.hacerFilaSolo(num, fila);
        sala.entrarBailar(num);
    }
}
