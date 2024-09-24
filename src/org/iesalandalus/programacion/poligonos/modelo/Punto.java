package org.iesalandalus.programacion.poligonos.modelo;

import java.util.Objects;

public class Punto implements Desplazable {
    private float x;
    private float y;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Punto(Punto punto) {
        Objects.requireNonNull(punto, "No se puede hacer una copia de un punto nulo");
        this.x = punto.getX();
        this.y = punto.getY();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public void desplazar(float incrementoX, float incrementoY) {
        x += incrementoX;
        y += incrementoY;
    }

    @Override
    public String toString() {
        return String.format("(%2.2f, %2.2f)", this.x, this.y);
    }
}
