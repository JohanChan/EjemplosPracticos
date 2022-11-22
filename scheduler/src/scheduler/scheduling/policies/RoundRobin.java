/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scheduler.scheduling.policies;

import java.util.concurrent.ConcurrentLinkedQueue;
import scheduler.processing.SimpleProcess;

/**
 *
 * @author Johan Chan
 */
public class RoundRobin extends Policy implements Enqueable{

    static ConcurrentLinkedQueue<SimpleProcess> colaProcesos = new ConcurrentLinkedQueue<SimpleProcess>();
    
    int numeroVeces = 0;
    
    public RoundRobin(){}
    
    @Override
    public void add(SimpleProcess p) {
        this.colaProcesos.add(p);
    }

    @Override
    public void remove() {
        this.colaProcesos.remove();
    }

    @Override
    public SimpleProcess next() {
        return this.colaProcesos.peek();
    }

    public int size(){
        return this.colaProcesos.size();
    }
    
    public boolean vacia(){
        return this.colaProcesos.isEmpty();
    }
    
    
}
