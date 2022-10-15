
package ejemploclases;


public class Cuadrado extends Figura{
    double lado;
    public Cuadrado(double x, double y, double lado){
        super(x,y);
        this.lado = lado;
    }
    
    // 4*lado
    @Override
    public double perimetro(){
        double resultado = 4*this.lado;
        return resultado;
    }
    
    public void setLado(double lado){
        this.lado = lado;
    }
    
    public double getLado(){
        return this.lado;
    }
}
