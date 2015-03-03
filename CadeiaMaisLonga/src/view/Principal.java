/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cadeiamaislonga.Dinamica;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import util.Constantes;

/**
 *
 * @author ricardo
 */
public class Principal extends JPanel {

    private JButton bt_comparar;
    private JButton bt_visualizar;

    public Principal() {
        super();

        this.setLayout(null);
        this.setSize(430, 80);
        this.setLocation(0, 0);

        bt_comparar = new JButton();
        bt_visualizar = new JButton();

        bt_comparar.setSize(200, 25);
        bt_visualizar.setSize(200, 25);

        bt_comparar.setLocation(10, this.getHeight() / 2 - bt_comparar.getHeight() / 2);
        bt_visualizar.setLocation(bt_comparar.getLocation().x + bt_comparar.getWidth() + 10, this.getHeight() / 2 - bt_comparar.getHeight() / 2);;

        bt_comparar.setText("Comparar");
        bt_visualizar.setText("Visualizar");

        bt_comparar.setToolTipText("Compara o tempo de execução entre os dois métodos, recursivo e programação dinâmica");
        bt_visualizar.setToolTipText("Visualiza a execução do procedimentos");

        bt_comparar.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!Constantes.executando) {
                    FrameVis frame = new FrameVis("Comparar");
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
        bt_visualizar.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!Constantes.executando) {
                    FrameVis frame = new FrameVis("Visualizar");
                    Dinamica d = new Dinamica(frame,false);
                    Thread t = new Thread(d);
                    t.start();
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

        this.add(bt_comparar);
        this.add(bt_visualizar);

    }

}
