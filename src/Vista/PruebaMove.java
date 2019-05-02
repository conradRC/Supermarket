package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import java.awt.Color;

/**
 *
 * @author RouterUIZ007 <router.uiz.360@gmail.com>
 */
public class PruebaMove extends JPanel implements KeyListener {
    JPanel sup=new JPanel();
    Graphics g = null;
    ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("../Carrera/a.png")).getImage());
    //ImageIcon ima=new ImageIcon("/imagenes/a.png");
    Icon i = new ImageIcon(image.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

    JButton btn=new JButton("Prueba");


    public PruebaMove() {
        sup.addKeyListener(this);
        
        //btnNewButton.setIcon(new ImageIcon(PruebaMove.class.getResource("/Carrera/1.png")));
        sup.setFocusable(true);
        add(sup);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W' || e.getKeyChar() == KeyEvent.VK_UP) {
            this.setLocation(this.getX(), this.getY() - 5);
        }
        if (e.getKeyChar() == 's' || e.getKeyChar() == 'S' || e.getKeyChar() == KeyEvent.VK_DOWN) {
            this.setLocation(this.getX(), this.getY() + 5);
        }
        if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A' || e.getKeyChar() == KeyEvent.VK_LEFT) {
            this.setLocation(this.getX() - 5, this.getY());
        }
        if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D' || e.getKeyChar() == KeyEvent.VK_RIGHT) {
            this.setLocation(this.getX()+5, this.getY());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void paintComponent(Graphics a) {
        super.paintComponent(a);
        i.paintIcon(this, a, 70, 70);
        //g = a;
        //g.drawImage(ima.getImage(), 50, 50, x, y, null);

    }

    public static void main(String[] args) {
    	PruebaMove ele = new PruebaMove();
        JFrame f = new JFrame();
        f.setSize(1280, 720);
        f.setVisible(true);;
        f.setTitle("Control xD");
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.getContentPane().add(ele);
    }

}
