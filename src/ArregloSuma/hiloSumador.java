/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArregloSuma;

/**
 *
 * @author roble
 */
public class hiloSumador extends Thread{
    private int []arreglo;
    private int inicio;
    private int fin;
    private int []resultado;
    private int posicion;
    
    public hiloSumador (int []arreglo, int inicio, int fin, int []resultado, int posicion){
    
        this.arreglo = arreglo;
        this.inicio = inicio;
        this.fin = fin;
        this.resultado = resultado;
        this.posicion = posicion;
    }
    
    public void run(){
    
        int i;
        int suma=0;
        for(i=inicio; i < fin; i++){
            suma = arreglo[i] + suma;
        }
        resultado[posicion]=suma;
    }
}
