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
    private static byte[] cont;

	public ControlCajas(ControlComponentes componentes) {
        this.componentes = componentes;
        bandera = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boton = (JButton) e.getSource();
        nombre = boton.getName();
        flag++;
        
        for (byte c = 0; c < componentes.botones.size(); c++) {
            if ((nombre).equals("" + c))
                estadoCaja(c);
        }
       
    }

    public void estadoCaja(byte posicion) {
    	llenarContador();
    	if (bandera == false)	estadoActivo(posicion);
     	else 					estadoInactivo(posicion);
    }
    
    public void estadoActivo(byte posicion) {
    	componentes.botones.get(posicion).setBackground(Color.GREEN);
		boton.setText("Caja Abierta");
		bandera = true;
		
		if (componentes.getIniciar()==true) {
       		if (cont[posicion]==0) {
       			componentes.hilos.get(posicion).start();
       		
			}
       		else {
       			componentes.getHilos().get(posicion).renaudarhilo();
       		}
		}
			cont[posicion]=1;
    }
    
    public void estadoInactivo(byte posicion) {
    	componentes.botones.get(posicion).setBackground(Color.RED);
       	boton.setText("Caja Cerrada");
       	bandera = false;
       	if (componentes.getIniciar()==true) {
       		componentes.getHilos().get(posicion).suspenderhilo();
		}
       	else {
       		cont[posicion]=0;
       	}
    }
    
    
    public void iniciarHilos() {
    	for (byte c = 0; c < componentes.canCajas; c++) {
    		if (cont[c]==1) 
    			componentes.hilos.get(c).start();
    	}
    }
   
    public byte getFlag() {
		return flag;
	}
    
    public byte[] getCont() {
		return cont;
	}
    
    public void llenarContador() {
    	if (cont==null) {
     		cont = new byte[componentes.botones.size()];
            for(byte i=0; i<componentes.botones.size(); i++)
             	cont[i] = 0;
    	}
   }
}

/*if(componentes.getIniciar()==1) {
if(componentes.hilos.get(posicion).isAlive()==true) {
	estadoActivo(posicion);
	componentes.hilos.get(posicion).renaudarhilo();
}
else {
	estadoActivo(posicion);
	componentes.hilos.get(posicion).start();
}*/



/*
else {
estadoInactivo(posicion);
	componentes.hilos.get(posicion).suspenderhilo();
	System.out.println("5 --"+ bandera);
}*/