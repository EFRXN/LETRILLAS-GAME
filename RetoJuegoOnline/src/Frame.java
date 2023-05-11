import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Frame extends JFrame{
	
	
	static Start pStart;
	static JScrollPane scrollPaneles;
	static User user1 = new User();
	
	public Frame() {
		setTitle("LETRILLAS ©");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 610);
        setLocationRelativeTo(null);
        setVisible(true);
        setPanels();
	}
	private void setPanels() {
		
		pStart = new Start();
		scrollPaneles = new JScrollPane();
		scrollPaneles.setSize(new Dimension(650, 610));
		scrollPaneles.setViewportView(pStart);
		add(scrollPaneles);
	}
}
