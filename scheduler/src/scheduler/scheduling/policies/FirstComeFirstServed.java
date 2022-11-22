package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FirstComeFirstServed extends Policy implements Enqueable{
    public FirstComeFirstServed(){}
    //ConcurrentLinkedQueue<SimpleProcess> colaProcesos = new ConcurrentLinkedQueue<SimpleProcess>();
    ConcurrentLinkedQueue<SimpleProcess> colaProcesos = new ConcurrentLinkedQueue<SimpleProcess>();

    
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
}
