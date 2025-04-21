package clase.impl;

import clase.interfaz.Operaciones;

public class OperacionesImpl implements Operaciones {

    @Override
    public double sumar(double x, double y) {
        return x+y;
    }

    @Override
    public double resta(double x, double y) {
        return x-y;
    }

    @Override
    public double multiplicacion(double x, double y) {
        return x*y;
    }

    @Override
    public double division(double x, double y) {
        return x/y;
    }
}
