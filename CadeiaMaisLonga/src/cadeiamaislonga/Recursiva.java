/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeiamaislonga;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cadeia;
import view.FrameVis;

/**
 *
 * @author ricardo
 */
public class Recursiva implements Runnable {

    private FrameVis frame;

    private Cadeia maior;
    private Cadeia menor;

    public Recursiva(FrameVis frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        CadeiaMaisLonga.lcsRec(menor, maior, frame, menor.getSequencia().length - 1, maior.getSequencia().length - 1);
    }

    public FrameVis getFrame() {
        return frame;
    }

    public void setFrame(FrameVis frame) {
        this.frame = frame;
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
