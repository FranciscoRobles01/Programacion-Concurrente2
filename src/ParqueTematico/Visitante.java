/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParqueTematico;
/**
 *
 * @author roble
 */
public class Visitante extends Thread{
    
    private SistemaReserva sistema;
    private int numVisitante;
    private int reservarArea;
    
    
    public Visitante(SistemaReserva sistema, int numVisitante, int numArea){

        this.sistema = sistema;
        this.numVisitante = numVisitante;
        this.reservarArea = numArea;
    }
    
    
    public void run(){
        System.out.println(sistema.reservarArea(numVisitante, reservarArea));
    }
}
