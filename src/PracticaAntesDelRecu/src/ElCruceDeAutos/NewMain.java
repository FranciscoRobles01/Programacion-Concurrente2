/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ElCruceDeAutos;

/**
 *
 * @author roble
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Auto autos[] = new Auto[10];
        AutoO autosO[] = new AutoO[10];
        Cruce cruce = new Cruce();
        Control control = new Control(cruce);
        
        for(int i=0; i < autos.length;i++){
            autos[i]= new Auto((i+1),cruce);
        }
        
        for(int i=0; i < autosO.length;i++){
            autosO[i]= new AutoO((i+1),cruce);
        }
        
        for(int i=0; i < autos.length;i++){
            autos[i].start();
        }
        
        for(int i=0; i < autosO.length;i++){
            autosO[i].start();
        }
        
        control.start();
    }
    
}
