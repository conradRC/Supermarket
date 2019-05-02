/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrera;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author RouterUIZ007 <router.uiz.360@gmail.com>
 */
public class Carrera extends JFrame {

    JLabel[] lb = new JLabel[3];
    JPanel[] pn = new JPanel[3];
    String[] nom = {"Car 1", "Car 2", "Car 3"};
    JButton btn = new JButton("START");
    int ancho = 1280;

    public Carrera() {
        setLayout(new GridLayout(0, 1));
        for (int i = 0; i < 3; i++) {
            pn[i] = new JPanel();
            add(pn[i]);
            lb[i] = new JLabel(nom[i]);
            lb[i].setIcon(new ImageIcon(new ImageIcon(getClass().getResource("1.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            pn[i].add(lb[i]);
            lb[i].setLocation(0, 0);
        }

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Inicio");
                Carrito a1 = new Carrito("Car 1", ancho - 300, lb[0]);
                Carrito a2 = new Carrito("Car 2", ancho - 300, lb[1]);
                Carrito a3 = new Carrito("Car 3", ancho - 300, lb[2]);
                a1.start();
                a2.start();
                a3.start();

            }

        });
        btn.setPreferredSize(new Dimension(50,80));
        add(btn);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(200, 200);
        setSize(ancho, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        Carrera c = new Carrera();

    }
}
