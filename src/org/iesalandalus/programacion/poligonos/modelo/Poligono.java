package org.iesalandalus.programacion.poligonos.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Poligono implements Desplazable, Trazable {
    private float lado;
    private List<Punto> trayectoria;
    private Punto centro;

    protected Poligono(Punto centro, float lado) {
        Objects.requireNonNull(centro, "El centro no puede ser nulo.");
        trayectoria = new ArrayList<>();
        this.centro = centro;
        trayectoria.add(new Punto(centro));
        this.lado = lado;
    }

    public float getLado() {
        return lado;
    }

    @Override
    public List<Punto> getTrayectoria() {
        return new ArrayList<>(trayectoria);
    }

    public Punto getCentro() {
        return centro;
    }

    @Override
    public void desplazar(float incrementoX, float incrementoY) {
        centro.desplazar(incrementoX, incrementoY);
        trayectoria.add(new Punto(getCentro()));
    }

    public abstract List<Punto> getVertices();

    public abstract float getArea();

    public abstract float getPerimetro();

    @Override
    public String toString() {
        return String.format("Centro: %s, Lado: %2.2f, Área: %2.2f, Perímetro: %2.2f, Vértices: %s", this.centro, this.lado, getArea(), getPerimetro(), getVertices());
    }
}
