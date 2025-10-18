/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ParqueTematico;
import java.util.Random;
/**
 *
 * @author roble
 */
public class ParqueTematico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SistemaReserva sistema = new SistemaReserva();
        int i,num;
        Random rand = new Random();
        Visitante []visitantes = new Visitante[10];
        
        for(i=0; i < visitantes.length; i++){
            num = rand.nextInt(5);
            visitantes[i] = new Visitante(sistema, i, num);
        }
        
        for(i=0; i < visitantes.length; i++){
            visitantes[i].start();
        }
    }  
}
