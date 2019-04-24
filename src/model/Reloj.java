package model;

import view.Componentes;

public class Reloj extends Thread {
    
   @Override 
   public void run(){
     for (byte minutos=0;minutos<60;minutos++){       
         for (byte segundos=0;segundos<60;segundos++){
        	 String time = String.format("%02d%1s%02d", minutos,":",segundos);
          Componentes.lblTime.setText(time);
          timeWait(); 
        }
     }
   }
  
   
   private static void timeWait() {
        try {
           Thread.sleep(1000);
        } catch (InterruptedException ex) {
           Thread.currentThread().interrupt();
        }
    }
}
