package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Filas extends JPanel {
	public JLabel label;
	public Filas(String nombre) {
		LineBorder border = new LineBorder(Color.BLACK);
		setBackground(Color.WHITE);
		setBorder(border);
		
		label = new JLabel(nombre);
		add(label);
	}

}
