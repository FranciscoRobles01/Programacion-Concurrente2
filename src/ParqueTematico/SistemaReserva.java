/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParqueTematico;

/**
 *
 * @author roble
 */
public class SistemaReserva {
    int []areas = {2,3,4,1,2};
    
    
    public synchronized String reservarArea(int numVisitante, int numArea){
        String msg="";
        if(numArea >=0 && numArea < areas.length){
            if(areas[numArea] >0){
                msg = "El visitante numero "+numVisitante+" ha reservado con exito el area "+(numArea+1);
                areas[numArea]--;
            }else{
                System.out.println("El visitante"+numVisitante +" no ha podido reservar el area "+(numArea+1)+", ya que todos los espacios se encuentran ocupados");
            }
        
        }else{
            System.out.println("El visitante ha ingresado un numero erroneo, VISITANTE: "+ numVisitante + " AREA:"+ numArea);
        }
        return msg;
    }
    
    public int getCantAreas(){
        return areas.length-1;
    }
}
