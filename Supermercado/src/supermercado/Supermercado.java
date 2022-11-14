package supermercado;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Supermercado {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Cliente> cola = new ConcurrentLinkedQueue<Cliente>();
        Proceso proceso = new Proceso();
        proceso.emulador(cola);
    }
    
}
