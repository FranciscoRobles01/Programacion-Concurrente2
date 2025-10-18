/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package punto2TP3;

/**
 *
 * @author roble
 */
public class Juego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Energia energia = new Energia();

        Sanador sanador = new Sanador(energia);
        CriaturaOscura criaturaOscura = new CriaturaOscura(energia);

        sanador.start();
        criaturaOscura.start();

        try {
            sanador.join();
            criaturaOscura.join();
        } catch (Exception error) {
            System.out.println("Se ha interrumpido en el main");
        }
        
        System.out.println("La energia final fue: "+energia.getVida());
    }
}
