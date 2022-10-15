package semaforo;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Johan Chan
 */
public class Semaforo implements Runnable{

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> colaA = new ConcurrentLinkedQueue();
        ConcurrentLinkedQueue<Integer> colaB = new ConcurrentLinkedQueue();
        Thread semaforoA = new Thread(new Semaforo(colaA, "A", 1));
        Thread semaforoB = new Thread(new Semaforo(colaA, "B", 3));
        semaforoA.start();
        semaforoB.start();
    }

     ConcurrentLinkedQueue<Integer> cola = new ConcurrentLinkedQueue();
     String nombreCola;
     int estadosemaforo;
     
    public Semaforo(ConcurrentLinkedQueue<Integer> cola, String nombreCola, int estadosemaforo){
        this.cola = cola;
        this.nombreCola = nombreCola;
        this.estadosemaforo = estadosemaforo;
    }
    
    public  void inicio(){
        semaforo(this.cola, this.nombreCola, this.estadosemaforo);
    }
    
    public  void semaforo(ConcurrentLinkedQueue<Integer> cola, String nombreCola, int estado) {    
        Random random = new Random();
        int tiempoverde = 5;
        int tiempoamarillo = tiempoverde / 3;
        int tiemporojo = tiempoverde + tiempoamarillo;
        //1: verde, 2: amarillo, 3: rojo
        
        int index = 0;
        while (true) {
            if (estado == 1) {
                System.out.println("Cola "+nombreCola+": Color Rojo -> Color Verde");
                if(cola.size() > 0){
                    cola.remove();
                    System.out.println("Salio un carro de la cola "+nombreCola);
                    System.out.println("Tama de cola "+nombreCola+" es igual a "+cola.size());   
                }
                delay(tiempoverde);
                estado = 2;
            } else if (estado == 2) {
                System.out.println("Cola "+nombreCola+": Color Verde -> Color Amarillo");
                int r = random.nextInt(tiempoverde)+1;
                if(r < tiempoverde){
                    System.out.println("Llego un carro a cola "+nombreCola);
                    cola.add(r);
                    System.out.println("Tama de cola "+nombreCola+" es igual a "+cola.size());
                }
                delay(tiempoamarillo);
                estado = 3;
            } else if (estado == 3) {
                System.out.println("Cola "+nombreCola+": Color Amarillo -> Color Rojo");
                int r = random.nextInt(tiempoverde)+1;
                if(r < tiempoverde){
                    System.out.println("Llego un carro a cola "+nombreCola);
                    cola.add(r);
                    System.out.println("Tama de cola "+nombreCola+" es igual a "+cola.size());
                }
                delay(tiemporojo);
                estado = 1;
            }
            index++;
        }
    }

    public  void delay(int tiempo) {
        try {
            Thread.sleep(tiempo * 1000);
        } catch (Exception ex) {
            System.out.println("Error " + ex);
        }
    }

    @Override
    public void run() {
        this.inicio();
    }

}
