package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.ietf.jgss.Oid;

import model.Hilos;
import view.Componentes;

public class ControlComponentes implements ActionListener {
	public Componentes componentes;
	public byte numero;
	public JButton boton;
	public JPanel panel;
	public static JLabel label;
	public ArrayList<JButton> botones;
	public ArrayList<JPanel> paneles;
	public static ArrayList<JLabel> etiquetas;
	public ArrayList<Hilos> hebras;
	public ArrayList<Integer> tempos;
	public int [] temp = new int [] {10,5,15,3,2}; 
	public ControlComponentes(JPanel componentes){
		this.componentes = (Componentes) componentes;
		numero = 0;
		botones = new ArrayList<>();
		paneles = new ArrayList<>();
		etiquetas = new ArrayList<>();
		hebras = new ArrayList<>();
		
		//tempos = new ArrayList<>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==componentes.btnAgregar) {
			
			if(componentes.txtCajas.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "Ingrese una cantidad de cajas");
			}
				
			else {	
				byte canCajas = (byte) Integer.parseInt(componentes.txtCajas.getText());
				for (byte c = 0; c <canCajas ; c++) {
					createComponent();
					numero++;
				}
				componentes.btnAgregar.setEnabled(false);
				componentes.txtCajas.setEnabled(false);
				//random();
				createHilos();
			}
			componentes.cajas.updateUI();
			componentes.fila.updateUI();
		}
	}
	
	
	public  void createComponent() {
		boton = new JButton("Caja "+(numero+1));
		boton.setName(""+numero);
		boton.setBackground(Color.GREEN);
		boton.setFocusable(false);
		botones.add(boton);
		
		ControlCajas control = new ControlCajas(this);
		boton.addActionListener(control);
		
		panel = new JPanel();
		LineBorder border = new LineBorder(Color.BLACK);
		panel.setBackground(Color.WHITE);
		panel.setBorder(border);
		paneles.add(panel);
		
		label = new JLabel("Etiqueta " + (numero+1));
		etiquetas.add(label);
		panel.add(label);
		
		componentes.cajas.add(boton);
		componentes.fila.add(panel);
	}
	
	public void createHilos() {
		
		for (int c = 0; c < botones.size(); c++) {
			System.out.println(temp[c]);
			Hilos hilos = new Hilos(temp[c],"Hilo "+numero);
			hilos.start();
			hebras.add(hilos);
		}
	}
	
	public void random() {
		Random random = new Random();
		for (int c = 0; c < botones.size(); c++) {
			int aleatorio = (random.nextInt(6000)+200);
			System.out.println(aleatorio);
			tempos.add(aleatorio);
		}
	}
	
}
