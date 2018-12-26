/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioluces;

import java.util.ArrayList;

/**
 *
 * @author Ana Builes
 */
public class EjercicioLuces {

    int[][] matriz;
    int ancho;
    int alto;
    int cant;
    int cant2;
    ArrayList<String> jugadas;

    public EjercicioLuces() {
        this.ancho = 5;
        this.alto = 5;
        this.matriz = new int[alto][ancho];
        cant = 0;
        llenarMatriz();
        jugadas = new ArrayList<>();
    }

    public void llenarMatriz() {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                matriz[i][j] = 0;
            }

        }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int[][] prender(int y, int x) {
        prenderinicial(y, x);
        int c = 0;
        String[] p = new String[25];
        int[][] temp = matriz;
        backtracking(temp, x, y, cant, p, 0);
        return matriz;
    }

    public void cambiar(int y, int x) {
        if (y < alto && y >= 0) {
            if (x < ancho && x >= 0) {
                if (matriz[y][x] == 0) {
                    matriz[y][x] = 1;
                    cant += 1;
                } else {
                    matriz[y][x] = 0;
                    cant -= 1;
                }
            }
        }
    }

    public int[][] cambiar2(int y, int x, int[][] m2) {
        if (y < alto && y >= 0) {
            if (x < ancho && x >= 0) {
                if (m2[y][x] == 0) {
                    m2[y][x] = 1;
                    cant2 += 1;
                } else {
                    m2[y][x] = 0;
                    cant2 -= 1;
                }
            }
        }
        return m2;
    }

    public void prenderinicial(int y, int x) {
        if (y < alto && x < ancho && y >= 0 && x >= 0) {
            if (cant == 25) {
                //return jugadas1;
            } else {
                cambiar(y, x);
                cambiar(y, x + 1);
                cambiar(y, x - 1);
                cambiar(y + 1, x);
                cambiar(y - 1, x);
            }
        }
    }

    public void backtracking(int[][] m, int x, int y, int cant, String[] p, int cont) {
        if (x >= 0 && x < ancho) {
            if (y >= 0 && y < alto) {

                System.out.println("entro ehhhhh");
                m = cambiar2(x, y, m);
                m = cambiar2(x + 1, y, m);
                m = cambiar2(x - 1, y, m);
                m = cambiar2(x, y + 1, m);
                m = cambiar2(x, y - 1, m);
                p[cont] = x + "," + y;

                cant = cant2;
                if (cant == 25) {
                    mostrar(p);
                    return;
                } else {
                    backtracking(m, x + 2, y, cant, p, cont + 1);
                    backtracking(m, x - 2, y, cant, p, cont + 1);
                    backtracking(m, x, y + 2, cant, p, cont + 1);
                    backtracking(m, x, y - 2, cant, p, cont + 1);
                }
                p[cont] = "";
            }
        }
    }

    public void mostrar(String[] p) {
        for (int i = 0; i < p.length; i++) {
            System.out.println("Mover en: " + p[i]);

        }

    }

}
