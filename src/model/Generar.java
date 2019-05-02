package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import controller.ControlComponentes;

public class Generar {
	
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
       String [] nombres = {"Pedro","Maria","José","Antionio","Brisa","Melisa","Melany","Sonia","Dulce","Estefany","Alberto","Carlos",
    		  			   "Conrado","Alan","Kirito","Asuna","Sanji","Luffy","Monica","Amanda","Marilu","Alejandra","Rocio","Berenice",
                           "Alejandro","Daniel","Samuel"};
       for(byte c = 0; c<5; c++){
    	   int random = (int) (Math.random()*25);
    	   clientes.add(new Cliente(nombres[random], generarCarro()));
       }
       return clientes;
   }

   public static void generarFilas() {
	   
	   for (byte c = 0; c <ControlComponentes.canCajas ; c++)
		   filas.add(generarClientes());
   }
}
