package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import controller.ControlComponentes;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Componentes extends JPanel {

    public Cajas cajas;
    public Fila fila;
    private JButton btnAgregar,infoTable;
    public JTextField txtCajas;
    private JLabel lbIngresar;
    public static JLabel lblTime;
    private JButton btIniciar;
    
    public static Componentes componente;
    
	public Componentes() {

        GridBagLayout gbc = new GridBagLayout();
        gbc.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
        gbc.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
        setLayout(gbc);
        ControlComponentes control = new ControlComponentes(this);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBackground(Color.WHITE);
        btnAgregar.setForeground(Color.BLACK);
        btnAgregar.setFocusable(false);
        btnAgregar.addActionListener(control);

        lbIngresar = new JLabel("Ingrese cantidad de cajas: ");
        GridBagConstraints gbc_lbIngresar = new GridBagConstraints();
        gbc_lbIngresar.insets = new Insets(5, 5, 5, 5);
        gbc_lbIngresar.anchor = GridBagConstraints.EAST;
        gbc_lbIngresar.gridx = 0;
        gbc_lbIngresar.gridy = 0;
        add(lbIngresar, gbc_lbIngresar);

        txtCajas = new JTextField();
        GridBagConstraints gbctxtCajas = new GridBagConstraints();
        gbctxtCajas.insets = new Insets(5, 0, 5, 5);
        gbctxtCajas.fill = GridBagConstraints.BOTH;
        gbctxtCajas.gridx = 1;
        gbctxtCajas.gridy = 0;
        add(txtCajas, gbctxtCajas);
        txtCajas.setColumns(3);
        txtCajas.setHorizontalAlignment(JTextField.CENTER);
        Font font = new Font("Arial", Font.BOLD, 13);
        txtCajas.setFont(font);
        txtCajas.addActionListener(control);

        GridBagConstraints gbcAgregar = new GridBagConstraints();
        gbcAgregar.insets = new Insets(5, 0, 5, 5);
        gbcAgregar.gridx = 2;
        gbcAgregar.gridy = 0;
        gbcAgregar.anchor = GridBagConstraints.NORTHWEST;
        add(btnAgregar, gbcAgregar);
        
        btIniciar = new JButton("Iniciar");
        btIniciar.setBackground(Color.WHITE);
        btIniciar.setFocusable(false);
        GridBagConstraints gbc_btIniciar = new GridBagConstraints();
        gbc_btIniciar.insets = new Insets(5, 0, 5, 5);
        gbc_btIniciar.gridx = 3;
        gbc_btIniciar.gridy = 0;
        add(btIniciar, gbc_btIniciar);
        btIniciar.addActionListener(control);
        
        infoTable = new JButton("Tabla");
        infoTable.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_InfoTable = new GridBagConstraints();
        gbc_InfoTable.gridwidth = 2;
        gbc_InfoTable.anchor = GridBagConstraints.EAST;
        gbc_InfoTable.insets = new Insets(5, 5, 5, 0);
        gbc_InfoTable.gridx = 5; 
        gbc_InfoTable.gridy = 0;
        add(infoTable, gbc_InfoTable);
        infoTable.setBackground(Color.WHITE);
        infoTable.setForeground(Color.BLACK);
        infoTable.setFocusable(false);
        infoTable.addActionListener(control);
        
        lblTime = new JLabel("Time");
        lblTime.setBackground(Color.WHITE);
        lblTime.setVerticalAlignment(SwingConstants.TOP);
        lblTime.setHorizontalAlignment(SwingConstants.LEFT);
        lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));
               
        GridBagConstraints gbc_lblTime = new GridBagConstraints();
        gbc_lblTime.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblTime.insets = new Insets(5, 0, 5, 5);
        gbc_lblTime.gridx = 4;
        gbc_lblTime.gridy = 0;
        add(lblTime, gbc_lblTime);

        GridBagConstraints gbContenedor = new GridBagConstraints();
        gbContenedor.gridwidth = 7;
        gbContenedor.ipady = 30;
        gbContenedor.insets = new Insets(0, 0, 5, 0);
        gbContenedor.fill = GridBagConstraints.BOTH;
        gbContenedor.gridx = 0;
        gbContenedor.gridy = 2;
        cajas = new Cajas();
        add(cajas, gbContenedor);

        fila = new Fila("");
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridwidth = 7;
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 3;
        add(fila, gbc_panel);
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getInfoTable() {
        return infoTable;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public void setInfoTable(JButton addd) {
        this.infoTable = addd;
    }
    
    public JButton getBtIniciar() {
		return btIniciar;
	}
    
    public static Componentes get() {
    	return componente;
    }

}
