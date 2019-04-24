package view;

import javax.swing.JFrame;

/**
 * @author Conrad
 *
 */

public class Principal extends JFrame {
	Componentes componentes = new Componentes();
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,600);
		setLocationRelativeTo(null);
		add(componentes);
	}

	public static void main(String[] args) {
		Principal frame = new Principal();
		frame.setVisible(true);
	}
}
