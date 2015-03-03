/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeiamaislonga;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.Cadeia;
import model.Solucao;
import util.Constantes;
import view.FrameVis;
import view.Principal;

/**
 *
 * @author ricardo
 */
public class CadeiaMaisLonga implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame janela = new JFrame("Programação Dinâmica");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setAutoRequestFocus(true);
        janela.setLayout(null);
        janela.setResizable(false);

        Principal p = new Principal();
        janela.add(p);
        janela.setSize(p.getSize());

        janela.setLocationRelativeTo(null);

        Constantes.janela = janela;
        janela.setVisible(true);
        Constantes.executando = false;
    }

    public static int lcsRec(Cadeia c1, Cadeia c2, FrameVis frame, int c1_lan, int c2_lan) {
        if (!Constantes.executando) {
            return -1;
        }

        if (c1_lan == 0 || c2_lan == 0) {
            return 0;
        }

        if (c1.getCharAt(c1_lan) == c2.getCharAt(c2_lan)) {
            return lcsRec(c1, c2, frame, c1_lan - 1, c2_lan - 1) + 1;
        } else {
            return Math.max(lcsRec(c1, c2, frame, c1_lan - 1, c2_lan), lcsRec(c1, c2, frame, c1_lan, c2_lan - 1));
        }

    }

    public static Solucao lcsLength(Cadeia c1, Cadeia c2, FrameVis frame) {
        Solucao s = new Solucao(c1, c2);

        for (int i = 0; i < s.getQuantX(); i++) {
            if (!Constantes.executando) {
                return null;
            }
            s.setMapaIndicesAt(i, 0, 0);
            s.setMapaCaminhoAt(i, 0, "c");
            if (frame.getOrigem().equals("Visualizar")) {
                frame.setMtzAt(0, i, 0 + "c");
                try {
                    Thread.sleep(301);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CadeiaMaisLonga.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        for (int j = 0; j < s.getQuantY(); j++) {
            if (!Constantes.executando) {
                return null;
            }
            s.setMapaIndicesAt(0, j, 0);
            s.setMapaCaminhoAt(0, j, "e");
            if (frame.getOrigem().equals("Visualizar")) {
                frame.setMtzAt(j, 0, 0 + "e");
                try {
                    Thread.sleep(301);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CadeiaMaisLonga.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        for (int i = 1; i < s.getQuantX(); i++) {
            for (int j = 1; j < s.getQuantY(); j++) {
                if (!Constantes.executando) {
                    return null;
                }
                if (c1.getCharAt(i - 1) == c2.getCharAt(j - 1)) {
                    s.setMapaIndicesAt(i, j, s.getMapaIndicesAt(i - 1, j - 1) + 1);
                    s.setMapaCaminhoAt(i, j, "d");
                    if (frame.getOrigem().equals("Visualizar")) {
                        frame.setMtzAt(j, i, (s.getMapaIndicesAt(i - 1, j - 1) + 1) + "d");
                    }
                } else if (s.getMapaIndicesAt(i - 1, j) >= s.getMapaIndicesAt(i, j - 1)) {
                    s.setMapaIndicesAt(i, j, s.getMapaIndicesAt(i - 1, j));
                    s.setMapaCaminhoAt(i, j, "c");
                    if (frame.getOrigem().equals("Visualizar")) {
                        frame.setMtzAt(j, i, s.getMapaIndicesAt(i - 1, j) + "c");
                    }
                } else {
                    s.setMapaIndicesAt(i, j, s.getMapaIndicesAt(i, j - 1));
                    s.setMapaCaminhoAt(i, j, "e");
                    if (frame.getOrigem().equals("Visualizar")) {
                        frame.setMtzAt(j, i, s.getMapaIndicesAt(i, j - 1) + "e");
                    }
                }
                if (frame.getOrigem().equals("Visualizar")) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CadeiaMaisLonga.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        return s;
    }

    public static void printLcs(FrameVis fram, Solucao s, int i, int j) {
        if (!Constantes.executando) {
            return;
        }

        if (i == 0 || j == 0) {
            if (fram.getOrigem().equals("Visualizar")) {
                fram.getMtzAt(j, i).setForeground(Color.GREEN);
                try {
                    Thread.sleep(1009);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CadeiaMaisLonga.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return;
        }

        if (s.getMapaCaminhoAt(i, j).equalsIgnoreCase("d")) {

            if (fram.getOrigem().equals("Visualizar")) {
                fram.getMtzAt(j, i).setForeground(Color.red);
                fram.getCadeia1At((j - 1)).setForeground(Color.red);
                fram.getCadeia2At((i - 1)).setForeground(Color.red);
                try {
                    Thread.sleep(1010);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CadeiaMaisLonga.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            printLcs(fram, s, i - 1, j - 1);
        } else if (s.getMapaCaminhoAt(i, j).equalsIgnoreCase("c")) {
            if (fram.getOrigem().equals("Visualizar")) {
                fram.getMtzAt(j, i).setForeground(Color.orange);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CadeiaMaisLonga.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            printLcs(fram, s, i - 1, j);
        } else {
            if (fram.getOrigem().equals("Visualizar")) {
                fram.getMtzAt(j, i).setForeground(Color.orange);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CadeiaMaisLonga.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            printLcs(fram, s, i, j - 1);
        }
    }

    @Override
    public void run() {
        int tam1 = (int) (Math.random() * 100);
        int tam2 = (int) (Math.random() * 100);
        Cadeia c1 = new Cadeia(new char[tam1]);
        for (int i = 0; i < tam1; i++) {
            c1.setCharAt(i, Constantes.alfabeto[(int) (Math.random() * 4)]);
        }

        Cadeia c2 = new Cadeia(new char[tam2]);
        for (int i = 0; i < tam2; i++) {
            c2.setCharAt(i, Constantes.alfabeto[(int) (Math.random() * 4)]);
        }

        Solucao a = lcsLength(c2, c1, null);
        printLcs(null, a, c2.getSequencia().length, c1.getSequencia().length);
    }

}
