import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Start extends JFrame {

	//Declaración de objetos
    private JLabel title;
    private JTextField tfAlias;
    private JButton bPlay, bRanking;
    private JPanel panel;
    private JButton credits;
    GridBagConstraints c = new GridBagConstraints();
	
	public Start() {
		super("LETRILLAS");
		//Creación de objetos
		title = new JLabel("LETRILLAS ©");
		title.setHorizontalAlignment(SwingConstants.CENTER);
    	title.setFont(new Font("Arial", Font.BOLD, 36));
    	title.setForeground(Color.WHITE);
    	
		tfAlias = new JTextField("Username");
    	tfAlias.setForeground(Color.BLACK);
		
		bPlay = new JButton("PLAY");
		bPlay.setBackground(Color.GREEN);
		
		bRanking = new JButton("RANKING");
		bRanking.setBackground(Color.GREEN);
		
		credits = new JButton("Credits");
		credits.setForeground(Color.WHITE);
		credits.setBackground(null);
		
		//Panel
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.BLACK); 
    	c.weightx = 1;
    	c.weighty = 1;
    	c.fill = GridBagConstraints.BOTH;
    	
    	//Añadir objetos al panel
    	c.gridheight = 1;
    	c.gridwidth = 1;
    	c.insets = new Insets(70,150,30,150);
    	addGB(title, 1, 0);
    	 
    	c.insets = new Insets(50,200,10,200);
    	addGB(tfAlias, 1, 1);
    	c.insets = new Insets(0,200,10,200);
    	addGB(bPlay, 1, 2);
    	c.insets = new Insets(0,200,50,200);
    	addGB(bRanking, 1, 3);
    	c.insets = new Insets(50,200,20,200);
    	addGB(credits, 1, 4);

    	add(panel);
        
        // Visualizar Objetos
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	void addGB(Component component, int x, int y) {
		c.gridx = x; //posicion columna
		c.gridy = y; //posicion fila
		panel.add(component, c);
	}
	
	public static void main(String[] args) {
		new Start();
	}
	
}
