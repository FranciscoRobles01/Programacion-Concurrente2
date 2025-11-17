/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2025;

/**
 *
 * @author roble
 */
public class Productor extends Thread{
    private Mesa mesa;
    private Album album;
    private int num;
    private String tipo;

    public Productor(int num, Mesa mesa, Album album, String tipo){
        this.mesa = mesa;
        this.num = num;
        this.album = album;
        this.tipo = tipo;
    }
    
    public void run(){
        try{
            while(true){
                int i=mesa.agarrarCancion(num, tipo);
                Thread.sleep(1000);
                mesa.llevarCancion(num, tipo);
                album.colocarCancion(num, i, tipo);
                Thread.sleep(1000);
            
            }
        }catch(InterruptedException e){
            System.out.println("Error5");
        }
    }
}
