
package ejemploclases;


public class Rectangulo extends Figura{

    double ancho;
    double largo;
    public Rectangulo( double x, double y, double ancho, double largo){
        super(x,y);
        this.ancho = ancho;
        this.largo = largo;
    }
    
    // 2*largo + 2*ancho = perimetro
    
    @Override
    public double perimetro(){
        double resultado = 2*this.largo + 2*this.ancho;
        return resultado;
    }
    
}
