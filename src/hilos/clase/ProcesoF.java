package hilos.clase;

public class ProcesoF implements Runnable {
    public FormularioAuto vistaAuto;
    // Constructor para recibir la instancia de FormularioAuto
    public ProcesoF(FormularioAuto vistaAuto) {
        this.vistaAuto = vistaAuto;
    }

    @Override
    public void run() {
        System.out.println("-- Proceso E --");
        vistaAuto.run();
    }
}
