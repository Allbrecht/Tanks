import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MenuFrame extends JFrame {
	
	public MenuPanel PMenu;
	
	public MenuFrame(String tytuł) // konstruktor
	{
		super(tytuł);
		init();
	}
	
	private void init()
	{
		setLayout(new BorderLayout());
		setResizable(false);
		
		PMenu = new MenuPanel();
		
		add(PMenu, BorderLayout.CENTER);
		
		setVisible(true);
		pack();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}
	

}
