/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioImpresoras;

import java.util.concurrent.Semaphore;

/**
 *
 * @author roble
 */
public class GestorImpresora {

    private Semaphore[] impresoras;

    public GestorImpresora(int cantImpresoras) {

        impresoras = new Semaphore[cantImpresoras];
        
        for(int i=0; i < impresoras.length;i++){
            impresoras[i] = new Semaphore(1);
        }
    }

    public int tomarImpresora() {
        boolean imprimio = false;
        int i = 0;
        while (!imprimio) {
            
            if (impresoras[i].tryAcquire()) {
                imprimio = true;
            } else if (i == impresoras.length - 1) {
                i = 0;
            } else {
                i++;
            }
        }
        return i;
    }

    public void terminarDeImprimir(int i) {

        impresoras[i].release();
    }
}
