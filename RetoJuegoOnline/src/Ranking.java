import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import org.bson.Document;

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
	    	List<Document> documentos = AccesoMongo.obtenerEstadisticas();
	    	
	    	String[] columnas = {"Posición", "Nombre", "Puntuación", "Tiempo", "Fecha"};
	        Object[][] datos = new Object[documentos.size()][columnas.length];
	        for (int i = 0; i < documentos.size(); i++) {
	            Document documento = documentos.get(i);
	            datos[i][0] = i + 1;
	            datos[i][1] = documento.getString("nombre");
	            datos[i][2] = documento.getInteger("puntuacion");
	            datos[i][3] = documento.getString("tiempo");
	            datos[i][4] = documento.getDate("fecha");
	        }
			    
	        tabla = new JTable(datos, columnas);
	        JScrollPane scrollPane = new JScrollPane(tabla);
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
	    	addGB(scrollPane, 0,1);
	    	
		}void addGB(Component component, int x, int y) {
			c.gridx = x; //posicion columna
			c.gridy = y; //posicion fila
			add(component, c);
		}
}
