package Carrera;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author RouterUIZ007 <router.uiz.360@gmail.com>
 */
public class Carrito extends Thread{
    private String nombre;
    private int limite;
    JLabel lb;
    public Carrito(String nom,int lim,JLabel lb){
        nombre=nom;
        limite=lim;
        this.lb=lb;
    }
    @Override
    public void run(){
        for(int i=0;i<limite;i++){
            System.out.println(nombre+" "+"Avanza");
            lb.setLocation(i, 0);
            try{
               Thread.sleep(10);
            }catch(InterruptedException ex){}
        }
        JOptionPane.showMessageDialog(null,nombre+" "+"ya llego xD");
        yield();
    }
}
