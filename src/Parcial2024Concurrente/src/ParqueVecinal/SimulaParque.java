/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ParqueVecinal;

/**
 *
 * @author roble
 */
public class SimulaParque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parque parque = new Parque(5);
        Visitante visitantes[] = new Visitante[15];
        Residente residentes[] = new Residente[10];
        Escuela escuela1 = new Escuela(1, 2, 4, parque);
        Escuela escuela2 = new Escuela(2, 1, 5, parque);

        for (int i = 0; i < visitantes.length; i++) {
            visitantes[i] = new Visitante((i + 1), parque);
        }

        for (int i = 0; i < residentes.length; i++) {
            residentes[i] = new Residente((i + 1), parque);
        }

        for (int i = 0; i < visitantes.length; i++) {
            visitantes[i].start();
        }

        for (int i = 0; i < residentes.length; i++) {
            residentes[i].start();
        }

        escuela1.start();
        escuela2.start();
    }

}
