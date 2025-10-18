/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto2TP3;

/**
 *
 * @author roble
 */
public class Sanador extends Thread {

    private Energia mutex;

    public Sanador(Energia mutex) {
        this.mutex = mutex;
    }

    public void run() {

        for (int i = 0; i < 5; i++) {       
                mutex.revitaliza(3);                       
                try {
                    Thread.sleep(50);
                } catch (Exception error) {
                    System.out.println("Ha ocurrido un error en la revitalizacion");
                }
            
        }
    }

}
