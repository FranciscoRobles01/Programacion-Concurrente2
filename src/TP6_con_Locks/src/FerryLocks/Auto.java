/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FerryLocks;

/**
 *
 * @author roble
 */
public class Auto extends Thread{
    
    private int num;
    private Ferry ferry;
    private int espacio;
    
    public Auto(int num,int espacio, Ferry ferry){
        this.num = num;
        this.ferry = ferry;
        this.espacio = espacio;
    }
    
    public void run(){
        ferry.ocuparEspacioAuto(num, espacio);
        ferry.bajarFerryAuto(num, espacio);
    }
}
