/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import logica.Peliculas;

/**
 *
 * @author Nicolas
 */
public class Pantalla extends javax.swing.JFrame {

    /**
     * Creates new form Pantalla
     */
    DefaultTableModel modeloTablaPeliculas = new DefaultTableModel();

    //------------------------LISTA SALAS---------------------------
    DefaultTableModel modeloTablaSalas1 = new DefaultTableModel();
    DefaultTableModel modeloTablaSalas2 = new DefaultTableModel();
    DefaultTableModel modeloTablaSalas3 = new DefaultTableModel();

    //------------------------MATRIZ PELICULAS---------------------------
    Peliculas peliculas = new Peliculas();

    int[][] matrizPeliculas = peliculas.llenarMatriz();

    // ------------------MAS VISTAS----------------------------
    DefaultTableModel modeloTablaPeliculaMasVista = new DefaultTableModel();

    int[] masVistas = peliculasMasVistasPorFila();

    // MAS VISTAS NOMBRE
    DefaultTableModel modeloTablaNombrePeliculaMasVista = new DefaultTableModel();

    // -------------------MENOS VISTAS---------------------------
    DefaultTableModel modeloTablaPeliculaMenosVista = new DefaultTableModel();

    DefaultTableModel modeloTablaNombrePeliculaMenosVista = new DefaultTableModel();

    int[] menosVistas = peliculasMenosVistasPorFila();

    public Pantalla() {
        initComponents();

        String[] salas = new String[7];

        for (int i = 0; i < salas.length; ++i) {
            salas[i] = "Sala " + (i + 1);

        }

        // Tabla salas 1
        tablaSalas1.setRowHeight(35);

        for (int i = 0; i < 1; i++) {
            modeloTablaSalas1.addRow(new String[7]);
        }

        for (int i = 0; i < tablaSalas1.getRowCount(); ++i) {

            for (int j = 0; j < tablaSalas1.getColumnCount(); ++j) {

                // Llenarlo comn los valores de la matriz
                tablaSalas1.setValueAt(salas[i], i, j);

            }
        }

        // Tabla salas 2
        tablaSalas2.setRowHeight(35);

        for (int i = 0; i < 1; i++) {
            modeloTablaSalas2.addRow(new String[7]);
        }

        for (int i = 0; i < tablaSalas2.getRowCount(); ++i) {

            for (int j = 0; j < tablaSalas2.getColumnCount(); ++j) {

                // Llenarlo comn los valores de la matriz
                tablaSalas2.setValueAt(salas[i], i, j);

            }
        }

        // Tabla salas 3
        tablaSalas3.setRowHeight(35);

        for (int i = 0; i < 1; i++) {
            modeloTablaSalas3.addRow(new String[7]);
        }

        for (int i = 0; i < tablaSalas3.getRowCount(); ++i) {

            for (int j = 0; j < tablaSalas3.getColumnCount(); ++j) {

                // Llenarlo comn los valores de la matriz
                tablaSalas3.setValueAt(salas[i], i, j);

            }
        }

        String[] peliculas = new String[15];

        for (int i = 0; i < peliculas.length; ++i) {
            peliculas[i] = "Pelicula " + (i + 1);

        }

        modeloTablaPeliculas.setColumnIdentifiers(peliculas);

        tablaPeliculas.setModel(modeloTablaPeliculas);
        tablaPeliculas.setRowHeight(35);

        // 7 filas
        // Por cada fila va a agregar 15 columnas
        for (int i = 0; i < 7; i++) {
            modeloTablaPeliculas.addRow(new Integer[15]);
        }

        llenarTablaPeliculas();

        // -----------------MAS VISTAS--------------------- 
        tablaPeliculasMasVistas.setRowHeight(35);

        for (int i = 0; i < 1; i++) {
            modeloTablaPeliculaMasVista.addRow(new Integer[7]);
        }

        llenarTablaPeliculaMasVistas();

        // ----------------------------------------------------------------
        // -----------------MENOS VISTAS---------------------
        tablaPeliculasMenosVistas.setRowHeight(35);

        for (int i = 0; i < 1; i++) {
            modeloTablaPeliculaMenosVista.addRow(new Integer[7]);
        }

        llenarTablaPeliculaMenosVistas();

        // ----------------------------------------------------------------
        // ---------------------MAS VISTAS TITULO------------------------------
        String[] masVistastitulo = new String[7];
        obtenerNombrePeliculaMasVistas(masVistastitulo);
//
//        for (int i = 0; i < masVistastitulo.length; ++i) {
//            System.out.println(masVistastitulo[i]);
//        }

        tablaNombrePeliculasMasVistas.setRowHeight(35);

        for (int i = 0; i < 1; i++) {
            modeloTablaNombrePeliculaMasVista.addRow(new String[7]);
        }

        for (int i = 0; i < tablaNombrePeliculasMasVistas.getRowCount(); ++i) {

            for (int j = 0; j < tablaNombrePeliculasMasVistas.getColumnCount(); ++j) {

                // Llenarlo comn los valores de la matriz
                tablaNombrePeliculasMasVistas.setValueAt(masVistastitulo[i], i, j);

            }
        }

        // ----------------------------------------------------------------
        // ---------------------MENOS VISTAS TITULO------------------------------
        String[] menosVistastitulo = new String[7];
        obtenerNombrePeliculaMenosVistas(menosVistastitulo);

//        for (int i = 0; i < menosVistastitulo.length; ++i) {
//            System.out.println(menosVistastitulo[i]);
//        }
        tablaNombrePeliculasMenosVistas.setRowHeight(35);

        for (int i = 0; i < 1; i++) {
            modeloTablaNombrePeliculaMenosVista.addRow(new String[7]);
        }

        for (int i = 0; i < tablaNombrePeliculasMenosVistas.getRowCount(); ++i) {

            for (int j = 0; j < tablaNombrePeliculasMenosVistas.getColumnCount(); ++j) {

                // Llenarlo comn los valores de la matriz
                tablaNombrePeliculasMenosVistas.setValueAt(menosVistastitulo[i], i, j);

            }
        }

        // ----------------------------------------------------------------
        // ----------------COMBINACION MEJOR SALA-PELICULA---------------------
        // encontrar el indice de la fila donde esta el  elemento
        int filaIndice = 0;

        int[] masVistasEspectadoresCombinacion = peliculasMasVistasPorFila();
        Arrays.sort(masVistasEspectadoresCombinacion);

        // valor mayor de espectadores, es el ultimo de la lista ordenada
        int mayor = masVistasEspectadoresCombinacion[masVistasEspectadoresCombinacion.length - 1];

        for (int i = 0; i < tablaPeliculas.getRowCount(); ++i) {

            for (int j = 0; j < tablaPeliculas.getColumnCount(); ++j) {

                int value = (int) tablaPeliculas.getValueAt(i, j);

//                System.out.print(value + "\t");
                if (value == mayor) {

                    // va a ser i(filas), hasta que lo encuentre
                    filaIndice = i;

                    System.out.println(filaIndice);

                    // +1 para que no coja el cero
                    lbNumeroSalaCombinacion.setText("Sala " + Integer.toString(filaIndice + 1));

                    // el indice de la columna donde esta el valor mayor
                    lbNumeroPeliculaCombinacion.setText(tablaPeliculas.getColumnName(j));

                    // el valor que es igual al mayor
                    lbNumeroEspectadoresCombiacion.setText(Integer.toString(value));

                }

            }

        }

    }

    // -------------------------FUNCIONES-------------------------------------
    // ----------------LLENAR LA TABLA DE PELICULAS-------------------------
    public void llenarTablaPeliculas() {

        for (int i = 0; i < tablaPeliculas.getRowCount(); ++i) {

            for (int j = 0; j < tablaPeliculas.getColumnCount(); ++j) {

                // Llenarlo con los valores de la matriz
                tablaPeliculas.setValueAt(matrizPeliculas[i][j], i, j);

            }
        }
    }

    // --------------------NOMBRE PELICULAS MAS VISTAS-------------------------------------
    public void obtenerNombrePeliculaMasVistas(String[] listaPelis) {

        for (int i = 0; i < tablaPeliculas.getRowCount(); ++i) {

            int ms = (int) tablaPeliculas.getValueAt(i, 0);

            int indiceColumnIdentifier = 0;

//            System.out.println("\nIndice fila: " + ms); // coje solo el indice del primer elemento de la fila
            for (int j = 0; j < tablaPeliculas.getColumnCount(); ++j) {

                int value = (int) tablaPeliculas.getValueAt(i, j);

//                System.out.println("Valores de la fila: " + value); // trae todos los valores de las columnas de esa fila
                if (value > ms) {
                    ms = (int) tablaPeliculas.getValueAt(i, j);
                    indiceColumnIdentifier = j;

                }

            }

            listaPelis[i] = tablaPeliculas.getColumnName(indiceColumnIdentifier);

        }

    }

    // --------------------NOMBRE PELICULAS MENOS VISTAS-------------------------------------
    public void obtenerNombrePeliculaMenosVistas(String[] listaPelis) {

        for (int i = 0; i < tablaPeliculas.getRowCount(); ++i) {

            int ms = (int) tablaPeliculas.getValueAt(i, 0);

            int indiceColumnIdentifier = 0;

//            System.out.println("\nIndice fila: " + ms); // coje solo el indice del primer elemento de la fila
            for (int j = 0; j < tablaPeliculas.getColumnCount(); ++j) {

                int value = (int) tablaPeliculas.getValueAt(i, j);

//                System.out.println("Valores de la fila: " + value); // trae todos los valores de las columnas de esa fila
                if (value < ms) {
                    ms = (int) tablaPeliculas.getValueAt(i, j);
                    indiceColumnIdentifier = j;

                }

            }

            listaPelis[i] = tablaPeliculas.getColumnName(indiceColumnIdentifier);

        }

    }

    // --------------------PELICULAS MAS VISTAS------------------
    public void llenarTablaPeliculaMasVistas() {

        for (int i = 0; i < tablaPeliculasMasVistas.getRowCount(); ++i) {

            for (int j = 0; j < tablaPeliculasMasVistas.getColumnCount(); ++j) {

                // Llenarlo comn los valores de la matriz
                tablaPeliculasMasVistas.setValueAt(masVistas[i], i, j);

            }
        }
    }

    // --------------------PELICULAS MENOS VISTAS------------------
    public void llenarTablaPeliculaMenosVistas() {

        for (int i = 0; i < tablaPeliculasMenosVistas.getRowCount(); ++i) {

            for (int j = 0; j < tablaPeliculasMenosVistas.getColumnCount(); ++j) {

                // Llenarlo comn los valores de la matriz
                tablaPeliculasMenosVistas.setValueAt(menosVistas[i], i, j);

            }
        }
    }

    // -----------------LISTA CON PELICULAS CON MAS ESPECTADORES-------------------
    public int[] peliculasMasVistasPorFila() {

        // ArrayList donde van a estar todos los valores de las peliculas con mas vistas
        int[] masVistas = new int[7];

        for (int i = 0; i < 7; ++i) {

            // Variable temporal que va a tener siempre la primera posicion de la fila y se va a comparar con toda la columna
            int mayor = matrizPeliculas[i][0];

            for (int j = 0; j < 15; ++j) {

                // Comparacion para ver si el elemento de la fila es mayor que la variable temporal que se creo arriba 
                if (matrizPeliculas[i][j] > mayor) {

                    // Si es verdadero la variable mayor va a ser ahora el elemento mayor de la fila
                    mayor = matrizPeliculas[i][j];
                }

            }

            // Lo agrega
            masVistas[i] = mayor;
        }

        return masVistas;

    }

    // -----------------LISTA CON PELICULAS CON MENOS ESPECTADORES-------------------
    public int[] peliculasMenosVistasPorFila() {

        int[] menosVistas = new int[7];

        for (int i = 0; i < 7; ++i) {

            int menor = matrizPeliculas[i][0];

            for (int j = 0; j < 15; ++j) {

                if (matrizPeliculas[i][j] < menor) {

                    menor = matrizPeliculas[i][j];
                }

            }

            menosVistas[i] = menor;
        }

        return menosVistas;

    }

    // -------------------------------------------------------------------------
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPeliculas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPeliculasMenosVistas = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaPeliculasMasVistas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaNombrePeliculasMasVistas = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaNombrePeliculasMenosVistas = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaSalas1 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaSalas2 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaSalas3 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lbNumeroPeliculaCombinacion = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbNumeroSalaCombinacion = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbNumeroEspectadoresCombiacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(24, 24, 24));

        tablaPeliculas.setBackground(new java.awt.Color(255, 255, 102));
        tablaPeliculas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablaPeliculas.setForeground(new java.awt.Color(0, 0, 0));
        tablaPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaPeliculas.setFocusable(false);
        tablaPeliculas.setGridColor(new java.awt.Color(0, 0, 0));
        tablaPeliculas.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tablaPeliculas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(tablaPeliculas);

        jLabel1.setBackground(new java.awt.Color(0, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("CINEMAX");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("# Personas");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("que asistieron");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("a ver la pelicula");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 102));
        jLabel5.setText("Pelicula mas vista de todas las salas");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 102));
        jLabel6.setText("Pelicula menos vista de todas las salas");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 102));
        jLabel15.setText("Combinacion sala-pelicula mas vista");

        tablaPeliculasMenosVistas.setBackground(new java.awt.Color(255, 255, 102));
        tablaPeliculasMenosVistas.setForeground(new java.awt.Color(0, 0, 0));
        tablaPeliculasMenosVistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "N. Personas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPeliculasMenosVistas.setGridColor(new java.awt.Color(0, 0, 0));
        tablaPeliculasMenosVistas.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tablaPeliculasMenosVistas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaPeliculasMenosVistas);
        if (tablaPeliculasMenosVistas.getColumnModel().getColumnCount() > 0) {
            tablaPeliculasMenosVistas.getColumnModel().getColumn(0).setResizable(false);
        }

        tablaPeliculasMasVistas.setBackground(new java.awt.Color(255, 255, 102));
        tablaPeliculasMasVistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "N. Personas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPeliculasMasVistas.setGridColor(new java.awt.Color(0, 0, 0));
        tablaPeliculasMasVistas.setSelectionBackground(new java.awt.Color(255, 153, 51));
        tablaPeliculasMasVistas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane5.setViewportView(tablaPeliculasMasVistas);
        if (tablaPeliculasMasVistas.getColumnModel().getColumnCount() > 0) {
            tablaPeliculasMasVistas.getColumnModel().getColumn(0).setResizable(false);
        }

        tablaNombrePeliculasMasVistas.setBackground(new java.awt.Color(255, 255, 102));
        tablaNombrePeliculasMasVistas.setForeground(new java.awt.Color(0, 0, 0));
        tablaNombrePeliculasMasVistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "N. Pelicula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaNombrePeliculasMasVistas.setGridColor(new java.awt.Color(0, 0, 0));
        tablaNombrePeliculasMasVistas.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tablaNombrePeliculasMasVistas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(tablaNombrePeliculasMasVistas);
        if (tablaNombrePeliculasMasVistas.getColumnModel().getColumnCount() > 0) {
            tablaNombrePeliculasMasVistas.getColumnModel().getColumn(0).setResizable(false);
        }

        tablaNombrePeliculasMenosVistas.setBackground(new java.awt.Color(255, 255, 102));
        tablaNombrePeliculasMenosVistas.setForeground(new java.awt.Color(0, 0, 0));
        tablaNombrePeliculasMenosVistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "N. Pelicula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaNombrePeliculasMenosVistas.setGridColor(new java.awt.Color(0, 0, 0));
        tablaNombrePeliculasMenosVistas.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tablaNombrePeliculasMenosVistas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(tablaNombrePeliculasMenosVistas);
        if (tablaNombrePeliculasMenosVistas.getColumnModel().getColumnCount() > 0) {
            tablaNombrePeliculasMenosVistas.getColumnModel().getColumn(0).setResizable(false);
        }

        tablaSalas1.setBackground(new java.awt.Color(255, 204, 0));
        tablaSalas1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "N. Sala"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSalas1.setFocusable(false);
        tablaSalas1.setGridColor(new java.awt.Color(0, 0, 0));
        tablaSalas1.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tablaSalas1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane6.setViewportView(tablaSalas1);
        if (tablaSalas1.getColumnModel().getColumnCount() > 0) {
            tablaSalas1.getColumnModel().getColumn(0).setResizable(false);
        }

        tablaSalas2.setBackground(new java.awt.Color(255, 204, 0));
        tablaSalas2.setForeground(new java.awt.Color(0, 0, 0));
        tablaSalas2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "N. Sala"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSalas2.setGridColor(new java.awt.Color(0, 0, 0));
        tablaSalas2.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tablaSalas2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane7.setViewportView(tablaSalas2);
        if (tablaSalas2.getColumnModel().getColumnCount() > 0) {
            tablaSalas2.getColumnModel().getColumn(0).setResizable(false);
        }

        tablaSalas3.setBackground(new java.awt.Color(255, 204, 51));
        tablaSalas3.setForeground(new java.awt.Color(0, 0, 0));
        tablaSalas3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "N. Sala"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaSalas3.setGridColor(new java.awt.Color(0, 0, 0));
        tablaSalas3.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tablaSalas3.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane8.setViewportView(tablaSalas3);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 153));
        jLabel7.setText("N. Sala:");

        lbNumeroPeliculaCombinacion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbNumeroPeliculaCombinacion.setForeground(new java.awt.Color(255, 255, 255));
        lbNumeroPeliculaCombinacion.setText("Aca el numero de pelicula");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 153));
        jLabel9.setText("Cantidad de espectadores: ");

        lbNumeroSalaCombinacion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbNumeroSalaCombinacion.setForeground(new java.awt.Color(255, 255, 255));
        lbNumeroSalaCombinacion.setText("Aca va a ir el numero de sala");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 153));
        jLabel11.setText("N. Pelicula:");

        lbNumeroEspectadoresCombiacion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbNumeroEspectadoresCombiacion.setForeground(new java.awt.Color(255, 255, 255));
        lbNumeroEspectadoresCombiacion.setText("C esp");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(95, 95, 95)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNumeroEspectadoresCombiacion))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbNumeroSalaCombinacion))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(lbNumeroPeliculaCombinacion))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(628, 628, 628)
                        .addComponent(jLabel1)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lbNumeroSalaCombinacion))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lbNumeroPeliculaCombinacion))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lbNumeroEspectadoresCombiacion))
                        .addGap(83, 187, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lbNumeroEspectadoresCombiacion;
    private javax.swing.JLabel lbNumeroPeliculaCombinacion;
    private javax.swing.JLabel lbNumeroSalaCombinacion;
    private javax.swing.JTable tablaNombrePeliculasMasVistas;
    private javax.swing.JTable tablaNombrePeliculasMenosVistas;
    private javax.swing.JTable tablaPeliculas;
    private javax.swing.JTable tablaPeliculasMasVistas;
    private javax.swing.JTable tablaPeliculasMenosVistas;
    private javax.swing.JTable tablaSalas1;
    private javax.swing.JTable tablaSalas2;
    private javax.swing.JTable tablaSalas3;
    // End of variables declaration//GEN-END:variables
}
