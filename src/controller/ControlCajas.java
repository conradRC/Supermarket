package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ControlCajas implements ActionListener {

    public ControlComponentes componentes;
    boolean bandera;
    private JButton boton;
    private String nombre;
    private static byte flag=0;
    private byte[] cont;

	public ControlCajas(ControlComponentes componentes) {
        this.componentes = componentes;
        bandera = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boton = (JButton) e.getSource();
        nombre = boton.getName();
        flag=1;
        for (byte c = 0; c < componentes.botones.size(); c++) {
            if ((nombre).equals("" + c)) {
                estado(c);
            }
        }
    }

    public void estado(byte posicion) {
    	if (cont == null) {
    		cont = new byte[componentes.botones.size()];
            for(byte i=0; i<componentes.botones.size(); i++) {
            	cont[i] = 0;
            }
    	}
        if (bandera == false) {
        	if(cont[posicion] == 1) {
            	componentes.botones.get(posicion).setBackground(Color.GREEN);
            	boton.setText("Caja Abierta");
            	bandera = true;
            	componentes.hilos.get(posicion).renaudarhilo();
        	}
        	else {
        		componentes.botones.get(posicion).setBackground(Color.GREEN);
            	boton.setText("Caja Abierta");
            	bandera = true;
            	cont[posicion]=1;
        	}
        } else {
            componentes.botones.get(posicion).setBackground(Color.RED);
            boton.setText("Caja Cerrada");
			componentes.hilos.get(posicion).suspenderhilo();
            bandera = false;
        }
    }
    
    public byte getFlag() {
		return flag;
	}
}
