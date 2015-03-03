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
public class Cadeia {

    private char[] sequencia;

    public Cadeia(char[] seq) {
        sequencia = seq;
    }

    public char getCharAt(int i) {
        return this.sequencia[i];
    }

    public void setCharAt(int i, char c) {
        this.sequencia[i] = c;
    }

    public char[] getSequencia() {
        return sequencia;
    }

    public void setSequencia(char[] sequencia) {
        this.sequencia = sequencia;
    }

}
