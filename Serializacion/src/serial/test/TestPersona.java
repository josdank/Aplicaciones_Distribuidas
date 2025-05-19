package serial.test;
import serial.entidades.Persona;
import serial.servicios.Servicio;

import java.util.ArrayList;
import java.util.List;

public class TestPersona {

    public static void main(String[] args)  throws Exception {
        Persona p1 = new Persona();
        p1.setNombre("Josué Guerra");
        p1.setFechaNacimiento("12 de noviembre de 2004");
        p1.setDireccion("Quito Rosario Borja");

        Persona p2 = new Persona();
        p2.setNombre("Eduard Lovato");
        p2.setFechaNacimiento("12 de octubre de 2003");
        p2.setDireccion("Quito-Qitumbe");

        Persona p3 = new Persona();
        p3.setNombre("Ana Zambrano");
        p3.setFechaNacimiento("25 de abril de 2004");
        p3.setDireccion("Iñaquito");
        Persona[] lista = {p1, p2, p3};

        Servicio servicio = new Servicio();

        servicio.escribir(List.of(lista), "C:/Users/APP DISTRIBUIDAS/Documents/App_Dsitribuidas_Josue/Aplicaciones_Distribuidas/Serializacion/src/serial/test/personasList.dat");

        System.out.println(servicio.leer("C:/Users/APP DISTRIBUIDAS/Documents/App_Dsitribuidas_Josue/Aplicaciones_Distribuidas/Serializacion/src/serial/test/personasList.dat"));
    }
}
