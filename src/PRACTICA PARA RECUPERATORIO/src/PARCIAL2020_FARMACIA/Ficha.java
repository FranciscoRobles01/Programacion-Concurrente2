/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2020_FARMACIA;

/**
 *
 * @author roble
 */
public class Ficha {
    
    private int num;
    private int importe;
    
    public Ficha(int num, int importe){
        this.num =num;
        this.importe = importe;
    }
    
    public  int getNum(){
        return num;
    }
    
    public int getImporte(){
        return importe;
    }
    
    public void setImporte(int suma){
        importe = importe + suma;
    }
}
