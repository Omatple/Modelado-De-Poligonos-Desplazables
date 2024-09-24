package org.iesalandalus.programacion.poligonos.modelo;

import java.util.ArrayList;
import java.util.List;

public class Triangulo extends Poligono {
    public Triangulo(Punto centro, float lado) {
        super(centro, lado);
    }

    @Override
    public List<Punto> getVertices() {
        float ap = (float) ((Math.sqrt(3) / 6) * (getLado()));
        float r = (float) ((getLado()) / (Math.sqrt(3)));
        Punto VerticeII = new Punto((getCentro().getX() - (getLado() / 2)), (getCentro().getY() - ap));
        Punto VerticeID = new Punto((getCentro().getX() + (getLado() / 2)), (getCentro().getY() - ap));
        Punto VerticeS = new Punto((getCentro().getX()), (getCentro().getY() + r));
        List<Punto> coleccionVertices = new ArrayList<>();
        coleccionVertices.add(VerticeII);
        coleccionVertices.add(VerticeID);
        coleccionVertices.add(VerticeS);
        return coleccionVertices;
    }

    @Override
    public float getArea() {
        return (float) ((Math.sqrt(3) / 4) * (Math.pow(getLado(), 2)));
    }

    @Override
    public float getPerimetro() {
        return (3 * getLado());
    }
}
