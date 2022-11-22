/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scheduler.scheduling.policies;

import java.util.LinkedList;
import scheduler.processing.SimpleProcess;


public class PriorityPolicy extends Policy implements Enqueable{

    LinkedList<SimpleProcess> cola = new LinkedList<SimpleProcess>();
    
    public PriorityPolicy(){}
    
    @Override
    public void add(SimpleProcess p) {
        this.cola.add(p);
    }

    @Override
    public void remove() {
        this.cola.remove();
    }

    @Override
    public SimpleProcess next() {
        return this.cola.peek();
    }
    
    public boolean vacia(){
        return this.cola.isEmpty();
    }
    
    public int tama(){
        return this.cola.size();
    }
}
