/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeiamaislonga;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Constantes;
import view.FrameVis;

/**
 *
 * @author ricardo
 */
public class Executor implements Runnable {

    private FrameVis frame;
    private boolean comparador;
    private boolean parar;

    public Executor(FrameVis frame, boolean flag) {
        this.frame = frame;
        comparador = flag;
        parar = false;
    }

    @Override
    public void run() {
        Constantes.executando = true;
        Dinamica d = new Dinamica(frame, comparador);
        Recursiva r = new Recursiva(frame);

        d.createInputs();

        r.setMenor(d.getMenor());
        r.setMaior(d.getMaior());

        frame.getTamanhos().setText("Tamanho: " + d.getMaior().getSequencia().length + "x" + d.getMenor().getSequencia().length + " [Matriz]");

        Thread td = new Thread(d);
        Thread tr = new Thread(r);

        tr.start();
        td.start();
        frame.getTempo().setText("0");
        int tempo = 0;

        while (true) {

            if (!tr.isAlive()) {
                frame.getTmpRec().setForeground(Color.green);
            }

            if (!td.isAlive()) {
                frame.getTmpDin().setForeground(Color.green);
            }
            tempo += 1;
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Executor.class.getName()).log(Level.SEVERE, null, ex);
            }

            frame.getTempo().setText("" + tempo);

            if (!tr.isAlive() && !td.isAlive()) {
                break;
            }
            if (parar) {
                break;
            }
        }

        Constantes.executando = false;
        frame.getIniciar().setText("Iniciar");
    }

    public FrameVis getFrame() {
        return frame;
    }

    public void setFrame(FrameVis frame) {
        this.frame = frame;
    }

    public boolean isComparador() {
        return comparador;
    }

    public void setComparador(boolean comparador) {
        this.comparador = comparador;
    }

    public boolean isParar() {
        return parar;
    }

    public void setParar(boolean parar) {
        this.parar = parar;
    }

}
