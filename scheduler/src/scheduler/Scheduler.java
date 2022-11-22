package scheduler;

public class Scheduler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String politica = "";
        String rangoTiempo = "";
        Double tiempoArith = 0.0;
        Double tiempoIO = 0.0;
        Double tiempoCond = 0.0;
        Double tiempoIte = 0.0;
        boolean dual = false;
        Double quantum = 0.0;

        if (args.length == 6) {
            politica = args[0];
            rangoTiempo = args[1];
            tiempoArith = Double.valueOf(args[2]);
            tiempoIO = Double.valueOf(args[3]);
            tiempoCond = Double.valueOf(args[4]);
            tiempoIte = Double.valueOf(args[5]);
            /*System.out.println("Politica " + politica + " rango " + rangoTiempo + " tiempo aritmetico " + tiempoArith
                    + "\ntiempo IO " + tiempoIO + " tiempo condicional " + tiempoCond + " tiempo iterativo " + tiempoIte);*/
        } else if (args.length == 7) {
            politica = args[1];
            if (politica.equals("-rr")) {
                rangoTiempo = args[1];
                tiempoArith = Double.valueOf(args[2]);
                tiempoIO = Double.valueOf(args[3]);
                tiempoCond = Double.valueOf(args[4]);
                tiempoIte = Double.valueOf(args[5]);
                quantum = Double.valueOf(args[6]);
            } else {
                rangoTiempo = args[2];
                tiempoArith = Double.valueOf(args[3]);
                tiempoIO = Double.valueOf(args[4]);
                tiempoCond = Double.valueOf(args[5]);
                tiempoIte = Double.valueOf(args[6]);
                dual = true;
            }

            /*System.out.println("Politica " + politica + " rango " + rangoTiempo + " tiempo aritmetico " + tiempoArith
                    + "\ntiempo IO " + tiempoIO + " tiempo condicional " + tiempoCond + " tiempo iterativo " + tiempoIte);*/
        }
        String[] tiempos = rangoTiempo.split("-");
        Double tiempoI = Double.valueOf(tiempos[0]);
        Double tiempoF = Double.valueOf(tiempos[1]);

        GeneradorProcesos gp = new GeneradorProcesos();
        gp.procesar(politica, tiempoI, tiempoF, tiempoArith, tiempoIO, tiempoCond, tiempoIte, dual, quantum);

    }

}
