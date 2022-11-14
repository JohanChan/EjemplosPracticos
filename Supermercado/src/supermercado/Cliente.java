package supermercado;

public class Cliente {
    int correlativo;
    int tiempoatencion;
    
    public Cliente(int correlativo, int tiempoatencion){
        this.correlativo = correlativo;
        this.tiempoatencion = tiempoatencion;
    }
    
    public int sigcorrelativo(){
        return this.correlativo ++;
    }
}
