/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Nicolas
 */
public class Peliculas {

    Random random = new Random();

    public Peliculas() {

    }

    private int[][] peliculas = new int[7][15];

    public void llenarMatrizPeliculas() {
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 15; ++j) {

                peliculas[i][j] = random.nextInt(0, 460);

            }

        }
    }

    public void imprimirMatriz() {
        
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 15; ++j) {

                System.out.print(peliculas[i][j] + "\t");

            }
            System.out.println(" ");

        }

    }

}
