package hilos.test;

import hilos.clase.*;
import hilos.clase.FormularioAuto;

public class Test {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNombre("Josue");
        p.setFechadeNacimeinto("2004-11-12");
        p.setDireccion("Calle gotitas del saber");

        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Fecha de nacimiento: " + p.getFechadeNacimeinto());
        System.out.println("Dirección: " + p.getDireccion());


        ProcesoA a = new ProcesoA("Josue");
        ProcesoB b = new ProcesoB(10);
        ProcesoC c = new ProcesoC(5);
        ProcesoD x = new ProcesoD(50);
        Thread d = new Thread(x);

        ProcesoE y = new ProcesoE("Hola Como estas");
        Thread e = new Thread(y);

        FormularioAuto vistaAuto = new FormularioAuto();
        ProcesoF procesoF = new ProcesoF(vistaAuto);
        Thread prosf = new Thread(procesoF);
        prosf.start();
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }
}
/* cambios en los archivos para subir*/