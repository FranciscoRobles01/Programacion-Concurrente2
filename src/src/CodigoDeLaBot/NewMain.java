/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CodigoDeLaBot;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Proceso proceso = new Proceso(200);
        System.out.println("comienza el programa");
        // creamos a 3 personas

        for (int i = 1; i <= 3; i++) {
            new Oxigeno("AtomoOxigeno " + i, proceso).start();
        }

        for (int j = 1; j <= 3; j++) {
            new Hidrogeno("AtomoHirogeno " + (j+3), proceso).start();
        }
    }
    
}
