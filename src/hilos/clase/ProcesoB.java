package hilos.clase;

public class ProcesoB extends Thread{
    //Constructor

    private int n;
    public ProcesoB(int n) {
        this.n = n;
    }
    public void contar( int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Iteración N.- " + i);
        }
        System.out.println("\n");
    }

    @Override
    public void run() {
        System.out.println("-- Proceso B --");
        contar(n);
    }
}
