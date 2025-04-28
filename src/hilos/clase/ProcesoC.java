package hilos.clase;

public class ProcesoC extends Thread{
    private int n;
    //Constructor
    public ProcesoC(int n) {
        this.n = n;
    }

    public void dividir(int  n) {
        System.out.println("-- Proceso C --");
        for (double i = 10; i > -1; i--){
            System.out.println(n/i);
        }
        System.out.println("\n");
    }
    @Override
    public void run() {
        dividir(n);
    }

}
