package model;

import java.util.Queue;

import controller.ControlComponentes;

public class Caja extends Thread {
	private String nombre;
	private Queue<Cliente> cliente;
	private long initialTime;
	static boolean suspender; // Suspende un hilo cuando es true
	static boolean pausar; // Detiene un hilo cuando es true
	int index;

	public Caja(String nombre, Queue<Cliente> cliente, long initialTime, int index) {
		this.nombre = nombre;
		this.cliente = cliente;
		this.initialTime = initialTime;
		this.index = index;
		suspender = false;
		pausar = false;
	}

	@Override
	public void run() {
		System.out.println("Inicial Time: " + (System.currentTimeMillis() - initialTime) / 1000);
		int total = 0;
		byte countFila = 0;
		byte countClient = 0;

		for (int i = 0; i < Generar.filas.size(); i++) {
			countFila++;
			//System.out.println("fila :" + countFila);

			while (!Generar.filas.get(i).isEmpty()) {
				Cliente client = Generar.filas.get(i).poll();
				countClient++;
				//System.out.println("\nCajera: " + this.getNombre() + "  " + "cliente: " + client.getNombre()
					//	+ "  Total productos : " + client.getTotal());

				ControlComponentes.etiquetas.get(index).setText(client.getNombre() + " -> Productos: " + client.getTotal());

				 for(int c =0 ; c<client.getCarroCompra().length; c++){


					timeWait(client.getCarroCompra()[c]);

				//	System.out.println("Productos: " + client.getCarroCompra()[c] + " :  cliente: " + client.getNombre()
					//		+ "->Tiempo: " + (System.currentTimeMillis() - initialTime) / 1000 + "s");
					 synchronized (this) {
	                       while (suspender) {
	                    	   try {
	                    		   this.wait();
	                    	   }
	                    	   catch (InterruptedException e) {
	                    		   e.printStackTrace();
	                    	   }
	                       }
												 if (!suspender) {
                            this.notify();
                            break;
                        }
	                   }
					total += client.getCarroCompra()[c];
				}
			}

			System.out.println("----------------");
			countClient = 0;
		}
	}

	private void timeWait(byte segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public synchronized void pausarhilo() {
		pausar = true;
		// lo siguiente garantiza que un hilo suspendido puede detenerse.
		suspender = false;
		notify();
	}

	// Suspender un hilo
	public synchronized void suspenderhilo() {
		suspender = true;
	}

	// Renaudar un hilo
	public synchronized void renaudarhilo() {
		suspender = false;
		notifyAll();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public long getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}

	public Queue<Cliente> getCliente() {
		return cliente;
	}

	// System.out.println(nombre + "-> TERMINÓ " +
	// Principal.clientes.get(c).getNombre() + "-> TIME ALL: "+
	// (System.currentTimeMillis() - initialTime) / 1000+ "s");

	/*
	 * System.out.println( nombre + " con el cliente " + cliente.getNombre() +
	 * " EN EL TIEMPO: " + time+ "s");
	 */
}
