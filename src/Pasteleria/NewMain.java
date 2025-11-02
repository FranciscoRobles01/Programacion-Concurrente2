/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cinta cinta = new Cinta();
        Horno hornoA = new Horno('A', cinta);
        Horno hornoB = new Horno('B', cinta);
        Horno hornoC = new Horno('C', cinta);
        
        Robot robot1 = new Robot(1,cinta);
        Robot robot2 = new Robot(2,cinta);
        BrazoMecanico brazo = new BrazoMecanico(0, cinta);
        hornoC.start();
        hornoA.start();
        hornoB.start();
        
        
        robot1.start();
        robot2.start();
        brazo.start();
    }
    
}
