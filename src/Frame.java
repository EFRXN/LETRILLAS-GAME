import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Frame extends JFrame{
	
	
	Start pStart;
	static JScrollPane scrollPaneles;
	
	public Frame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setPanels();
	}
	private void setPanels() {
		
		pStart = new Start();
		scrollPaneles = new JScrollPane();
		scrollPaneles.setSize(new Dimension(600, 500));
		scrollPaneles.setViewportView(pStart);
		add(scrollPaneles);
	}
}
