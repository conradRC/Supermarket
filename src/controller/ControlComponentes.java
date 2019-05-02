package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import model.Caja;
import model.Generar;
import model.Reloj;
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
    public ArrayList<Caja> hilos;
    public static boolean iniciar=false ;
	
	public ArrayList<Integer> tempos;
    ControlCajas ctrlCajas = new ControlCajas(this);
    public static byte canCajas;
    
    
	public ControlComponentes(JPanel componentes) {
        this.componentes = (Componentes) componentes;
        numero = 0;
        botones = new ArrayList<>();
        paneles = new ArrayList<>();
        etiquetas = new ArrayList<>();
        hilos = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == componentes.getBtnAgregar()) {
        	   canCajas = (byte) Integer.parseInt(componentes.txtCajas.getText());
            if (componentes.txtCajas.getText().length() == 0 || canCajas<=0) {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad de cajas para Iniciar");
            } else {
                for (byte c = 0; c < canCajas; c++) {
                    createComponent();
                    numero++;
                }
                componentes.getBtnAgregar().setEnabled(false);
                componentes.txtCajas.setEnabled(false);
                componentes.getBtIniciar().setBackground(Color.GREEN);
             }
        componentes.cajas.updateUI();
        componentes.fila.updateUI();
        }
        
       if (e.getSource() == componentes.getBtIniciar()) {
    	   componentes.getBtIniciar().setBackground(Color.WHITE);
	   	   componentes.getBtIniciar().setEnabled(false);
	   		
    	   iniciar =true;
    	   if(ctrlCajas.getFlag()>=canCajas) {
    		   Generar.generarFilas();
    		   long initialTime = System.currentTimeMillis();
    		   for (byte c = 0; c <canCajas ; c++) {
    			   hilos.add(new Caja("Caja "+c, Generar.filas.get(c), initialTime, c));
    		   }
    		   ctrlCajas.iniciarHilos();
    	   }
    	   
    	   else {
    		   JOptionPane.showMessageDialog(null, "Primero escoja las cajas que desea que esten abiertas o cerradas");
    	   }
    	   	
        }
    }

    public void createComponent() {
        boton = new JButton("Caja " + (numero + 1));
        boton.setName("" + numero);
        boton.setBackground(Color.WHITE);
        boton.setFocusable(false);
        botones.add(boton);

        ControlCajas control = new ControlCajas(this);
        boton.addActionListener(control);

        panel = new JPanel();
        LineBorder border = new LineBorder(Color.BLACK);
        panel.setBackground(Color.WHITE);
        panel.setBorder(border);
        paneles.add(panel);

        label = new JLabel("Etiqueta " + (numero + 1));
        etiquetas.add(label);
        panel.add(label);

        componentes.cajas.add(boton);
        componentes.fila.add(panel);
    }
    
    public static byte getCanCajas() {
		return canCajas;
	}
    public ArrayList<Caja> getHilos() {
		return hilos;
	}
    public boolean getIniciar() {
		return iniciar;
	}
 
}
