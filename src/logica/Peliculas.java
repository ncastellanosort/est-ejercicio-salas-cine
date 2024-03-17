/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nicolas
 */
public class Peliculas {

    public int[][] peliculas = new int[7][15];

    public Peliculas() {

    }

    public int[][] obtenerMatriz() {
        return peliculas;
    }

    public void imprimirMatriz() {

        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 15; ++j) {

                System.out.print(peliculas[i][j] + "\t");

            }
            System.out.println(" ");

        }

    }

    public int[][] llenarMatriz() {

        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 15; ++j) {

                // Teniendo en cuenta que en promedio en una sala de cine hay 450 asientos
                peliculas[i][j] = (int) (Math.random() * 450 + 150);

            }

        }

        return peliculas;

    }

    public ArrayList<Integer> encontrarMaximosPorFila() {
        ArrayList<Integer> maximosPorFila = new ArrayList<>();
        for (int i = 0; i < 7; ++i) {
            int maximo = peliculas[i][0]; // Inicializamos el máximo como el primer elemento de la fila
            for (int j = 1; j < 15; ++j) {
                if (peliculas[i][j] > maximo) {
                    maximo = peliculas[i][j];
                }
            }
            maximosPorFila.add(maximo); // Agregamos el máximo de la fila a la lista
        }
        return maximosPorFila;
    }

}
