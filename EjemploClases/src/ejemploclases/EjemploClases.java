
package ejemploclases;

/**
 *
 * @author Johan Chan
 */
public class EjemploClases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangulo rectangulo = new Rectangulo(0,0,4.2,8.5);
        double perrect = rectangulo.perimetro();
        System.out.println("Perimetro rectangulo "+perrect);
        Cuadrado cuadrado = new Cuadrado(0,0,6);
        double percuadrado = cuadrado.perimetro();
        System.out.println("Perimetro cuadrado "+percuadrado);
    }
    
    //Carro
    // Atributos: numero placa, marca, modelo, cilindraje
    // Metodos: constructor sin parametros encender, apagar
    
}