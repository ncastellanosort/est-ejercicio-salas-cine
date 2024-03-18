/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;


/**
 *
 * @author Nicolas
 */
public class Peliculas {

    public int[][] peliculas = new int[7][15];


    public int[][] obtenerMatriz() {
        return peliculas;
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


}
