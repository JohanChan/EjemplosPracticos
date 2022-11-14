package supermercado;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
public class Proceso {
    int correlativo;
    public Proceso() {

    }
    Scanner sc = new Scanner(System.in);
    public void emulador(ConcurrentLinkedQueue<Cliente> cola) {
        int i = 0;
        this.correlativo = 0;
        while (true) {
            if (cola.isEmpty()) {
                int tiempo = this.tiempo();
                cola.add(new Cliente(0, tiempo));
                System.out.println("Encolar");
            } else {
                int elijo = this.eleccion();
                
                if(elijo == 1){
                    // Ingresar nuevo cliente a cola
                    int tiempo = this.tiempo();
                    this.correlativo++;
                    cola.add(new Cliente(this.correlativo, tiempo));
                    System.out.println("Ha llegado un nuevo cliente "+this.correlativo+" a la cola");
                    System.out.println("Presione Enter para continuar");
                    sc.nextLine();
                }else{
                    // Atender cliente
                    Cliente aux = cola.remove();
                    System.out.println(aux.correlativo + " " + aux.tiempoatencion);
                    System.out.println("Atendiendo cliente "+aux.correlativo + " espere un momento");
                    this.delay(aux.tiempoatencion);
                    System.out.println("Cliente atendido, presione Enter para continuar");
                    sc.nextLine();
                }
            }
            i++;
        }
        
        
    }

    private int tiempo() {
        Random r = new Random();
        return r.nextInt(15) + 5;
    }

    private int eleccion(){
        Random r = new Random();
        return r.nextInt(2);        
    }
    
    private void delay(int tiempo) {
        try {
            Thread.sleep(tiempo * 1000);
        } catch (Exception ex) {
            System.out.println("Error " + ex);
        }
    }
}
