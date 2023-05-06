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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Start extends JPanel{

	//Declaración de objetos
    private JLabel title;
    private JTextField tfAlias;
    private JButton register;
    private JButton recuperar;
    private JButton bPlay, bRanking;
    private JButton credits;
    private JPasswordField password;
    
    GridBagConstraints c = new GridBagConstraints();
    Game pGame;
    Register pRegister;
    Ranking pRanking;
    Credits pCredits;
//    User user1 = new User();
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
				if (tfAlias.getText().equals("")) {
					tfAlias.setText("Nombre de usuario");
					tfAlias.setForeground(Color.GRAY);
				}
					
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (tfAlias.getText().equals("Nombre de usuario"))
					tfAlias.setText("");
				tfAlias.setForeground(Color.BLACK);
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
		
    	recuperar = new JButton("He olvidado la contraseña");
    	recuperar.setBackground(Color.DARK_GRAY);
    	recuperar.setForeground(Color.WHITE);
    	recuperar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String texto = JOptionPane.showInputDialog(null, "Escribe tu Email y te enviaremos un correo para recuperar tu contraseña.", "Recuperar contraseña", JOptionPane.NO_OPTION);
			    
			    if (texto == null || validarEmail(texto)==false ) {
			      System.out.println("Inserte un Email valido");
			      JOptionPane.showMessageDialog(null, "El Email no es valido o no existe en nuestra base de datos.", "Recuperar contraseña", JOptionPane.ERROR_MESSAGE);
			    } else {
			      System.out.println("Email correcto");
			      JOptionPane.showMessageDialog(null, "Mensaje enviado correctamente", "Recuperar contraseña", JOptionPane.INFORMATION_MESSAGE);
			    }
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
				if(validarLogin() == false) {
					JOptionPane.showMessageDialog(null, "Esribe un nombre de usuario y contraseña validos.", "Usuario o contraseña incorrectos", JOptionPane.WARNING_MESSAGE);
				}
				else
				play();
			}
		});
		
		bRanking = new JButton("RANKING");
		bRanking.setBackground(Color.GREEN);
		bRanking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pRanking = new Ranking();
				Frame.scrollPaneles.setViewportView(pRanking);
			}
		});
		
		credits = new JButton("CRÉDITOS");
		credits.setForeground(Color.WHITE);
		credits.setBackground(null);
		credits.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pCredits = new Credits();
				Frame.scrollPaneles.setViewportView(pCredits);
			}
		});
		
    	//Añadir objetos al panel
    	c.gridheight = 1;
    	c.gridwidth = 1;
    	c.insets = new Insets(47,150,0,150);
    	addGB(title, 1, 0);
    	c.insets = new Insets(60,200,0,200);
    	addGB(tfAlias, 1, 1);
    	c.insets = new Insets(5,200,0,200);
    	addGB(password, 1, 2);
    	c.insets = new Insets(5,200,0,200);
    	addGB(recuperar, 1, 3);
    	c.insets = new Insets(5,200,0,200);
    	addGB(register, 1, 4);
    	c.insets = new Insets(20,200,0,200);
    	addGB(bPlay, 1, 5);
    	c.insets = new Insets(5,200,0,200);
    	addGB(bRanking, 1, 6);
    	c.insets = new Insets(70,200,50,200);
    	addGB(credits, 1, 7);
	}
	void addGB(Component component, int x, int y) {
		c.gridx = x; //posicion columna
		c.gridy = y; //posicion fila
		add(component, c);
	}
	public void play() {
		Frame.user1.setAlias(tfAlias.getText());
		userData("PLAY");
		pGame = new Game();
		Frame.scrollPaneles.setViewportView(pGame);
		
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
	private boolean validarLogin() {
		if(tfAlias.getText().isEmpty() || tfAlias.getText().equals("Nombre de usuario") ||
				password.getText().isEmpty() || password.getText().equals("Contraseña")) {
			return false;
		}
		else
			return true;
	}
	
	private void userData(String title) {
		System.out.println("--" + title + "--");
		System.out.println("User name: " + Frame.user1.alias);
		System.out.println("Score: " + Frame.user1.score);
		System.out.println("Time: " + Frame.user1.time);
	}
	
}
