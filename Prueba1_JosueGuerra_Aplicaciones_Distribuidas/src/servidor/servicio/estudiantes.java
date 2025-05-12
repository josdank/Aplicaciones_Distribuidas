package servidor.servicio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class estudiantes {
    private int id;
    private String nombre;
    private String teléfono;
    private String carrera;
    private int semestre;
    private boolean gratuidad;
}
