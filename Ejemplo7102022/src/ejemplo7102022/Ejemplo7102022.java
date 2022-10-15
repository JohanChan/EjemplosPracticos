package ejemplo7102022;


public class Ejemplo7102022 {

/*
1. Echarle harina, agua, levadura y sal 
2. Masajear la masa
3. Ponerla a reposar por unos minutos
4. Masajear la masa
5. Hacer la forma de la pizza
6. Poner ingredientes
7. Hornear por 1 hora
8. Sacarla del horno
9. Cortar la pizza en porciones
10. Servir y comer.
*/
    
    
/*
1. Obtener los numeros
2. Sumar los numeros
3. Mostrar el resultado.    
*/
    
/*
1. Obtener la edad
2. Validar si edad es mayor a 18
3. Mostrar si es mayor o menor de edad.     
*/

    public static void main(String[] args) {
        //Sumatoria de dos numeros
        //Declaracion de variables
        //Tipo_de_dato nombre_variable ;
        int numero;
        int numero2;
        
        //Asignacion de variable
        //nombre_variables = valor_variable ;
        numero = 20;
        numero2 = 20;
        
        int suma; 
        suma = numero + numero2;
        System.out.println(suma);
        
        
        int edad;
        edad = 20;
        // Sintaxis if = if (expresion) { codigo } else { codigo }
        if (edad >= 18){
            System.out.println("Si es mayor de edad");
        }else{
            System.out.println("No es mayor de edad");
        }
        System.out.println("Contador con For");
        // Sintaxis for = for ( declaracionyasignacion ; condicional ; expresion ) { codigo }
        for ( int i = 0 ; i <= 10 ; i++ ){
            System.out.println(i);
        }
        System.out.println("********************");
        System.out.println("Contador con while");
        // Sintaxis while = while ( condicion ) { codigo }
        int i = 0;
        while ( i <= 10 ){
            System.out.println(i);
            i++;
        }
        
        // Sintaxis Llamar metodo nombre_metodo ( ) ;
        numero();
        // Sintaxis Llamar funcion nombre_funcion ( parametros ) ;
        int suma2 = sumar( numero, numero2 );
        System.out.println(suma2);
        //System.out.println(sumar( numero, numero2 ));
        
    }
    
    // Sintaxis crear metodo: accesibilidad (private, public, friendly) void nombre_metodo ( ) { codigo }
    // Sintaxis crear metodo: accesibilidad (private, public, friendly) void nombre_metodo ( parametros ) { codigo }
    public static void numero (){
        System.out.println("***************************************");
        System.out.println("Sumatoria de dos numeros desde un metodo");
        //Sumatoria de dos numeros desde un metodo
        //Declaracion de variables
        //Tipo_de_dato nombre_variable ;
        int numero;
        int numero2;
        
        //Asignacion de variable
        //nombre_variables = valor_variable ;
        numero = 5;
        numero2 = 2;
        
        int suma; 
        suma = numero + numero2;
        System.out.println(suma);
    }
    
    // Sintaxis crear funcion: accesibilidad (private, public, friendly) tipo_dato nombre_funcion ( parametros ) { codigo return nombre_variable; }
    // Sintaxis crear funcion: accesibilidad (private, public, friendly) tipo_dato nombre_funcion (  ) { codigo return nombre_variable; }
    public static int sumar ( int numero, int numero2 ) {
        System.out.println("*********************************");
        System.out.println("Suma de dos numeros desde funcion");
        int suma = numero + numero2;
        return suma;
    }
    
}
