/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scheduler.processing;

/**
 *
 * @author Johan Chan
 */
public class ArithmeticProcess extends SimpleProcess {

    public ArithmeticProcess(int id) {
        super(id);
    }
    int numeroVeces = 0;
    Double tiempoA;

    public Double getTiempoA() {
        return tiempoA;
    }

    public void setTiempoA(Double tiempoA) {
        this.tiempoA = tiempoA;
    }

    public int getNumeroVeces() {
        return numeroVeces;
    }

    public void setNumeroVeces(int numeroVeces) {
        this.numeroVeces = numeroVeces;
    }
}
