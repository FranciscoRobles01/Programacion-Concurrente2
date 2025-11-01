/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BarcosFery;

/**
 *
 * @author roble
 */
public class Automovil extends Thread{
    private int num;
    private Ferry ferry;
    
    public Automovil(int num, Ferry ferry){
        this.num = num;
        this.ferry = ferry;
    }
    
    public void run(){
        ferry.ocuparAuto(num);
        ferry.bajarAuto(num);
    }
}
