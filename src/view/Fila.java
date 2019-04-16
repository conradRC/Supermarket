package view;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.GridLayout;

public class Fila extends JPanel {
	public Fila(String nombre) {
		setBackground(Color.GRAY);
		setLayout(new GridLayout(1, 0, 5, 5));

	}
}
