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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Register extends JPanel{

	//Declaración de objetos
    private JLabel title;
    private JTextField tfAlias;
    private JButton bPlay;
    private JPasswordField password;
    private JTextField tfEmail;
    private JButton back;
    
    GridBagConstraints c = new GridBagConstraints();
    Game pGame;
    User user1 = new User();
	public Register() {

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
			}
		});
    	
    	back = new JButton("←");
    	back.setHorizontalAlignment(SwingConstants.LEFT);
    	back.setFont(new Font("Arial", Font.BOLD, 28));
    	back.setBackground(Color.GREEN);
    	
    	back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.scrollPaneles.setViewportView(Frame.pStart);
			}
		});
    	
    	tfAlias.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfAlias.getText().isEmpty() || tfAlias.getText().equals("Nombre de usuario")) {
					System.out.println("Escribe un nombre de usuario");
				}
				else
				Registrarse();
			}
		});
    	
    	tfEmail = new JTextField("Email");
    	tfEmail.setForeground(Color.GRAY);
    	tfEmail.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (tfEmail.getText().equals("Email"))
					tfEmail.setText("");
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
				
			}
		});
		
		bPlay = new JButton("REGISTRARSE");
		bPlay.setBackground(Color.GREEN);
		bPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Registrarse();
			}
		});
		
		
    	//Añadir objetos al panel
    	c.gridheight = 1;
    	c.gridwidth = 1;
    	c.insets = new Insets(40,20,0,560);
    	addGB(back,1,0);
    	c.insets = new Insets(40,150,0,150);
    	addGB(title, 1, 0);
    	c.insets = new Insets(50,200,10,200);
    	addGB(tfAlias, 1, 1);
    	c.insets = new Insets(0,200,10,200);
    	addGB(tfEmail, 1, 2);
    	c.insets = new Insets(0,200,10,200);
    	addGB(password, 1, 3);
    	c.insets = new Insets(0,200,150,200);
    	addGB(bPlay, 1, 4);

	}
	void addGB(Component component, int x, int y) {
		c.gridx = x; //posicion columna
		c.gridy = y; //posicion fila
		add(component, c);
	}
	public void Registrarse() {
		System.out.println("Registrado con exito");
		Frame.scrollPaneles.setViewportView(Frame.pStart);
	}
	
}
