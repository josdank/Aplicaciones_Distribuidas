package clases.redimension;

import javax.swing.*;
import java.awt.*;

public class redimensiongifs {
    public static ImageIcon redimensionarImagen(String ruta, int ancho, int alto) {
        ImageIcon imagenOriginal = new ImageIcon(ruta);
        Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
        return new ImageIcon(imagenEscalada);
    }
}
