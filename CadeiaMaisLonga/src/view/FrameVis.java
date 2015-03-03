/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cadeiamaislonga.Executor;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import util.Constantes;

/**
 *
 * @author ricardo
 */
public class FrameVis extends JFrame implements WindowListener{

    private String origem;

    private JLabel[] cadeia1;
    private JLabel[] cadeia2;
    private JLabel[][] mtz;

    private JSeparator separador;
    private JButton iniciar;
    private JLabel tamanhos;
    private JLabel tmpRec;
    private JLabel tmpDin;
    private JLabel tempo;

    private Thread tt;
    private Executor exec;

    public FrameVis(String org) {
        super();
        origem = org;
        this.setLayout(null);
        if (org.equalsIgnoreCase("Visualizar")) {
            this.setTitle("Visualização da execução");
            this.setSize(530, 630);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setResizable(false);
            cadeia1 = new JLabel[16];
            cadeia2 = new JLabel[16];
            mtz = new JLabel[16][16];
            for (int i = 0; i < 13; i++) {
                for (int j = 0; j < 13; j++) {
                    mtz[i][j] = new JLabel("");
                    mtz[i][j].setSize(30, 30);
                    mtz[i][j].setLocation(i * 40 + 10, j * 40 + 120);
                    mtz[i][j].setVisible(true);
                    this.add(mtz[i][j]);
                }
                cadeia1[i] = new JLabel("");
                cadeia2[i] = new JLabel("");

                cadeia1[i].setSize(30, 30);
                cadeia1[i].setLocation((i + 1) * 40 + 10, 50);
                cadeia1[i].setVisible(true);

                cadeia2[i].setSize(30, 30);
                cadeia2[i].setLocation((i + 1) * 40 + 10, 80);
                cadeia2[i].setVisible(true);

                this.add(cadeia1[i]);
                this.add(cadeia2[i]);
            }
        } else if (org.equalsIgnoreCase("Comparar")) {
            this.setTitle("Visualização da comparação");
            this.setSize(350, 340);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setResizable(false);

            separador = new JSeparator(JSeparator.VERTICAL);
            separador.setSize(20, (int) (this.getHeight() * 0.2));
            separador.setLocation(this.getWidth() / 2, 100);
            separador.setVisible(true);

            iniciar = new JButton("Iniciar");
            iniciar.setSize(80, 30);
            iniciar.setLocation(135, this.getHeight() - 60);
            iniciar.setVisible(true);

            tamanhos = new JLabel("Tamanho: ---");
            tamanhos.setSize(250, 50);
            tamanhos.setLocation(separador.getLocation().x - tamanhos.getWidth() / 2 + 10, 0);

            tmpDin = new JLabel("Dinamica");
            tmpDin.setSize(90, 90);
            tmpDin.setLocation(separador.getLocation().x - 80, separador.getLocation().y - 10);
            tmpDin.setForeground(Color.red);

            tmpRec = new JLabel("Recursiva");
            tmpRec.setSize(90, 90);
            tmpRec.setLocation(separador.getLocation().x + 15, separador.getLocation().y - 10);
            tmpRec.setForeground(Color.red);

            tempo = new JLabel("0");
            tempo.setSize(this.getWidth(), 80);
            tempo.setLocation(0, iniciar.getLocation().y - 50);

            FrameVis esse = this;

            iniciar.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    
                    if (iniciar.getText().equals("Parar")) {
                        exec.setParar(true);
                    }
                    
                    if (!Constantes.executando) {
                        if (iniciar.getText().equals("Iniciar")) {
                            exec = new Executor(esse, true);
                            tt = new Thread(exec);
                            tt.start();
                            tmpDin.setForeground(Color.red);
                            tmpRec.setForeground(Color.red);
                            iniciar.setText("Parar");
                        }
                    }

                    

                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });

            this.add(separador);
            this.add(iniciar);
            this.add(tamanhos);
            this.add(tmpDin);
            this.add(tmpRec);
            this.add(tempo);
        }
        this.setVisible(true);
        this.addWindowListener(this);
    }

    public JLabel[][] getMtz() {
        return mtz;
    }

    public void setMtz(JLabel[][] mtz) {
        this.mtz = mtz;
    }

    public JLabel getMtzAt(int i, int j) {
        return mtz[i][j];
    }

    public void setMtzAt(int i, int j, String tx) {
        mtz[i][j].setText(tx);
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public JLabel[] getCadeia1() {
        return cadeia1;
    }

    public JLabel getCadeia1At(int i) {
        return cadeia1[i];
    }

    public void setCadeia1(JLabel[] cadeia1) {
        this.cadeia1 = cadeia1;
    }

    public void setCadeia1At(int i, String txt) {
        this.cadeia1[i].setText(txt);
    }

    public JLabel[] getCadeia2() {
        return cadeia2;
    }

    public JLabel getCadeia2At(int i) {
        return cadeia2[i];
    }

    public void setCadeia2(JLabel[] cadeia2) {
        this.cadeia2 = cadeia2;
    }

    public void setCadeia2At(int i, String txt) {
        this.cadeia2[i].setText(txt);
    }

    public JSeparator getSeparador() {
        return separador;
    }

    public void setSeparador(JSeparator separador) {
        this.separador = separador;
    }

    public JButton getIniciar() {
        return iniciar;
    }

    public void setIniciar(JButton iniciar) {
        this.iniciar = iniciar;
    }

    public JLabel getTamanhos() {
        return tamanhos;
    }

    public void setTamanhos(JLabel tamanhos) {
        this.tamanhos = tamanhos;
    }

    public JLabel getTmpRec() {
        return tmpRec;
    }

    public void setTmpRec(JLabel tmpRec) {
        this.tmpRec = tmpRec;
    }

    public JLabel getTmpDin() {
        return tmpDin;
    }

    public void setTmpDin(JLabel tmpDin) {
        this.tmpDin = tmpDin;
    }

    public JLabel getTempo() {
        return tempo;
    }

    public void setTempo(JLabel tempo) {
        this.tempo = tempo;
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
        Constantes.executando = false;
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
