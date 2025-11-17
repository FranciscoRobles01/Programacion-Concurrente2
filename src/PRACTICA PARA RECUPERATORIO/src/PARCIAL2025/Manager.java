/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2025;

/**
 *
 * @author roble
 */
public class Manager extends Thread{
    
    private Album album;
    private String nombre;
    private int duracion;
    
    public Manager(Album album, String nombre, int duracion){
        this.album = album;
        this.nombre = nombre;
        this.duracion = duracion;
    }
    
    public void run(){
        try{
        album.escribirNombre(nombre, duracion);
        Thread.sleep(1000);
        album.nombreEscrito(nombre);
        album.promocionarAlbum();
        Thread.sleep(1500);
        album.terminarPromocion();
        album.pensandoNombre();
        Thread.sleep(1000);
        }catch(Exception e){
            System.out.println("Error6");
        }
    }
}
