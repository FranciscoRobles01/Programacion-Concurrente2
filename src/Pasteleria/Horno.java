/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author roble
 */
public class Horno extends Thread{
    private char tipo;
    private int peso;
    private Cinta cinta;
    
    public Horno(char tipo, Cinta cinta){
        this.tipo = tipo;

        this.cinta = cinta;
    }
    
    public void run(){
        int i=0;
        try{
        while(i < 5){
            Thread.sleep(800);
            cinta.hornearPastel(tipo);
            Thread.sleep(1000);
        }
        }catch(InterruptedException e){
            System.out.println("ERROR EN RUN HORNO");
        }
    }
}
