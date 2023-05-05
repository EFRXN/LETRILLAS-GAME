import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Start extends JPanel{

	//Declaración de objetos
    private JLabel title;
    private JTextField tfAlias;
    private JButton register;
    private JButton bPlay, bRanking;
    private JButton credits;
    private JPasswordField password;
    
    GridBagConstraints c = new GridBagConstraints();
    Game pGame;
    Register pRegister;
    User user1 = new User();
	public Start() {

		setLayout(new GridBagLayout());
		setBackground(Color.BLACK); 
    	c.weightx = 1;
    	c.weighty = 1;
    	c.fill = GridBagConstraints.BOTH;
		
		//Creación de objetos
		title = new JLabel("LETRILLAS ©");
		title.setHorizontalAlignment(SwingConstants.CENTER);
    	title.setFont(new Font("Arial", Font.BOLD, 36));
    	title.setForeground(Color.WHITE);
    	
		tfAlias = new JTextField("Nombre de usuario");
    	tfAlias.setForeground(Color.GRAY);
    	
    	tfAlias.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (tfAlias.getText().equals("Nombre de usuario"))
					tfAlias.setText("");
				tfAlias.setForeground(Color.BLACK);
			}
		});
    	tfAlias.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfAlias.getText().isEmpty() || tfAlias.getText().equals("Nombre de usuario")) {
					System.out.println("Escribe un nombre de usuario");
				}
				else
				play();
			}
		});
    	
    	password = new JPasswordField("Contraseña");
    	password.setForeground(Color.GRAY);
    	password.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				password.setText("");
				password.setForeground(Color.BLACK);
				
			}
		});
		
    	register = new JButton("REGISTRAR");
    	register.setBackground(Color.DARK_GRAY);
    	register.setForeground(Color.WHITE);
    	register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pRegister = new Register();
				Frame.scrollPaneles.setViewportView(pRegister);
			}
		});
    	
		bPlay = new JButton("JUGAR");
		bPlay.setBackground(Color.GREEN);
		bPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfAlias.getText().isEmpty() || tfAlias.getText().equals("Nombre de usuario")) {
					System.out.println("Escribe un nombre de usuario");
				}
				else
				play();
			}
		});
		
		bRanking = new JButton("RANKING");
		bRanking.setBackground(Color.GREEN);
		
		credits = new JButton("CRÉDITOS");
		credits.setForeground(Color.WHITE);
		credits.setBackground(null);
		
    	//Añadir objetos al panel
    	c.gridheight = 1;
    	c.gridwidth = 1;
    	c.insets = new Insets(45,150,30,150);
    	addGB(title, 1, 0);
    	c.insets = new Insets(30,200,10,200);
    	addGB(tfAlias, 1, 1);
    	c.insets = new Insets(0,200,10,200);
    	addGB(password, 1, 2);
    	c.insets = new Insets(0,200,10,200);
    	addGB(register, 1, 3);
    	c.insets = new Insets(0,200,10,200);
    	addGB(bPlay, 1, 4);
    	c.insets = new Insets(0,200,30,200);
    	addGB(bRanking, 1, 5);
    	c.insets = new Insets(50,200,50,200);
    	addGB(credits, 1, 6);

	}
	void addGB(Component component, int x, int y) {
		c.gridx = x; //posicion columna
		c.gridy = y; //posicion fila
		add(component, c);
	}
	public void play() {
		user1.setAlias(tfAlias.getText());
		System.out.println("Nombre: " + user1.alias);
		pGame = new Game();
		Frame.scrollPaneles.setViewportView(pGame);
	}
	
}
