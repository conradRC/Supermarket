import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;
public class Principal {
    static Queue<Cliente> clientes = new LinkedList<>();
    static ArrayList<Byte> carro1 = new ArrayList<>();

   private static void generarCarro(){  
       for (byte c = 0; c<3; c++){ 
           byte numero = (byte)(Math.random()*(5)+1);  
           carro1.add(numero);
        }
   }
    
    public static void main(String[] args) {
        generarCarro();
       Cliente cliente  = new Cliente("Brisa", carro1);
       Cliente cliente2 = new Cliente("Melany",carro1);
       Cliente cliente3 = new Cliente("Pedro", carro1);
       Cliente cliente1 = new Cliente("Marta", carro1);
       clientes.add(cliente);
       clientes.add(cliente2);
       clientes.add(cliente3);
       clientes.add(cliente1);
        //Cliente cliente2 = new Cliente("Sofia", new byte[] {3, 5, 2});
        long initialTime = System.currentTimeMillis();
        Caja caja1 = new Caja("Caja 1", clientes, initialTime);
        //Caja caja2 = new Caja("Caja 2", cliente2, initialTime);
        caja1.start();
        //caja2.start();
    }
    
    public void valoresAleatorios(){
        byte numero = (byte)(Math.random()*(9)+1);
    }
}