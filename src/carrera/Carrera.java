
package carrera;

/**
 *
 * @author roble
 */
public class Carrera {

    
    public static void determinarGanador(Corredor []corredores){
    
        int cantPasosAux =0;
        int ganador=-1;
        for(int i =0; i < corredores.length; i++){
            if(cantPasosAux <= corredores[i].getPasos()){
                cantPasosAux = corredores[i].getPasos();
                ganador = corredores[i].getNombre();
            }
        }
        System.out.println("El ganador de esta carrera fue el corredor:"+ganador);
    }
    
    public static void main(String[] args) {
        
        Corredor []corredores = new Corredor[5];
        Thread []hilos = new Thread[5];
        
        for(int i=0; i < corredores.length; i++){
            corredores[i] = new Corredor(i+1);
            hilos[i] = new Thread (corredores[i]);
        }
        for(int j=0; j < hilos.length;j++){
            hilos[j].start();
        }
        
        try{
            for(int i =0; i < hilos.length;i++){
                hilos[i].join();
            }
        }catch(Exception e){
            System.out.println("Ocurrio un error en el main");
        }
        System.out.println("LA CARRERA HA TERMINADO");
        determinarGanador(corredores);
    }
    
}
