
package playlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Simulador {
    Scanner sc = new Scanner(System.in);
    public Simulador(){
    }
    
    public void llenarLista(int n, ArrayList<Integer> lista){
        for(int i = 0; i< n; i++){
            lista.add(i);
        }
    }
    
    public ArrayList suffle(ArrayList<Integer> lista){
        Collections.shuffle(lista);
        return lista;
    }
    
    public void imprimirLista(ArrayList<Integer> lista){
        
        for(int e: lista){
            System.out.print(e +", ");
        }
        
        
        System.out.println("\nPresione ENTER para continuar");
        sc.nextLine();
    }
}

