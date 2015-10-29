import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MenuPanel extends JPanel implements ActionListener {


	private Icon ILogo, IStart, IHelp, IBest, IExit, IBack;
	private JButton start, help, best, exit, back;
	private BufferedImage tank1, tank2;
	
	private JLabel Logo;
	private Timer timer;
	
	private Box instruction;
	private Box ButtonsBox;
	
	private int x1,x2;
	
	
	public MenuPanel()
	{
		init();
	}
	
	private void init()
	{
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		setBackground(Color.BLACK);
		setFocusable(true);
		setDoubleBuffered(true);
		setVisible(true);
		
		loadImages();
		
		Logo = new JLabel(ILogo);
		Logo.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Logo);
		
		
		loadButtons();
		loadInstruction();
		
		timer = new Timer(5, this);
		timer.start();
		
		x1=-100;
		x2=500;
		
	}
	
	private void loadImages()
	{
		ILogo = new ImageIcon("Graphic\\Menu\\tanks.png");
		IStart = new ImageIcon("Graphic\\Menu\\nowa_gra_button.jpg");
		IHelp = new ImageIcon("Graphic\\Menu\\instrukcja_button.jpg");
		IBest = new ImageIcon("Graphic\\Menu\\najlepsze_wyniki_button.jpg");
		IExit = new ImageIcon("Graphic\\Menu\\wyjscie_button.jpg");
		IBack = new ImageIcon("Graphic\\Menu\\powrot_button.jpg");
		
		try
		{
			tank1 = ImageIO.read(new File("Graphic\\Tank2.png"));
			tank2 = ImageIO.read(new File("Graphic\\ETank2.png"));
		}
		catch(IOException e)
		{
			System.err.println("System error - coś z obrazkami");
			e.printStackTrace();
		}
		
	}
	
	private void loadButtons()
	{
		start = new JButton(IStart);
		help = new JButton(IHelp);
		best = new JButton(IBest);
		exit = new JButton(IExit);
		back = new JButton(IBack);
		
		start.setBorder(BorderFactory.createEmptyBorder());
		start.setContentAreaFilled(false);
		
		help.setBorder(BorderFactory.createEmptyBorder());
		help.setContentAreaFilled(false);
		
		best.setBorder(BorderFactory.createEmptyBorder());
		best.setContentAreaFilled(false);
		
		exit.setBorder(BorderFactory.createEmptyBorder());
		exit.setContentAreaFilled(false);
		
		back.setBorder(BorderFactory.createEmptyBorder());
		back.setContentAreaFilled(false);
		
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		help.setAlignmentX(Component.CENTER_ALIGNMENT);
		best.setAlignmentX(Component.CENTER_ALIGNMENT);
		exit.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		start.addActionListener(this);
		help.addActionListener(this);
		best.addActionListener(this);
		exit.addActionListener(this);
		back.addActionListener(this);
		
		ButtonsBox = Box.createVerticalBox();
		
		ButtonsBox.add(Box.createRigidArea(new Dimension(0,60)));
		ButtonsBox.add(start);
		ButtonsBox.add(Box.createRigidArea(new Dimension(0,20)));
		ButtonsBox.add(help);
		ButtonsBox.add(Box.createRigidArea(new Dimension(0,20)));
		ButtonsBox.add(best);
		ButtonsBox.add(Box.createRigidArea(new Dimension(0,20)));
		ButtonsBox.add(exit);
		ButtonsBox.add(Box.createRigidArea(new Dimension(0,90)));
		
		this.add(ButtonsBox);
		
	}
	
	private void loadInstruction()
	{
		instruction = Box.createVerticalBox();
		
		JLabel string = new JLabel("<html><center>Gra polega na poruszaniu się czołgiem po planszy 2D (widok z"
				+ " góry) i sestrzeleniu wszystkich przeciwników w jak najkrótszym czasie. "
				+ "Gracz posiada 3 szanse oraz napotyka 4 rodzaje przeszkód<br><br>"
				+ "Sterowanie: <br><font color=red>Strzałki</font> - ruch czołgu po planszy <br><font color=red>SPACEBAR</font> - strzał, "
				+ "<br><font color=red>P</font> - pauza <br><font color=red>S</font> - wznowienie gry</center><html> ");
		
		string.setFont(new Font("Verdana",1,13));
		string.setForeground(Color.WHITE);
		
		string.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		instruction.add(Box.createRigidArea(new Dimension(0,55)));
		instruction.add(string);
		instruction.add(Box.createRigidArea(new Dimension(0,10)));
		instruction.add(back);
		
		
	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTanks(g);
    }
	
	public void drawTanks(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(tank1, x1, 160, null);
		g2d.drawImage(tank2, x2, 435, null);
		//Toolkit.getDefaultToolkit().sync();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if (source == start) {
			((Window) getRootPane().getParent()).dispose();
			System.out.println("nowa gra");
			GameFrame gameFrame = new GameFrame("Gra");
			

		} else if (source == help) {
			System.out.println("instrukcja");
			remove(ButtonsBox);
			add(instruction);
			revalidate();
		
		} else if (source == best) {
			System.out.println("najlepsze wyniki");
		
		}else if (source == back) {
			System.out.println("powrot");
			remove(instruction);
			add(ButtonsBox);
			revalidate();
			
		}else if (source == exit) {
			System.out.println("wyjscie");
			System.exit(1);
		}
		
		
		x1+=1;
		x2-=1;
		
		if (x1>500) x1=-100;
		if (x2<-100) x2=500;
		
		repaint();
		
	}

}
