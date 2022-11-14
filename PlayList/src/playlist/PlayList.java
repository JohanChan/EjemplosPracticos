package playlist;

import java.util.ArrayList;


public class PlayList {

    public static void main(String[] args) {
        // TODO code application logic here
        inicio(args[0]);
    }
    
    public static void inicio(String arg){
        Simulador s = new Simulador();
        ArrayList<Integer> lista = new ArrayList<>();
        s.llenarLista(Integer.parseInt(arg), lista);
        while(true){
            s.imprimirLista(lista);
            System.out.println("Suffle");
            s.suffle(lista); 
        }
        
    }


}
