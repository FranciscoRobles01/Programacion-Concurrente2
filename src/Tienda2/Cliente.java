/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda2;

/**
 *
 * @author roble
 */
public class Cliente {
    private String nombre;
    private int[] carroCompra;

    public Cliente(String nombre, int[] carroCompras) {
        this.nombre = nombre;
        this.carroCompra = carroCompras;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int[] getCarroCompra(){
        return carroCompra;
    }
}
