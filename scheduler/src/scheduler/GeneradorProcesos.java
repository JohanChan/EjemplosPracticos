package scheduler;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import scheduler.processing.ArithmeticProcess;
import scheduler.processing.ConditionalProcess;
import scheduler.processing.InputOutputProcess;
import scheduler.processing.LoopProcess;
import scheduler.processing.SimpleProcess;
import scheduler.scheduling.policies.FirstComeFirstServed;
import scheduler.scheduling.policies.LastComeFirstServed;
import scheduler.scheduling.policies.PriorityPolicy;
import scheduler.scheduling.policies.RoundRobin;

public class GeneradorProcesos {

    int id;
    Double tiempoI;
    Double tiempoF;
    Double tiempoArith;
    Double tiempoIO;
    Double tiempoCond;
    Double tiempoIte;
    Double quantum;
    boolean flag;
    boolean dual;
    SimpleProcess aux;
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    public GeneradorProcesos() {
        this.id = 0;
        flag = true;
    }

    public void procesar(String tipoProc, Double tiempoI, Double tiempoF, Double tiempoArith, Double tiempoIO, Double tiempoCond, Double tiempoIte, boolean dual, Double quantum) {
        this.tiempoI = tiempoI;
        this.tiempoF = tiempoF;
        this.tiempoArith = tiempoArith;
        this.tiempoIO = tiempoIO;
        this.tiempoCond = tiempoCond;
        this.tiempoIte = tiempoIte;
        this.dual = dual;
        this.quantum = quantum;
        this.aux = null;

        int i = 0;
        while (i < 50) {
            switch (tipoProc) {
                case "-fcfs":
                    if (flag) {
                        System.out.println("Politica First Come First Served Rango de Entrada " + this.tiempoI + " - " + this.tiempoF);
                        flag = false;
                    }
                    System.out.println("#############################################################################");
                    this.ejecutarFCFS();
                    this.delayEntrada();
                    System.out.println("#############################################################################");
                    break;
                case "-lcfs":
                    if (flag) {
                        System.out.println("Politica Last Come First Served Rango de Entrada " + this.tiempoI + " - " + this.tiempoF);
                        flag = false;
                    }
                    System.out.println("#############################################################################");
                    this.ejecutarLCFS();
                    this.delayEntrada();
                    System.out.println("#############################################################################");
                    break;
                case "-rr":
                    if (flag) {
                        System.out.println("Politica Round-Robin Rango de Entrada " + this.tiempoI + " - " + this.tiempoF);
                        flag = false;
                    }
                    System.out.println("#############################################################################");
                    this.ejecutarRR();
                    this.delayEntrada();
                    System.out.println("#############################################################################");
                    break;
                case "-pp":
                    if (flag) {
                        System.out.println("Politica Priority Policy Rango de Entrada " + this.tiempoI + " - " + this.tiempoF);
                        flag = false;
                    }
                    System.out.println("#############################################################################");
                    this.ejecutarPP();
                    this.delayEntrada();
                    System.out.println("#############################################################################");
                    break;
            }
            i++;
        }
    }

    private void ejecutarFCFS() {
        FirstComeFirstServed cola = new FirstComeFirstServed();
        SimpleProcess p = getProceso();
        cola.setTotalProcesses(this.id);
        Double tiempo = 0.0;
        if (p != null) {
            System.out.println(ANSI_GREEN + "Se agrega proceso a cola" + ANSI_RESET);
            cola.add(p);
            if (p instanceof ArithmeticProcess) {
                tiempo = this.tiempoArith;
                System.out.println("Tipo proceso: A\nId: " + this.id + "\nTiempo de atención: " + tiempo);
            } else if (p instanceof ConditionalProcess) {
                tiempo = this.tiempoCond;
                System.out.println("Tipo proceso: C\nId: " + this.id + "\nTiempo de atención: " + tiempo);
            } else if (p instanceof InputOutputProcess) {
                tiempo = this.tiempoIO;
                System.out.println("Tipo proceso: IO\nId: " + this.id + "\nTiempo de atención: " + tiempo);
            } else if (p instanceof LoopProcess) {
                tiempo = this.tiempoIte;
                System.out.println("Tipo proceso: L\nId: " + this.id + "\nTiempo de atención: " + tiempo);
            }
            System.out.println("Atendiendo proceso...");
            this.delay(tiempo);
            cola.remove();
            System.out.println("Atendido por Procesador " + this.numeroProcesador(dual));
            System.out.println(ANSI_RED + "Se elimina proceso" + ANSI_RESET + "\nId: " + this.id);
            System.out.println("Total de procesos atendidos " + cola.getTotalProcesses());
        } else {
            System.out.println("Error al agregar en cola");
        }
    }

    private void ejecutarLCFS() {
        LastComeFirstServed pila = new LastComeFirstServed();
        SimpleProcess p = getProceso();
        pila.setTotalProcesses(this.id);
        Double tiempo = 0.0;
        if (p != null) {
            System.out.println(ANSI_GREEN + "Se agrega proceso a cola" + ANSI_RESET);
            pila.add(p);
            if (p instanceof ArithmeticProcess) {
                tiempo = this.tiempoArith;
                System.out.println("Tipo proceso: A\nId: " + this.id + "\nTiempo de atención: " + tiempo);
            } else if (p instanceof ConditionalProcess) {
                tiempo = this.tiempoCond;
                System.out.println("Tipo proceso: C\nId: " + this.id + "\nTiempo de atención: " + tiempo);
            } else if (p instanceof InputOutputProcess) {
                tiempo = this.tiempoIO;
                System.out.println("Tipo proceso: IO\nId: " + this.id + "\nTiempo de atención: " + tiempo);
            } else if (p instanceof LoopProcess) {
                tiempo = this.tiempoIte;
                System.out.println("Tipo proceso: L\nId: " + this.id + "\nTiempo de atención: " + tiempo);
            }
            System.out.println("Atendiendo proceso...");
            this.delay(tiempo);
            pila.remove();
            System.out.println("Atendido por Procesador " + this.numeroProcesador(dual));
            System.out.println(ANSI_RED + "Se elimina proceso" + ANSI_RESET + "\nId: " + this.id);
            System.out.println("Total de procesos atendidos " + pila.getTotalProcesses());
        } else {
            System.out.println("Error al agregar en cola");
        }
    }

    private void ejecutarRR() {
        RoundRobin rr = new RoundRobin();
        SimpleProcess p = this.getProceso();
        Double tiempo = 0.0;
        int numeroVeces = 0;
        //System.out.println("Vacia " + rr.vacia());
        if (rr.vacia()) {
            if (p != null) {
                System.out.println(ANSI_GREEN + "Se agrega proceso a cola" + ANSI_RESET);
                if (p instanceof ArithmeticProcess) {
                    tiempo = this.tiempoArith;
                    System.out.println("Tipo proceso: A\nId: " + this.id + "\nTiempo de atención: " + tiempo);
                    numeroVeces = (int) (this.tiempoArith / this.quantum) - 1;
                    ((ArithmeticProcess) p).setNumeroVeces(numeroVeces);
                } else if (p instanceof ConditionalProcess) {
                    tiempo = this.tiempoCond;
                    System.out.println("Tipo proceso: C\nId: " + this.id + "\nTiempo de atención: " + tiempo);
                    numeroVeces = (int) (this.tiempoCond / this.quantum) - 1;
                    ((ConditionalProcess) p).setNumeroVeces(numeroVeces);
                } else if (p instanceof InputOutputProcess) {
                    tiempo = this.tiempoIO;
                    System.out.println("Tipo proceso: IO\nId: " + this.id + "\nTiempo de atención: " + tiempo);
                    numeroVeces = (int) (this.tiempoIO / this.quantum) - 1;
                    ((InputOutputProcess) p).setNumeroVeces(numeroVeces);
                } else if (p instanceof LoopProcess) {
                    tiempo = this.tiempoIO;
                    System.out.println("Tipo proceso: L\nId: " + this.id + "\nTiempo de atención: " + tiempo);
                    numeroVeces = (int) (this.tiempoIte / this.quantum) - 1;
                    ((LoopProcess) p).setNumeroVeces(numeroVeces);
                }
                rr.add(p);
                aux = rr.next();
                //System.out.println(aux.getId());
            }
        } else {

            System.out.println("Se agrega proceso a cola");
            if (p instanceof ArithmeticProcess) {
                tiempo = this.tiempoArith;
                System.out.println("Tipo proceso: A\nId: " + this.id + "\nTiempo de atención: " + tiempo);
                numeroVeces = (int) (this.tiempoArith / this.quantum) - 1;
                ((ArithmeticProcess) p).setNumeroVeces(numeroVeces);
            } else if (p instanceof ConditionalProcess) {
                tiempo = this.tiempoArith;
                System.out.println("Tipo proceso: C\nId: " + this.id + "\nTiempo de atención: " + tiempo);
                numeroVeces = (int) (this.tiempoCond / this.quantum) - 1;
                ((ConditionalProcess) p).setNumeroVeces(numeroVeces);
            } else if (p instanceof InputOutputProcess) {
                tiempo = this.tiempoArith;
                System.out.println("Tipo proceso: IO\nId: " + this.id + "\nTiempo de atención: " + tiempo);
                numeroVeces = (int) (this.tiempoIO / this.quantum) - 1;
                ((InputOutputProcess) p).setNumeroVeces(numeroVeces);
            } else if (p instanceof LoopProcess) {
                tiempo = this.tiempoArith;
                System.out.println("Tipo proceso: L\nId: " + this.id + "\nTiempo de atención: " + tiempo);
                numeroVeces = (int) (this.tiempoIte / this.quantum) - 1;
                ((LoopProcess) p).setNumeroVeces(numeroVeces);
            }
            aux = rr.next();
            rr.remove();
            rr.add(p);

            if (aux instanceof ArithmeticProcess) {
                if (((ArithmeticProcess) aux).getNumeroVeces() > 0) {
                    System.out.println("Se encola proceso con Id: " + aux.getId() + " de nuevo\nTipo: A\nNumero encolar faltantes " + ((ArithmeticProcess) aux).getNumeroVeces());
                    int numaux = ((ArithmeticProcess) aux).getNumeroVeces();
                    numaux--;
                    ((ArithmeticProcess) aux).setNumeroVeces(numaux);
                    rr.add(aux);
                } else {
                    System.out.println(ANSI_RED + "Se elimina de cola" + ANSI_RESET + "\nTipo proceso: A\nId " + this.id);
                }
            } else if (aux instanceof ConditionalProcess) {
                if (((ConditionalProcess) aux).getNumeroVeces() > 0) {
                    System.out.println("Se encola proceso con Id: " + aux.getId() + " de nuevo\nTipo: C\nNumero encolar faltantes " + ((ArithmeticProcess) aux).getNumeroVeces());
                    int numaux = ((ConditionalProcess) aux).getNumeroVeces();
                    numaux--;
                    ((ConditionalProcess) aux).setNumeroVeces(numaux);
                    rr.add(aux);
                } else {
                    System.out.println("Se elimina de cola\nTipo proceso: C\nId " + this.id);
                }
            } else if (aux instanceof InputOutputProcess) {
                if (((InputOutputProcess) aux).getNumeroVeces() > 0) {
                    System.out.println("Se encola proceso con Id: " + aux.getId() + " de nuevo\nTipo: IO\nNumero encolar faltantes " + ((ArithmeticProcess) aux).getNumeroVeces());
                    int numaux = ((InputOutputProcess) aux).getNumeroVeces();
                    numaux--;
                    ((InputOutputProcess) aux).setNumeroVeces(numaux);
                    rr.add(aux);
                } else {
                    System.out.println("Se elimina de cola\nTipo proceso: IO\nId " + this.id);
                }
            } else if (aux instanceof LoopProcess) {
                if (((LoopProcess) aux).getNumeroVeces() > 0) {
                    System.out.println("Se encola proceso con Id: " + aux.getId() + " de nuevo\nTipo: L\nNumero encolar faltantes " + ((ArithmeticProcess) aux).getNumeroVeces());
                    int numaux = ((LoopProcess) aux).getNumeroVeces();
                    numaux--;
                    ((LoopProcess) aux).setNumeroVeces(numaux);
                    rr.add(aux);
                } else {
                    System.out.println("Se elimina de cola\nTipo proceso: L\nId " + this.id);
                }
            }

            //System.out.println("Else");
        }

    }

    private void ejecutarPP() {
        PriorityPolicy prioridad1 = new PriorityPolicy();
        PriorityPolicy prioridad2 = new PriorityPolicy();
        PriorityPolicy prioridad3 = new PriorityPolicy();
        PriorityPolicy prioridad4 = new PriorityPolicy();
        Double tiempo = 0.0;
        for (int i = 0; i < 4; i++) {
            SimpleProcess p = getProceso();
            if (p != null) {
                System.out.println(ANSI_GREEN + "Se agrega proceso a cola" + ANSI_RESET);
                if (p instanceof ArithmeticProcess) {
                    tiempo = this.tiempoArith;
                    System.out.println("Prioridad 1\nTipo: A\nId: " + this.id + "\nTiempo atención: " + tiempo);
                    prioridad1.add(p);
                } else if (p instanceof ConditionalProcess) {
                    tiempo = this.tiempoCond;
                    System.out.println("Prioridad 2\nTipo: C\nId: " + this.id + "\nTiempo atención: " + tiempo);
                    prioridad2.add(p);
                } else if (p instanceof InputOutputProcess) {
                    tiempo = this.tiempoIO;
                    System.out.println("Prioridad 3\nTipo: IO\nId: " + this.id + "\nTiempo atención: " + tiempo);
                    prioridad3.add(p);
                } else if (p instanceof LoopProcess) {
                    tiempo = this.tiempoIte;
                    System.out.println("Prioridad 4\nTipo: L\nId: " + this.id + "\nTiempo atención: " + tiempo);
                    prioridad4.add(p);
                }
            } else {
                System.out.println("Error al agregar en cola");
            }
        }
        System.out.println(ANSI_YELLOW + "Atendiendo procesos por prioridad\nPrioridad 1: A\nPrioridad 2: C\nPrioridad 3: IO\nPrioridad 4: L" + ANSI_RESET);
        int i = 0;
        if (!prioridad1.vacia()) {
            i = prioridad1.tama();
            for (int ii = 0; ii < i; ii++) {
                SimpleProcess aux = prioridad1.next();
                if (aux instanceof ArithmeticProcess) {
                    tiempo = this.tiempoArith;
                    System.out.println("Tipo: A\nId: " + aux.getId());
                    System.out.println("Atendiendo...");
                    this.delay(tiempo);
                    System.out.println(ANSI_RED + "Se proceso elimina de cola" + ANSI_RESET + "\nTipo: A\nId " + aux.getId());
                }
            }
        } else {
            System.out.println(ANSI_YELLOW + "Cola prioridad 1 no tiene procesos" + ANSI_RESET);
        }
        if (!prioridad2.vacia()) {
            i = prioridad2.tama();
            for (int ii = 0; ii < i; ii++) {
                SimpleProcess aux = prioridad2.next();
                if (aux instanceof ConditionalProcess) {
                    tiempo = this.tiempoCond;
                    System.out.println("Tipo: C\nId: " + aux.getId());
                    System.out.println("Atendiendo...");
                    this.delay(tiempo);
                    System.out.println(ANSI_RED + "Se proceso elimina de cola" + ANSI_RESET + "\nTipo: C\nId " + aux.getId());
                }
            }
        } else {
            System.out.println(ANSI_YELLOW + "Cola prioridad 2 no tiene procesos" + ANSI_RESET);
        }
        if (!prioridad3.vacia()) {
            i = prioridad3.tama();
            for (int ii = 0; ii < i; ii++) {
                SimpleProcess aux = prioridad3.next();
                if (aux instanceof InputOutputProcess) {
                    tiempo = this.tiempoCond;
                    System.out.println("Tipo: IO\nId: " + aux.getId());
                    System.out.println("Atendiendo...");
                    this.delay(tiempo);
                    System.out.println(ANSI_RED + "Se proceso elimina de cola" + ANSI_RESET + "\nTipo: IO\nId " + aux.getId());
                }
            }
        } else {
            System.out.println(ANSI_YELLOW + "Cola prioridad 3 no tiene procesos" + ANSI_RESET);
        }
        if (!prioridad4.vacia()) {
            i = prioridad4.tama();
            for (int ii = 0; ii < i; ii++) {
                SimpleProcess aux = prioridad4.next();
                if (aux instanceof LoopProcess) {
                    tiempo = this.tiempoCond;
                    System.out.println("Tipo: L\nId: " + aux.getId());
                    System.out.println("Atendiendo...");
                    this.delay(tiempo);
                    System.out.println(ANSI_RED + "Se proceso elimina de cola" + ANSI_RESET + "\nTipo: L\nId " + aux.getId());
                }
            }
        } else {
            System.out.println(ANSI_YELLOW + "Cola prioridad  no tiene procesos" + ANSI_RESET);
        }

    }

    private int tipoProceso() {
        Random r = new Random();
        return r.nextInt(4) + 1;
    }

    private SimpleProcess getProceso() {
        SimpleProcess p = null;
        switch (tipoProceso()) {
            case 1:
                this.id++;
                //ArithmeticProcess a = new ArithmeticProcess(this.id);
                p = new ArithmeticProcess(this.id);
                break;
            case 2:
                this.id++;
                p = new ConditionalProcess(this.id);
                break;
            case 3:
                this.id++;
                p = new InputOutputProcess(this.id);
                break;
            case 4:
                this.id++;
                p = new LoopProcess(this.id);
                break;
        }
        return p;
    }

    private void delayEntrada() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Si desea salir presione la letra \"q\"");
        String op = sc.next();
        if (op.equals("q") || op.equals("Q")) {
            System.out.println(ANSI_GREEN + "Adios!!" + ANSI_RESET);
            System.exit(0);
        } else {
            Random t = new Random();
            Double aux = tiempoF - tiempoI;
            double number = t.nextDouble(aux) + tiempoI;
            System.out.println("Esperando para siguiente entrada de Proceso... tiempo " + number);
            this.delay(number);
        }
    }

    private void delay(Double tiempo) {
        try {
            Thread.sleep((long) (tiempo * 1000));
        } catch (Exception ex) {
            System.out.println("Error " + ex);
        }
    }

    private int numeroProcesador(boolean dual) {
        int numero = 0;
        Random r = new Random();
        if (!dual) {
            numero = 1;
        } else {
            numero = r.nextInt(2) + 1;
        }
        return numero;
    }

}
