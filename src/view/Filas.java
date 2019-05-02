package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import javafx.scene.layout.Border;

public class Filas extends JPanel {
	public JLabel label;
	public Filas(String nombre) {
		LineBorder border = new LineBorder(Color.BLACK);
		setBackground(Color.WHITE);
		setBorder(border);
		
		label = new JLabel(nombre);
		add(label);
		
		JButton  boton1= new JButton("ad");
		for (int c = 0; c < 200; c++) {
			boton1.setBounds(c*5, c*10, c*5, c*10);
		}
		this.add(boton1);
	}
	
	public static void main(String[] args) {
		System.out.println("Cargando..");
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setSize(800, 600);
		Filas filas = new Filas("nombre");
		frame.add(filas);
		frame.setVisible(true);
		
	}

}
