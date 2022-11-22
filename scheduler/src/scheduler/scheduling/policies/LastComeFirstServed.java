package scheduler.scheduling.policies;

import java.util.Stack;
import scheduler.processing.SimpleProcess;


public class LastComeFirstServed extends Policy implements Enqueable{
    public LastComeFirstServed(){}
    
    Stack<SimpleProcess> pilaProcesos = new Stack<SimpleProcess>();

    @Override
    public void add(SimpleProcess p) {
        this.pilaProcesos.push(p);
    }

    @Override
    public void remove() {
        this.pilaProcesos.pop();
    }

    @Override
    public SimpleProcess next() {
        return this.pilaProcesos.peek();
    }
}
