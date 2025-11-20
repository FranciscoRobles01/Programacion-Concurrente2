/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CentroHemoterapia;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Centro centro = new Centro(1);
       Persona persona = new Persona(1,centro);
       Clinico clinico = new Clinico(centro);
       Enfermero enfermero = new Enfermero(centro);
       Recepcionista recepcionista = new Recepcionista(centro);
       
      recepcionista.start();
      persona.start();
      clinico.start();
      enfermero.start();
    }
    
}
