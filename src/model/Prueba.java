package model;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.util.ArrayList;

public class Prueba extends JFrame {
	public static JLabel label,label2,label3,label4;
	public static ArrayList<JLabel> labels;
	public Prueba() {
		getContentPane().setLayout(new FlowLayout());
		setSize(800, 600);
		setLocationRelativeTo(null);
		labels = new ArrayList<JLabel>();
		
		for (int c = 0; c <5; c++) {
			label = new JLabel("Uno");
			labels.add(label);
			getContentPane().add(labels.get(c));
		}
		//Hilos hilos = new Hilos();
		//hilos.start();
	
		
	}
		
	public static void main(String[] args) {
		Prueba prueba = new Prueba();
		System.out.println("cargando...");
		prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prueba.setVisible(true);
	}
}
