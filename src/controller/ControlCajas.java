package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ControlCajas implements ActionListener{
	public ControlComponentes componentes;
	boolean bandera;
	public ControlCajas(ControlComponentes componentes) {
		this.componentes = componentes;
		bandera = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton)e.getSource();
		String nombre = boton.getName();
		for (byte c = 0; c < componentes.botones.size(); c++) {		
			if ((nombre).equals(""+c)) {			
				estado(c);
			}
		}
	}
	
	
	public void estado(byte posicion) {
		if(bandera == false) {
			componentes.botones.get(posicion).setBackground(Color.RED);
			bandera = true;
			System.out.println("algos  " + bandera);
		}
		else {
			componentes.botones.get(posicion).setBackground(Color.green);
			bandera = false;
		}
	}
}