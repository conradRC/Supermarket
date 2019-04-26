/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author RouterUIZ007 <router.uiz.360@gmail.com>
 */
public class Info extends JFrame {

    public Info() {
    }

    public void inicio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setTitle("Informacion xD");
        setVisible(true);
    }


    public static void main(String[] args) {
        Info i = new Info();
        i.inicio();
    }
}
