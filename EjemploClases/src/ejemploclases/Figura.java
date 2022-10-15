package ejemploclases;

public abstract class Figura {
    double x;
    double y;
    
    //Constructor
    public Figura(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public abstract double perimetro();
}
