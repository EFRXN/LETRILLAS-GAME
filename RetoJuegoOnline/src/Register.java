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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
				if (tfAlias.getText().isEmpty()) {
					tfAlias.setText("Nombre de usuario");
					tfAlias.setForeground(Color.GRAY);
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (tfAlias.getText().equals("Nombre de usuario")) {
					tfAlias.setText("");
					tfAlias.setForeground(Color.BLACK);
				}
					
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
				if (tfEmail.getText().isEmpty()) {
					tfEmail.setText("Email");
					tfEmail.setForeground(Color.GRAY);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (tfEmail.getText().equals("Email")) {
					tfEmail.setText("");
					tfEmail.setForeground(Color.BLACK);
				}
					
			}
		});
    	
    	password = new JPasswordField("Contraseña");
    	password.setForeground(Color.GRAY);
    	password.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (password.getText().isEmpty()) {
					password.setText("Contraseña");
					password.setForeground(Color.GRAY);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (password.getText().equals("Contraseña")) {
					password.setText("");
					password.setForeground(Color.BLACK);
				}
				
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
    	c.insets = new Insets(33,20,0,560);
    	addGB(back,1,0);
    	c.insets = new Insets(33,150,0,150);
    	addGB(title, 1, 0);
    	c.insets = new Insets(45,200,10,200);
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
		if (tfAlias.getText().isEmpty() || tfAlias.getText().equals("Nombre de usuario") ||
				tfEmail.getText().isEmpty() || tfEmail.getText().equals("Email") ||
				password.getText().isEmpty() || password.getText().equals("Contraseña")) {
			JOptionPane.showMessageDialog(null, "Completa todos los campos para registrarte", "Registrarse", JOptionPane.WARNING_MESSAGE);
		}
		else {
			if (validarEmail(tfEmail.getText())) {
				System.out.println("Email valido!");
				Frame.scrollPaneles.setViewportView(Frame.pStart);
				JOptionPane.showMessageDialog(null, "Registrado Correctamente!", "Registrarse", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "El email no es valido", "Registrarse", JOptionPane.WARNING_MESSAGE);
			}				
		}
		
	}
	private boolean validarEmail(String email) {
		// Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        // El email a validar
 
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
	}
	
}
