/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PLANTAEMBOTELLADORA2021;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Planta planta = new Planta();
        Embotellador aguas[] = new Embotellador[1];
        EmbotelladorV vinos[] = new EmbotelladorV[1];
        Empaquetador empaquetador = new Empaquetador(planta);
        Camion camion = new Camion(planta);
        MadurarVino tiempo = new MadurarVino(planta,3000);
        
        for(int i=0; i< aguas.length;i++){
            aguas[i]= new Embotellador((i+1),planta);
        }
        
        for(int i=0; i < vinos.length; i++){
            vinos[i]= new EmbotelladorV((i+1),planta);
        }
        
        camion.start();
        empaquetador.start();
        tiempo.start();
        for(int i=0; i < vinos.length; i++){
            vinos[i].start();
        }
        
        for(int i=0; i< aguas.length;i++){
            aguas[i].start();
        }
    }
    
}
