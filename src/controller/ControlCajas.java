package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ControlCajas implements ActionListener {

    public ControlComponentes componentes;
    boolean bandera;

    public ControlCajas(ControlComponentes componentes) {
        this.componentes = componentes;
        bandera = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        String nombre = boton.getName();
        for (byte c = 0; c < componentes.botones.size(); c++) {
            if ((nombre).equals("" + c)) {
                estado(c);
            }
        }
    }

    public void estado(byte posicion) {
        if (bandera == false) {

            componentes.botones.get(posicion).setBackground(Color.BLACK);
            bandera = true;
            System.out.println("CAJA CERRADA\n (" + bandera+")");
        } else {

            componentes.botones.get(posicion).setBackground(Color.WHITE);
            bandera = false;
            System.out.println("CAJA ABIERTA\n (" + bandera+")");

        }
    }
}
