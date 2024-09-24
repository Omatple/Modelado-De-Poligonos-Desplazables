package org.iesalandalus.programacion.poligonos;

import org.iesalandalus.programacion.poligonos.modelo.Cuadrado;
import org.iesalandalus.programacion.poligonos.modelo.Poligono;
import org.iesalandalus.programacion.poligonos.modelo.Punto;
import org.iesalandalus.programacion.poligonos.modelo.Triangulo;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final float LIMITE_PUNTOS = 100F;
    private static final float LIMITE_LADOS = 10F;
    private static final float LIMITE_INCREMENTOS = 50F;
    private static final Random generador = new Random();

    public static void main(String[] args) {
        List<Poligono> coleccionPoligonos = generarPoligonos();
        desplazarPoligonos(coleccionPoligonos);
        mostrarPoligonos(coleccionPoligonos);
    }

    private static List<Poligono> generarPoligonos() {
        List<Poligono> coleccionPoligonos = new ArrayList<>();
        Triangulo triangulo = new Triangulo(generarPunto(), generarLado());
        Cuadrado cuadrado = new Cuadrado(generarPunto(), generarLado());
        coleccionPoligonos.add(triangulo);
        coleccionPoligonos.add(cuadrado);
        return coleccionPoligonos;
    }

    private static Punto generarPunto() {
        float randomX = generador.nextFloat((LIMITE_PUNTOS / 2) + 1);
        int negativoPositivoX = generador.nextInt(2);
        randomX = (negativoPositivoX == 1) ? (randomX) : ((randomX) * (-1));
        float randomY = generador.nextFloat((LIMITE_PUNTOS / 2) + 1);
        int negativoPositivoY = generador.nextInt(2);
        randomY = (negativoPositivoY == 1) ? (randomY) : ((randomY) * (-1));
        return new Punto(randomX, randomY);
    }

    private static float generarLado() {
        return generador.nextFloat(LIMITE_LADOS + 1);
    }

    private static void desplazarPoligonos(List<Poligono> poligonos) {
        int vecesDesplazar = leerVeces();
        for (int i = 0; i < vecesDesplazar; i++) {
            for (Poligono poligono : poligonos) {
                poligono.desplazar(generarIncremento(), generarIncremento());
            }
        }
    }

    private static int leerVeces() {
        System.out.print("Cuantas veces quieres desplazarlos: ");
        int numVeces = Entrada.entero();
        while (numVeces < 2) {
            System.out.println("ERROR: El número de veces debe ser mayor o igual que 2. Inténtelo de nuevo.");
            System.out.print("Cuantas veces quieres desplazarlos: ");
            numVeces = Entrada.entero();
        }
        return numVeces;
    }

    private static float generarIncremento() {
        float randomIncremento = generador.nextFloat((LIMITE_INCREMENTOS / 2) + 1);
        int negativoPositivoIncremento = generador.nextInt(2);
        return (negativoPositivoIncremento == 1) ? randomIncremento : ((randomIncremento) * (-1));
    }

    private static void mostrarPoligonos(List<Poligono> poligonos) {
        for (Poligono poligono : poligonos) {
            if (poligono instanceof Triangulo triangulo) {
                System.out.printf("Triángulo -> %s%n       Trayectoria -> %s%n", triangulo, triangulo.getTrayectoria());
            } else if (poligono instanceof Cuadrado cuadrado) {
                System.out.printf("Cuadrado -> %s%n       Trayectoria -> %s%n", cuadrado, cuadrado.getTrayectoria());
            }
        }
    }
}