/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ricardo
 */
public class Solucao {

    private String[][] mapaCaminho;
    private int[][] mapaIndices;
    private int quantX;
    private int quantY;

    public Solucao(Cadeia c1, Cadeia c2) {
        quantY = c2.getSequencia().length + 1;
        quantX = c1.getSequencia().length + 1;
        mapaCaminho = new String[quantX][quantY];
        mapaIndices = new int[quantX][quantY];

    }

    public void setMapaIndicesAt(int x, int y, int index) {
        this.mapaIndices[x][y] = index;
    }

    public int getMapaIndicesAt(int x, int y) {
        return this.mapaIndices[x][y];
    }

    public void setMapaCaminhoAt(int x, int y, String index) {
        this.mapaCaminho[x][y] = index;
    }

    public String getMapaCaminhoAt(int x, int y) {
        return this.mapaCaminho[x][y];
    }

    public String[][] getMapaCaminho() {
        return mapaCaminho;
    }

    public void setMapaCaminho(String[][] mapaCaminho) {
        this.mapaCaminho = mapaCaminho;
    }

    public int[][] getMapaIndices() {
        return mapaIndices;
    }

    public void setMapaIndices(int[][] mapaIndices) {
        this.mapaIndices = mapaIndices;
    }

    public void printCaminho() {
        for (int i = 0; i < quantX; i++) {
            for (int j = 0; j < quantY; j++) {
                System.out.print(mapaCaminho[i][j] + "\t\t");
            }
            System.out.println("\n");
        }
    }

    public void printIndices() {
        for (int i = 0; i < quantX; i++) {
            for (int j = 0; j < quantY; j++) {
                System.out.print(mapaIndices[i][j] + "\t\t");
            }
            System.out.println("\n");
        }
    }

    public void print() {
        for (int i = 0; i < quantX; i++) {
            for (int j = 0; j < quantY; j++) {
                System.out.print(mapaIndices[i][j] + "" + mapaCaminho[i][j] + "\t\t");
            }
            System.out.println("\n");
        }
    }

    public int getQuantX() {
        return quantX;
    }

    public void setQuantX(int quantX) {
        this.quantX = quantX;
    }

    public int getQuantY() {
        return quantY;
    }

    public void setQuantY(int quantY) {
        this.quantY = quantY;
    }

}
