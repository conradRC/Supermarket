package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Generar {
    //public static Queue<Queue> fila = new LinkedList<>();
    public static ArrayList<Queue<Cliente>> filas = new ArrayList<>();
    
   private static byte [] generarCarro(){
       byte cantProductos = (byte)(Math.random()*(6)+1);
       byte array [] = new byte [cantProductos];
       for(byte c = 0; c<array.length; c++){ 
           byte numero = (byte)(Math.random()*(3)+1);
           array [c] = numero;
       }
       return array;
   }
   
   public static Queue<Cliente> generarClientes(){
	   Queue<Cliente> clientes = new LinkedList<>();
       String [] nombres = {"Pedro","Maria","José","Antionio","Brisa","Melisa","Melany","Rubí","Dulce","Estefany","Alberto","Carlos",       
    		  			   "Conrado","Alan","Kirito","Asuna","Sanji","Luffy","Monica","Amanda","Marilu","Alejandra","Rocio","Berenice",
                           "Alejandro","Daniel","Samuel"};
       for(byte c = 0; c<3; c++){ 
    	   int random = (int) (Math.random()*20);
    	   clientes.add(new Cliente(nombres[random], generarCarro()));
       }
       return clientes;
   }
   
   public static void generarFilas() {
	   for (byte c = 0; c < 3; c++)
		   filas.add(generarClientes());
   }
    
   public static void main(String[] args) {
       generarFilas();
       long initialTime = System.currentTimeMillis();
       Caja caja1 = new Caja("Caja 1", filas.get(0), initialTime);
       //Caja caja2 = new Caja("Caja 2", cliente2, initialTime);
       caja1.start();
       //caja2.start();
   }
}