import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class Ranking extends Panel {

		private JLabel title;
		private JTable tabla;
		 private JButton back;
		GridBagConstraints c = new GridBagConstraints();
		
		public Ranking() {
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
	    	back.setHorizontalAlignment(SwingConstants.LEFT);
	    	back.setFont(new Font("Arial", Font.BOLD, 28));
	    	back.setBackground(Color.GREEN);
	    	
	    	back.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Frame.scrollPaneles.setViewportView(Frame.pStart);
				}
			});
			
			String[] columnas = {"Puesto", "Nombre", "Puntuación", "Tiempo", "Fecha"};
			Object[][] datos = {
		      {1, "Juan", "340", "00:59", "06/05/2023"},
		      {2, "María", "450", "01:20", "06/05/2023"},
		      {3, "Pedro", "210", "01:00", "06/05/2023"},
		      {4, "Laura", "50", "03:30", "06/05/2023"},
		      {5, "Juan", "340", "00:59", "06/05/2023"},
		      {6, "María", "450", "01:20", "06/05/2023"},
		      {7, "Pedro", "210", "01:00", "06/05/2023"},
		      {8, "Laura", "50", "03:30", "06/05/2023"},
		      {9, "Juan", "340", "00:59", "06/05/2023"},
		      {10, "María", "450", "01:20", "06/05/2023"},
		      {11, "Pedro", "210", "01:00", "06/05/2023"},
		      {12, "Laura", "50", "03:30", "06/05/2023"},
		      {13, "Juan", "340", "00:59", "06/05/2023"},
		      {14, "María", "450", "01:20", "06/05/2023"},
		      {15, "Pedro", "210", "01:00", "06/05/2023"},
		      {16, "Laura", "50", "03:30", "06/05/2023"},
		      {17, "Juan", "340", "00:59", "06/05/2023"},
		      {18, "María", "450", "01:20", "06/05/2023"},
		      {19, "Pedro", "210", "01:00", "06/05/2023"},
		      {20, "Laura", "50", "03:30", "06/05/2023"},
		      {21, "Juan", "340", "00:59", "06/05/2023"},
		      {22, "Pedro", "210", "01:00", "06/05/2023"},
		      {23, "Laura", "50", "03:30", "06/05/2023"},
		      {24, "Juan", "340", "00:59", "06/05/2023"},
		      {25, "María", "450", "01:20", "06/05/2023"},
		      {26, "Pedro", "210", "01:00", "06/05/2023"},
		      {27, "Laura", "50", "03:30", "06/05/2023"},
		      {28, "Juan", "340", "00:59", "06/05/2023"},
		      {29, "Pedro", "210", "01:00", "06/05/2023"},
		      {30, "Laura", "50", "03:30", "06/05/2023"},
		      {31, "Juan", "340", "00:59", "06/05/2023"},
		      {32, "María", "450", "01:20", "06/05/2023"},
		      {33, "Pedro", "210", "01:00", "06/05/2023"},
		      {34, "Laura", "50", "03:30", "06/05/2023"},
		      {35, "Juan", "340", "00:59", "06/05/2023"}
		    };
			    
	    	tabla = new JTable(datos, columnas);
	    	tabla.setForeground(Color.WHITE);
	    	tabla.setBackground(Color.BLACK);
	    	tabla.setGridColor(Color.GREEN);
	    	tabla.getTableHeader().setForeground(Color.WHITE);
	    	tabla.getTableHeader().setBackground(Color.BLACK);
	    	
	    	c.gridheight = 1;
	    	c.gridwidth = 1;
	    	c.insets = new Insets(54,200,0,200);
	    	addGB(title, 0,0);
	    	c.insets = new Insets(54,20,0,560);
	    	addGB(back,0,0);
	    	c.insets = new Insets(40,20,100,30);
	    	addGB(new JScrollPane(tabla), 0,1);
	    	
		}void addGB(Component component, int x, int y) {
			c.gridx = x; //posicion columna
			c.gridy = y; //posicion fila
			add(component, c);
		}
}
