/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PARCIAL2025;

import java.util.Random;

/**
 *
 * @author roble
 */
public class GeneradorCanciones extends Thread {

    private Mesa mesa;

    public GeneradorCanciones(Mesa mesa) {
        this.mesa = mesa;
    }

    public void run() {
        try {
            while (true) {
                String tipo = generarCanciones();
                System.out.println("Bob ha creado una cancion de tipo " + tipo);
                mesa.colocarCanciones(tipo);
                System.out.println("Se esta preparando otra cancion...");
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Error7");
        }
    }

    public String generarCanciones() {
        String cancionGenerada = "";

        System.out.println("Se esta generando una cancion");
        Random random = new Random();
        int num = random.nextInt(0, 4);

        switch (num) {
            case 0:
                cancionGenerada = "Blues";
                break;
            case 1:
                cancionGenerada = "Flok";
                break;
            case 2:
                cancionGenerada = "Rock";
                break;
            case 3:
                cancionGenerada = "Country";
                break;
        }

        return cancionGenerada;
    }
}
