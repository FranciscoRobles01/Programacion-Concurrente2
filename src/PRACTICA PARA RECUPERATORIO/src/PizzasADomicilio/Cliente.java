/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PizzasADomicilio;

/**
 *
 * @author roble
 */
public class Cliente {
    private String nom;
    private String orden;
    
    public Cliente(String orden, String nombre){
        nom = nombre;
        this.orden = orden;
    }
    
    public String getOrden(){
        return orden;
    }
    
    public String getNombre(){
        return nom;
    }
}
