/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BuqueDeAutos;

/**
 *
 * @author roble
 */
public class Auto extends Thread{
    
    private int num;
    private Transbordador buque;
    
    public Auto(int num, Transbordador buque){
        this.num = num;
        this.buque = buque;
    }


    
    public void run(){
        buque.subirBuque(num);
        buque.bajarBuque(num);
    }
}
