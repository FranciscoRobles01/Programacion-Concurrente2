package programacionconcurrente2025;

import java.util.*;

public class ProgramacionConcurrente2025 {

    static class Instrumento {

        public void tocar() {
            System.out.println("Instrumento.tocar()");
        }

        public String tipo() {
            return "Instrumento";
        }

        public void afinar() {
        }
    }

    static class Guitarra extends Instrumento {

        public void tocar() {
            System.out.println("Guitarra.tocar()");
        }

        public String tipo() {
            return "Guitarra";
        }

        public void afinar() {
        }
    }

    static class Piano extends Instrumento {

        public void tocar() {
            System.out.println("Piano.tocar()");
        }

        public String tipo() {
            return "Piano";
        }

        public void afinar() {
        }
    }

    static class Saxofon extends Instrumento {

        public void tocar() {
            System.out.println("Saxofon.tocar()");
        }

        public String tipo() {
            return "Saxofon";
        }

        public void afinar() {
        }
    }
// Un tipo de Guitarra

    static class Guzla extends Guitarra {

        public void tocar() {
            System.out.println("Guzla.tocar()");
        }

        public void afinar() {
            System.out.println("Guzla.afinar()");
        }
    }
// Un tipo de Guitarra

    static class Ukelele extends Guitarra {

        public void tocar() {
            System.out.println("Ukelele.tocar()");
        }

        public String tipo() {
            return "Ukelele";
        }
    }

    static public class Musica {

        public static void afinar(Instrumento i) {

            i.tocar();
        }

        public static void afinarTodo(Instrumento[] e) {
            for (int i = 0; i < e.length; i++) {
                afinar(e[i]);
            }
        }
    

    public static void main(String[] args) {
        Instrumento[] orquesta = new Instrumento[5];
        int i = 0;

        orquesta[i++] = new Guitarra();
        orquesta[i++] = new Piano();
        orquesta[i++] = new Saxofon();
        orquesta[i++] = new Guzla();
        orquesta[i++] = new Ukelele();
        afinarTodo(orquesta);
    }
    
    }
}    


