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
    
    public int[][] peliculas;
    
    // Pasarle en el constructor la lista rellenada de una vez, para no crear metodos para rellenarla

    public Peliculas() {
        
         peliculas = new int[7][16];
         
         for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 16; ++j) {

                // Teniendo en cuenta que en promedio en una sala de cine hay 450 asientos
                peliculas[i][j] = (int) (Math.random() * 450 + 150);

            }

        }

    }

    

    public void imprimirMatriz() {

        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 16; ++j) {

                System.out.print(peliculas[i][j] + "\t");

            }
            System.out.println(" ");

        }

    }
    
    public int[][] obtenerMatriz(){
        return peliculas;
    }

}
