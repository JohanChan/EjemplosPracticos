package ejemplo21102022;

import java.util.ArrayList;


public class Ejemplo21102022 {


    public static void main(String[] args) {
        
        int[] vector = new int[4];
        vector[0] = 15;
        vector[1] = 3;
        vector[2] = 100;
        vector[3] = 80;
        System.out.println(vector.length);
        int[] auxiliar = new int[vector.length];
        auxiliar = vector;
        vector = new int[6];
        System.out.println(vector.length);
        vector = auxiliar;
        System.out.println(vector[3]);
        
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(30);
        System.out.println("Arraylist "+lista.get(2));
        
    }
    
}
