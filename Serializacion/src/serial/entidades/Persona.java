package serial.entidades;

import  lombok.Getter;
import  lombok.Setter;
import java.io.Serializable;


public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Getter @Setter private String nombre;
    @Getter @Setter private String fechaNacimiento;

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    @Getter @Setter private String direccion;



}
