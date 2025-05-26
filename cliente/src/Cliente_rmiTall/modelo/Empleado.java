package Cliente_rmiTall.modelo;

import java.io.Serializable;

public class Empleado implements Serializable {
    private int id;
    private String nombre;
    private String puesto;

    public Empleado(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }
}
