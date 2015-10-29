import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {

	
	public ControlPanel controlPanel;
	public GamePanel gamePanel;
	
	
	private static final long serialVersionUID = 1L;
	
	public GameFrame(String title) // konstruktor
	{
		super(title);
		init();
	}
	
	private void init()
	{
		setLayout(new BorderLayout());
		
		controlPanel = new ControlPanel();
		gamePanel = new GamePanel();
		
		add(gamePanel, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.EAST);

		setVisible(true);
		pack();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}

}