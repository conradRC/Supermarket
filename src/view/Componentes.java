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
		public JButton btnAgregar;
		public JTextField txtCajas;
		private JLabel lbIngresar;
		public static JLabel lblTime;
		private JLabel lblNewLabel;
	public Componentes() {
		GridBagLayout gbc = new GridBagLayout();
		gbc.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		gbc.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
		setLayout(gbc);
		ControlComponentes control = new ControlComponentes(this);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(Color.WHITE);
		btnAgregar.setForeground(Color.BLACK);
		btnAgregar.setFocusable(false);
		btnAgregar.addActionListener(control);
		
		lbIngresar = new JLabel("Ingrese cantidad de cajas: ");
		GridBagConstraints gbc_lbIngresar = new GridBagConstraints();
		gbc_lbIngresar.insets = new Insets(0, 5, 5, 5);
		gbc_lbIngresar.anchor = GridBagConstraints.EAST;
		gbc_lbIngresar.gridx = 0;
		gbc_lbIngresar.gridy = 0;
		add(lbIngresar, gbc_lbIngresar);
		
		txtCajas = new JTextField();
		GridBagConstraints gbctxtCajas = new GridBagConstraints();
		gbctxtCajas.insets = new Insets(0, 0, 5, 5);
		gbctxtCajas.fill = GridBagConstraints.BOTH;
		gbctxtCajas.gridx = 1;
		gbctxtCajas.gridy = 0;
		add(txtCajas, gbctxtCajas);
		txtCajas.setColumns(3);
		txtCajas.setHorizontalAlignment(JTextField.CENTER);
		Font font = new Font("Arial",Font.BOLD,13);
		txtCajas.setFont(font);
		txtCajas.addActionListener(control);
		
		GridBagConstraints gbcAgregar = new GridBagConstraints();
		gbcAgregar.insets = new Insets(0, 0, 5, 5);
		gbcAgregar.gridx = 2;
		gbcAgregar.gridy = 0;
		gbcAgregar.anchor = GridBagConstraints.NORTHWEST;
		add(btnAgregar, gbcAgregar);
		
		lblNewLabel = new JLabel(" ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		lblTime = new JLabel("Time");
		lblTime.setBackground(Color.WHITE);
		lblTime.setVerticalAlignment(SwingConstants.TOP);
		lblTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTime.insets = new Insets(0, 0, 5, 0);
		gbc_lblTime.gridx = 4;
		gbc_lblTime.gridy = 0;
		add(lblTime, gbc_lblTime);

		cajas = new Cajas();
		
		GridBagConstraints gbContenedor = new GridBagConstraints();
		gbContenedor.gridwidth = 5;
		gbContenedor.ipady = 30;
		gbContenedor.insets = new Insets(0, 0, 5, 0);
		gbContenedor.fill = GridBagConstraints.BOTH;
		gbContenedor.gridx = 0;
		gbContenedor.gridy = 2;
		add(cajas, gbContenedor);
		fila = new Fila("");
		
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		add(fila, gbc_panel);
		
		
	}

}
