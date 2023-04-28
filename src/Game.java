import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Game extends JPanel{
	
	 private JLabel letrilla;
	 private JTextField entrada;
	 
	 private int min = 0;
     private int sec = 0;
     private boolean stop = false;
     private JLabel lblTime;
	 
	 GridBagConstraints c = new GridBagConstraints();
	 
	 public Game() {
		setLayout(new GridBagLayout());
		setBackground(Color.BLACK); 
    	c.weightx = 1;
    	c.weighty = 1;
    	c.fill = GridBagConstraints.BOTH;
    	
    	lblTime = new JLabel("00:00");
		lblTime.setHorizontalAlignment(SwingConstants.RIGHT);
    	lblTime.setFont(new Font("Arial", Font.BOLD, 18));
    	lblTime.setForeground(Color.WHITE);
//    	lblTime.setOpaque(true);
//    	lblTime.setBackground(Color.RED);
    	
    	letrilla = new JLabel("RONADORDE");
		letrilla.setHorizontalAlignment(SwingConstants.CENTER);
    	letrilla.setFont(new Font("Arial", Font.BOLD, 24));
    	letrilla.setForeground(Color.WHITE);
    	letrilla.setOpaque(true);
    	letrilla.setBackground(Color.RED);
    	
    	entrada = new JTextField();
    	entrada.setFont(new Font("Arial", Font.PLAIN, 18));
    	entrada.setForeground(Color.BLACK);
    	
    	c.gridheight = 1;
    	c.gridwidth = 1;
    	c.insets = new Insets(0,20,0,20);
    	addGB(lblTime, 0, 0);
    	c.insets = new Insets(50,200,50,200);
    	addGB(letrilla, 0, 1);
    	c.insets = new Insets(0,200,150,200);
    	addGB(entrada, 0, 2);
    	
    	startTimer();
    	
	}
	 void addGB(Component component, int x, int y) {
			c.gridx = x; //posicion columna
			c.gridy = y; //posicion fila
			add(component, c);
		}
	 
	 public void startTimer() {
		    Thread timerThread = new Thread(() -> {
		        while (!stop) {
		            try {
		                Thread.sleep(1000);
		            } catch (InterruptedException e) {
		                return;
		            }
		            sec++;
		            if (sec == 60) {
		                min++;
		                sec = 0;
		            }
		            SwingUtilities.invokeLater(() -> {
		                lblTime.setText(String.format("%02d:%02d", min, sec));
		            });
		        }
		    });
		    timerThread.start();
		}
	 
	 
	 
	 
}
