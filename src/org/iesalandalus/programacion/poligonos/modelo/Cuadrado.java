package org.iesalandalus.programacion.poligonos.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cuadrado extends Poligono {
    public Cuadrado(Punto centro, float lado) {
        super(centro, lado);
    }

    @Override
    public List<Punto> getVertices() {
        Punto VerticeII = new Punto((getCentro().getX() - (getLado() / 2)), (getCentro().getY() - (getLado() / 2)));
        Punto VerticeID = new Punto((getCentro().getX() + (getLado() / 2)), (getCentro().getY() - (getLado() / 2)));
        Punto VerticeSI = new Punto((getCentro().getX() - (getLado() / 2)), (getCentro().getY() + (getLado() / 2)));
        Punto VerticeSD = new Punto((getCentro().getX() + (getLado() / 2)), (getCentro().getY() + (getLado() / 2)));
        List<Punto> coleccionVertices = new ArrayList<>();
        coleccionVertices.add(VerticeII);
        coleccionVertices.add(VerticeID);
        coleccionVertices.add(VerticeSI);
        coleccionVertices.add(VerticeSD);
        return coleccionVertices;
    }

    @Override
    public float getArea() {
        return (float) Math.pow(getLado(), 2);
    }

    @Override
    public float getPerimetro() {
        return (4 * getLado());
    }
}
