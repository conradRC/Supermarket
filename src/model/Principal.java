package model;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;
public class Principal {
    static Queue<Cliente> clientes = new LinkedList<>();
   private static byte [] generarCarro(){
       byte cantProductos = (byte)(Math.random()*(6)+1);
       byte array [] = new byte [cantProductos];
       for(byte c = 0; c<array.length; c++){ 
           byte numero = (byte)(Math.random()*(3)+1);
           array [c] = numero;
       }
       return array;
   }
   
   public static void generarCliente(){
      String [] nombres = {"Pedro","Maria","José","Antionio","Brisa","Melisa","Melany","Rubí","Dulce","Estefany","Alberto","Carlos",
                           "Conrado","Alan","Kirito","Asuna","Sanji","Luffy","Monica","Amanda","Marilu","Alejandra","Rocio","Berenice",
                           "Alejandro","Daniel","Samuel"};
       for(byte c = 0; c<6; c++){ 
           clientes.add(new Cliente(nombres[c], generarCarro()));
      }
   }
    
   public static void main(String[] args) {
       generarCliente(); 
       //Cliente cliente2 = new Cliente("Sofia", new byte[] {3, 5, 2});
       long initialTime = System.currentTimeMillis();
       Caja caja1 = new Caja("Caja 1", clientes, initialTime);
       //Caja caja2 = new Caja("Caja 2", cliente2, initialTime);
       caja1.start();
       //caja2.start();
   }
}