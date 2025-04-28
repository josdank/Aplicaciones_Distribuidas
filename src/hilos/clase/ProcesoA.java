package hilos.clase;

public class ProcesoA extends Thread{
    //Constructor
    private String name;
    public ProcesoA(String name) {
        this.name = name;
    }
    public void saludar(String name) {
        System.out.println("Hola " + name);
        System.out.println("\n");
    }

    @Override
    public void run() {
        System.out.println("--Proceso A--");
        saludar(name);
    }
}
