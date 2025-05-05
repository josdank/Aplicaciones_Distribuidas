package hilos.clase;

public class ProcesoD implements Runnable{
    //Constructor

    private int n;
    public ProcesoD(int n) {
        this.n = n;
    }
    public void dibujar( int n) {
        for (int i = 0; i <= n; i++) {
            System.out.print("**********");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

    @Override
    public void run() {
        System.out.println("-- Proceso D --");
        dibujar(n);
    }
}