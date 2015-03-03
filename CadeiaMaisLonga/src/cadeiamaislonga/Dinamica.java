/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeiamaislonga;

import java.awt.Color;
import model.Cadeia;
import model.Solucao;
import util.Constantes;
import view.FrameVis;

/**
 *
 * @author ricardo
 */
public class Dinamica implements Runnable {

    private FrameVis fr_exe;
    private int tam1;
    private int tam2;
    private boolean comparador;

    private Cadeia maior;
    private Cadeia menor;

    public Dinamica(FrameVis frame, boolean flag) {
        fr_exe = frame;
        comparador = flag;
    }

    public void createInputs() {
        int xtam1 = (int) (Math.random() * ((!comparador) ? 12 : 1000)) + 1;
        int xtam2 = (int) (Math.random() * ((!comparador) ? 12 : 1000)) + 1;

        if (xtam1 >= xtam2) {
            tam1 = xtam1;
            tam2 = xtam2;
        } else {
            tam1 = xtam2;
            tam2 = xtam1;
        }

        maior = new Cadeia(new char[tam1]);
        for (int i = 0; i < tam1; i++) {
            maior.setCharAt(i, Constantes.alfabeto[(int) (Math.random() * 4)]);
            if (!comparador) {
                fr_exe.setCadeia1At(i, "" + maior.getCharAt(i));
            }
        }

        menor = new Cadeia(new char[tam2]);
        for (int i = 0; i < tam2; i++) {
            menor.setCharAt(i, Constantes.alfabeto[(int) (Math.random() * 4)]);
            if (!comparador) {
                fr_exe.setCadeia2At(i, "" + menor.getCharAt(i));
            }
        }
    }

    @Override
    public void run() {

        if (!comparador) {
            Constantes.executando = true;
        }

        if (!comparador) {
            createInputs();
        }

        Solucao a = CadeiaMaisLonga.lcsLength(menor, maior, fr_exe);
        CadeiaMaisLonga.printLcs(fr_exe, a, menor.getSequencia().length, maior.getSequencia().length);
        if (!comparador) {
            Constantes.executando = false;
        }
        if (!comparador) {
            fr_exe.getContentPane().setBackground(Color.black);
        }
    }

    public FrameVis getFr_exe() {
        return fr_exe;
    }

    public void setFr_exe(FrameVis fr_exe) {
        this.fr_exe = fr_exe;
    }

    public int getTam1() {
        return tam1;
    }

    public void setTam1(int tam1) {
        this.tam1 = tam1;
    }

    public int getTam2() {
        return tam2;
    }

    public void setTam2(int tam2) {
        this.tam2 = tam2;
    }

    public boolean isComparador() {
        return comparador;
    }

    public void setComparador(boolean comparador) {
        this.comparador = comparador;
    }

    public Cadeia getMaior() {
        return maior;
    }

    public void setMaior(Cadeia maior) {
        this.maior = maior;
    }

    public Cadeia getMenor() {
        return menor;
    }

    public void setMenor(Cadeia menor) {
        this.menor = menor;
    }

}
