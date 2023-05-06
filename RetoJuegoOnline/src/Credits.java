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
import javax.swing.SwingConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Credits extends Panel {

	 private JLabel title;
	 private JButton back;
	 private JLabel lblEmpresa;
	 private JLabel lblDescripcion;
	 private JLabel lblObjetivo;
	 private JLabel lblDificultad;
	 private JLabel lblTipo;
	 private JLabel lblPlataformas;
	 private JLabel lblPrecio;
	 private JLabel lblDesarrollador;
	 private JLabel lblMiembros;
	 
	 GridBagConstraints c = new GridBagConstraints();
	 
	 public Credits() {
		 setLayout(new GridBagLayout());
			setBackground(Color.BLACK); 
	    	c.weightx = 1;
	    	c.weighty = 1;
	    	c.fill = GridBagConstraints.BOTH;
	    	
	    	//Creacion Objetos
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
	    	lblEmpresa = new JLabel();
	    	Style(lblEmpresa);
	    	lblDescripcion = new JLabel();
	    	Style(lblDescripcion);
	    	lblObjetivo = new JLabel();
	    	Style(lblObjetivo);
	    	lblDificultad = new JLabel();
	    	Style(lblDificultad);
	    	lblTipo = new JLabel();
	    	Style(lblTipo);
	    	lblPlataformas = new JLabel();
	    	Style(lblPlataformas);
	    	lblPrecio = new JLabel();
	    	Style(lblPrecio);
	    	lblDesarrollador = new JLabel();
	    	Style(lblDesarrollador);
	    	lblMiembros = new JLabel();
	    	Style(lblMiembros);
	    	
	    	//Añadir objetos al panel
	    	c.gridheight = 1;
	    	c.gridwidth = 1;
	    	c.insets = new Insets(54,150,50,150);
	    	addGB(title, 0, 0);
	    	c.insets = new Insets(54,20,50,560);
	    	addGB(back,0,0);
	    	
	    	c.insets = new Insets(30,80,0,0);
	    	addGB(lblEmpresa,0,1);
	    	c.insets = new Insets(20,80,0,0);
	    	addGB(lblDescripcion,0,2);
	    	addGB(lblObjetivo,0,3);
	    	addGB(lblDificultad,0,4);
	    	addGB(lblTipo,0,5);
	    	addGB(lblPlataformas,0,6);
	    	addGB(lblPrecio,0,7);
	    	addGB(lblDesarrollador,0,8);
	    	c.insets = new Insets(20,80,150,0);
	    	addGB(lblMiembros,0,9);
	    	datosXML();
	}
	 void addGB(Component component, int x, int y) {
			c.gridx = x; //posicion columna
			c.gridy = y; //posicion fila
			add(component, c);
		}
	 private void Style(Component com) {
		com.setFont(new Font("Arial", Font.PLAIN, 14));
		com.setForeground(Color.WHITE);
	}
	 private void datosXML() {
		 try {
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse("src//creditos.xml//");

	            //Atributo "nombre" de "empresa"
	            Node empresaNode = doc.getElementsByTagName("empresa").item(0);
	            String nombreEmpresa = ((Element) empresaNode).getAttribute("nombre");
	            lblEmpresa.setText("EMPRESA: " + nombreEmpresa);
	            System.out.println(nombreEmpresa);
	            
	            //Elemento "descripcion de "juego"
	            Node juegoNode = doc.getElementsByTagName("juego").item(0);
	            Node descripcionNode = ((Element) juegoNode).getElementsByTagName("descripcion").item(0);
	            String descripcion = descripcionNode.getTextContent();	
	            lblDescripcion.setText("DESCIRPCIÓN: " + descripcion);
	            
	            //Elemento "descripcion de "juego"
	            Node objetivoNode = ((Element) juegoNode).getElementsByTagName("objetivo").item(0);
	            String objetivo = objetivoNode.getTextContent();	
	            lblObjetivo.setText("OBJETIVO: " + objetivo);
	            
	            //Atributo "nivel" de "dificultad
	            Node dificultadNode = doc.getElementsByTagName("dificultad").item(0);
	            String dificultad = ((Element) dificultadNode).getAttribute("nivel"); 
	            lblDificultad.setText("DIFICULTAD: " + dificultad);
	            
	            //Elemento "tipo" de "juego"
	            Node tipoNode = ((Element) juegoNode).getElementsByTagName("tipo").item(0);
	            String tipo = tipoNode.getTextContent();	
	            lblTipo.setText("TIPO: " + tipo);	
	            
	            //Elementos "plataforma" de "plataformas"
	            NodeList plataformasNodeList = ((Element) juegoNode).getElementsByTagName("plataforma");
	            StringBuilder plataformas = new StringBuilder();
	            plataformas.append("PLATAFORMAS: ");
	            for (int i = 0; i < plataformasNodeList.getLength(); i++) {
	                Node plataformaNode = plataformasNodeList.item(i);
	                String plataforma = plataformaNode.getTextContent();
	                plataformas.append(plataforma);
	                if (i < plataformasNodeList.getLength() - 1) {
	                    plataformas.append(", ");
	                }
	            }
	            lblPlataformas.setText(plataformas.toString());
	            
	            //Elemento "precio" de "juego" y atributo "moneda" de "precio"
	            Node precioNode = ((Element) juegoNode).getElementsByTagName("precio").item(0);
	            String precio = precioNode.getTextContent();	
	            precioNode = doc.getElementsByTagName("precio").item(0);
	            String moneda = ((Element) precioNode).getAttribute("moneda"); 
	            lblPrecio.setText("PRECIO: " + precio + moneda);
	            
	            //Elemento "desarrollador" de "juego"
	            Node developerNode = ((Element) juegoNode).getElementsByTagName("desarrollador").item(0);
	            String developer = developerNode.getTextContent();	
	            lblDesarrollador.setText("DESARROLLADOR: " + developer);
	            
	            //Elementos "miembro" de "empresa"
	            NodeList miembrosNodeList = ((Element) empresaNode).getElementsByTagName("miembro");
	            StringBuilder miembros = new StringBuilder();
	            miembros.append("MIEMBROS: ");
	            for (int i = 0; i < miembrosNodeList.getLength(); i++) {
	                Node miembroNode = miembrosNodeList.item(i);
	                String miembro = miembroNode.getTextContent();
	                miembros.append(miembro);
	                if (i < miembrosNodeList.getLength() - 1) {
	                    miembros.append(", ");
	                }
	            }
	            lblMiembros.setText(miembros.toString());
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	 
}
