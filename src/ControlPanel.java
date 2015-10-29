
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements ActionListener {
	
	private JButton Start, Stop, Exit;
	private JLabel LCzas, LPoziom;
	public boolean stan;

	public ControlPanel() {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		Start = new JButton("Start");
		Stop = new JButton("Stop");
		Exit = new JButton("Exit");
		LCzas = new JLabel("Czas Gry 'TIMER'");
		LPoziom = new JLabel("Który Poziom");
		

		Start.addActionListener(this);
		Stop.addActionListener(this);
		Exit.addActionListener(this);		
		
		Box theBox = Box.createVerticalBox();
		
		Start.setAlignmentX(Component.CENTER_ALIGNMENT);
		Stop.setAlignmentX(Component.CENTER_ALIGNMENT);
		LCzas.setAlignmentX(Component.CENTER_ALIGNMENT);
		LPoziom.setAlignmentX(Component.CENTER_ALIGNMENT);
		Exit.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		theBox.add(Start);
		theBox.add(Stop);
		theBox.add(LCzas);
		theBox.add(LPoziom);
		theBox.add(Box.createVerticalGlue());
		theBox.add(Exit);
		this.add(theBox);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == Start) {
			System.out.println("start gry");// start w¹tku gry
			GamePanel.play = true;


		} else if (source == Stop) {
			System.out.println("Stop gry");// Stop W¹tku z gr¹
			GamePanel.play = false;
		} else if (source == Exit) {
			System.exit(1);
		}

	}

}