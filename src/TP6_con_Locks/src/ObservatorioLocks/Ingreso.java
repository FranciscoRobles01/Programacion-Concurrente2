/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ObservatorioLocks;

/**
 *
 * @author roble
 */
public class Ingreso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Observatorio observatorio = new Observatorio();
        Visitante visitantes[] = new Visitante[10];
        Investigador investigadores[]= new Investigador[5];
        Visitante enSilla[] = new Visitante[8];
        Mantenimiento personal[] = new Mantenimiento[2];
        
        for(int i=0; i < visitantes.length;i++){
            visitantes[i] = new Visitante((i+1),observatorio,'0');
        }
        
        for(int i=0; i < enSilla.length;i++){
            enSilla[i] = new Visitante((i+1),observatorio,'1');
        }
        
        for(int i=0; i < investigadores.length;i++){
            investigadores[i] = new Investigador((i+1),observatorio);
        }
        
        for(int i=0; i < personal.length;i++){
            personal[i] = new Mantenimiento((i+1), observatorio);
        }
        for(int i=0; i < enSilla.length;i++){
            enSilla[i].start();
        }
        for(int i=0; i < visitantes.length;i++){
            visitantes[i].start();
        }
        
        
        
        for(int i=0; i < investigadores.length;i++){
            investigadores[i].start();
        }
        
        for(int i=0; i < personal.length;i++){
            personal[i].start();
        }
    }
    
}
