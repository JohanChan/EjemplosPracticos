
package scheduler.scheduling.policies;


public abstract class Policy {
    protected int size;
    protected int totalProcesses;
    
    public Policy(){
        this.size = 0;
        this.totalProcesses = 0;
    }

    public void setTotalProcesses(int totalProcesses) {
        this.totalProcesses = totalProcesses;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public int size(){
        return this.size;
    }
    
    public int getTotalProcesses(){
        return this.totalProcesses;
    }
}
