package hilos.clase;

public class ProcesoF implements Runnable {
    private VistaAuto vistaAuto;

    // Constructor para recibir la instancia de VistaAuto
    public ProcesoF(VistaAuto vistaAuto) {
        this.vistaAuto = vistaAuto;
    }

    @Override
    public void run() {
        // Llamamos a la vista de la ventana desde el hilo de ProcesoD
        vistaAuto.VistaAutoP.setVisible(true);
    }
}
