package model;

import java.util.Queue;

public class Caja extends Thread {
    private String nombre;
    private Queue<Cliente> cliente;
    private long initialTime;
    public Caja(String nombre, Queue <Cliente> cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
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

    @Override
    public void run() {
       System.out.println("Inicial Time: "+ (System.currentTimeMillis() - initialTime) / 1000);
       int total=0;
       while(!Principal.clientes.isEmpty()){
          Cliente client = Principal.clientes.poll();
          for(int c =0 ; c<client.getCarroCompra().length; c++){
               timeWait(client.getCarroCompra()[c]);
              System.out.println("Productos: " + client.getCarroCompra()[c] +
                                 " :  cliente: " + client.getNombre() + "->Tiempo: "+ 
                              (System.currentTimeMillis() - initialTime) / 1000+ "s");
              total+= client.getCarroCompra()[c];
           }
           System.out.println("cliente: " +client.getNombre() +"  Total productos : " + total);
       }
    }

    private void timeWait(byte segundos) {
        try {
           Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
           Thread.currentThread().interrupt();
        }
    }
    //System.out.println(nombre + "-> TERMINÓ " + Principal.clientes.get(c).getNombre() + "-> TIME ALL: "+
            //                (System.currentTimeMillis() - initialTime) / 1000+ "s");

    /* System.out.println( nombre + " con el cliente " 
                    + cliente.getNombre() + " EN EL TIEMPO: " 
                    + time+ "s");*/
}