/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial2023;

/**
 *
 * @author roble
 */
public class Embotellador extends Thread {

    private int id;
    private Planta planta;
    private char tipo;

    public Embotellador(int id, char tipo, Planta planta) {
        this.id = id;
        this.tipo = tipo;
        this.planta = planta;
    }

    public void run() {
        while (true) {
            try{
            planta.embotellar(id, tipo);
            Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Ocurrio un error en el hilo Embotellador");
            }
        }
    }
}
