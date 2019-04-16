package model;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import controller.ControlComponentes;

public class Hilos extends Thread{
	private int tempo =0;
	private String nombre = "";
	public Hilos(int t, String nombre) {
		this.tempo = t;
		this.nombre = nombre;
	}
	
	public void run() {
		while (true) {
			Random random = new Random();
			
			for (int c = 0; c < ControlComponentes.etiquetas.size(); c++) {
				int numero = (random.nextInt(9)+1);
				ControlComponentes.etiquetas.get(c).setText(numero+"");	
			}
			
			try {
				TimeUnit.SECONDS.sleep(tempo);
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
		}
	}
}
