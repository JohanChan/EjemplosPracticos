package scheduler.processing;

public abstract class SimpleProcess {
    protected int id;

    public SimpleProcess(int id){
        this.id = id;
    }
    

    public int getId() {
        return id;
    }
    
    public String toString(){
        return "";
    }
        
}
