import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Game extends JPanel{
	
	private JLabel title;
	 private JLabel letrilla;
	 private JTextField entrada;
	 
	 private int min = 0;
     private int sec = 0;
     private boolean stop = false;
     private JLabel lblTime;
     private JLabel text;
     private JButton back;
     private JButton check;
     private String word;
     private JLabel points;
     
     private int multiplicador;
     private int totalPoints;
     private boolean next = false;
     
     private int ronda;
     private String time;
     
     User user1 = new Start().user1;
     ArrayList<Integer> numerosGenerados;	 
	 GridBagConstraints c = new GridBagConstraints();
	 
	 public Game() {
		 ronda = 0;
		numerosGenerados = new ArrayList<>();
		setLayout(new GridBagLayout());
		setBackground(Color.BLACK); 
    	c.weightx = 1;
    	c.weighty = 1;
    	c.fill = GridBagConstraints.BOTH;
    	
    	title = new JLabel("LETRILLAS ©");
    	title.setHorizontalAlignment(SwingConstants.CENTER);
    	title.setFont(new Font("Arial", Font.BOLD, 36));
    	title.setForeground(Color.WHITE);
    	
    	back = new JButton("←");
//    	back.setIcon(new ImageIcon("src\\caracruz\\monedaok.gif"));
    	back.setHorizontalAlignment(SwingConstants.LEFT);
    	back.setFont(new Font("Arial", Font.BOLD, 28));
//    	back.setForeground(Color.WHITE);
    	back.setBackground(Color.GREEN);
    	
    	back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.scrollPaneles.setViewportView(Frame.pStart);
			}
		});
    	
    	lblTime = new JLabel("00:00");
    	lblTime.setFont(new Font("Arial", Font.BOLD, 18));
    	lblTime.setForeground(Color.WHITE);
    	lblTime.setHorizontalAlignment(SwingConstants.RIGHT);
//    	lblTime.setOpaque(true);
//    	lblTime.setBackground(Color.RED);
    	
    	text = new JLabel("Adivina la palabra desordenada.");
    	text.setForeground(Color.WHITE);
    	text.setFont(new Font("Arial", Font.PLAIN, 16));
    	text.setHorizontalAlignment(SwingConstants.CENTER);
    	
    	points = new JLabel("PUNTOS: 0");
    	points.setForeground(Color.WHITE);
    	points.setFont(new Font("Arial", Font.BOLD, 16));
    	points.setHorizontalAlignment(SwingConstants.CENTER);
    	
    	letrilla = new JLabel("WORD");
		letrilla.setHorizontalAlignment(SwingConstants.CENTER);
    	letrilla.setFont(new Font("HELVETICA", Font.BOLD, 24));
    	letrilla.setForeground(Color.BLACK);
    	letrilla.setOpaque(true);
    	letrilla.setBackground(Color.MAGENTA);
    	
    	String placeholder = "Escribe aquí la palabra";
    	entrada = new JTextField(placeholder);
    	entrada.setFont(new Font("Arial", Font.PLAIN, 18));
    	entrada.setForeground(Color.GRAY);
    	
    	entrada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comprobar();
			}
		});
    	
    	entrada.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (entrada.getText().equals("Escribe aquí la palabra"))
					entrada.setText("");
				entrada.setForeground(Color.BLACK);
			}
		});
    	
    	check = new JButton("COMPROBAR");
    	check.setFont(new Font("Arial", Font.BOLD, 18));
    	check.setForeground(Color.BLACK);
    	check.setBackground(Color.YELLOW);
    	
    	check.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("letrilla: " + letrilla.getText());
				comprobar();
				
					
			}
		});
    	
    	c.gridheight = 1;
    	c.gridwidth = 1;
    	c.insets = new Insets(40,0,0,0);
    	addGB(title, 0,0);
    	c.insets = new Insets(40,20,0,560);
    	addGB(back,0,0);
    	c.insets = new Insets(40,0,0,30);
    	addGB(lblTime, 0, 0);
    	c.insets = new Insets(20,200,10,200);
    	addGB(text, 0, 1);
    	c.insets = new Insets(10,0,20,0);
    	addGB(points, 0, 2);
    	c.insets = new Insets(0,200,10,200);
    	addGB(letrilla, 0, 3);
    	c.insets = new Insets(0,200,50,200);
    	addGB(entrada, 0, 4);
    	c.insets = new Insets(0,200,110,200);
    	addGB(check, 0, 5);
    	startTimer();
    	 randomWord();
    	
    	
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
		            	time = String.format("%02d:%02d", min, sec);
		                lblTime.setText(time);
		            });
		        }
		    });
		    timerThread.start();
		}	
	 private void randomWord() {
		 ArrayList<String> palabras = new ArrayList<String>();
		 try {
	            File archivo = new File("src//diccionarioefren2.txt//");
	            Scanner scanner = new Scanner(archivo);
	            scanner.useDelimiter("\n");
	            while (scanner.hasNext()) {
	                palabras.add(scanner.next());
	            }
	            scanner.close();
	        } catch (FileNotFoundException e) {
	            JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo");
	            return;
	        }
		 
		   // Filtrar y convertir las palabras
	        ArrayList<String> palabrasFiltradas = new ArrayList<String>();
	        for (String palabra : palabras) {
	            String palabraSinAcentos = Normalizer.normalize(palabra, Normalizer.Form.NFD)
	                    .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	            if (palabraSinAcentos.matches("[a-zA-Z]+")) {
	                palabrasFiltradas.add(palabraSinAcentos);
	            }
	        }
	        
	        // Generar un número aleatorio
	        int indiceAleatorio = (int) Math.floor(Math.random() * palabrasFiltradas.size());
	        
	        // Mostrar la palabra seleccionada
	        word = palabrasFiltradas.get(indiceAleatorio);
	        System.out.println("Hacks: " + word);
	        letrilla.setText(desordenar(word));
	        
	        //Tamaño de la palabra
	        multiplicador = word.length();
			 System.out.println("Size: " + multiplicador);
	}
	 private String desordenar(String w) {
		 List<Character> caracteres = new ArrayList<Character>();
	        for(char c : w.toCharArray()) {
	            caracteres.add(c);
	        }
	        Collections.shuffle(caracteres);
	        StringBuilder resultado = new StringBuilder();
	        for(char c : caracteres) {
	            resultado.append(c);
	        }
	        System.out.println("Letrilla: " + resultado.toString());
		return resultado.toString();
	}
	 private String desvelarLetra(String palabra, String desordenada) {
//		 String nueva="ERROR";
		 if (numerosGenerados.size() != palabra.length()) {
			 
		 int pos = (int)(Math.random()*palabra.length()); //posicion aleatoria
		 while (numerosGenerados.contains(pos)) {
			 pos = (int)(Math.random()*palabra.length());
		 }
		 numerosGenerados.add(pos);
		 
		 
		 System.out.println("posRandom: " + pos);
		 char letra = palabra.charAt(pos); //letra aleatoria de la palabra
		 int posDesordenada=0;
		 for (int i = 0; i < desordenada.length(); i++) { //posicion de la letra en la palabra desordenada
			if(desordenada.charAt(i)==letra) {
				posDesordenada = i;
			}
		}
		 char aux = desordenada.charAt(pos);
		 desordenada = desordenada.substring(0, posDesordenada) + aux + desordenada.substring(posDesordenada + 1);
		 System.out.println(desordenada.substring(0, posDesordenada) + " + " + aux + " + " + desordenada.substring(posDesordenada + 1));
		 System.out.println("desordenada-1: " + desordenada);
		 desordenada = desordenada.substring(0, pos) + Character.toUpperCase(letra) + desordenada.substring(pos + 1);
		 System.out.println(desordenada.substring(0, pos) + " + " + letra + " + " + desordenada.substring(pos + 1));
		 System.out.println("desordenada-2: " + desordenada);
		 
		 }
		 return desordenada;
	}
	 private void comprobar() {
			if (word.equals(entrada.getText().toLowerCase()) || word.equals(letrilla.getText().toLowerCase()) ) {
			
				if (next) {
					numerosGenerados = new ArrayList<>();
					letrilla.setBackground(Color.magenta);
					randomWord();
					check.setText("COMPROBAR");
					next = false;
					entrada.setText("");
				}
				else {
						next = true;
				check.setText("SIGUIENTE");
				System.out.println("next: " + next);
					System.out.println("-----BIEN-----");
				letrilla.setText(word.toUpperCase());
				letrilla.setBackground(Color.GREEN);
				int wordPoints = 10 * multiplicador;
				totalPoints = totalPoints + wordPoints;
				points.setText("PUNTOS: " + totalPoints);
				ronda++;
				if (ronda == 7) {
					System.out.println("-----FIN DE RONDAS-----");
					stop = true;
					 sec--;
			            if (sec == 0) {
			                min--;
			                sec = 59;
			            }
						 user1.setTime(time);
						 System.out.println("Time: " + user1.time);
						 user1.setScore(totalPoints);
						 System.out.println("Puntos: " + user1.score);
					entrada.setEnabled(false);
					check.setEnabled(false);	
					
				}
				
				}
			
			}
			else {
				System.out.println("MAL");
				letrilla.setBackground(Color.RED);
				String desvelar = desvelarLetra(word, letrilla.getText());
				letrilla.setText(desvelar);
				entrada.setText("");
				multiplicador--;
			}
		}
}
