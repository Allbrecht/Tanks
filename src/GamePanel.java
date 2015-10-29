import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class GamePanel extends JPanel implements Runnable{

	private final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	private int HEIGHT,WIDTH;
	public static Tank player;
	private int[][] gameLevel;
	public static Thread animator;
	public static boolean play;
	private int level = 1;
	private int sleep = 5;
	private LevelBoard lvlBoard;
	
	
	public GamePanel() {
		initPanelGry();
	}
	
	public void initPanelGry()
	{

		HEIGHT = 300;
		WIDTH = 800;
		lvlBoard = new LevelBoard();
		LevelGetter lvlGetter = new LevelGetter();
		gameLevel = lvlGetter.getLevel(level);
		player = new Tank(gameLevel);
		play = false;
		setKeyBinding();

		setBackground(Color.gray);

		setDoubleBuffered(true);
		setVisible(true);
		addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent ce) {
                WIDTH = ce.getComponent().getWidth();
                HEIGHT = ce.getComponent().getHeight();
            }
        });


			startGame();

		}

	private void setKeyBinding() {

		Action goLeft = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(play){
					if(player.isTankLeft())
						move();
					else
						player.setTankLeft();
					//sleep(moveSleep);
				}


			}
		};
		Action goRight = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(play){
					if(player.isTankRight())
						move();
					else
						player.setTankRight();
					//sleep(moveSleep);
				}
			}
		};
		Action goUp = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(play){
					if(player.isTankUp())
						move();
					else
						player.setTankUp();
					//sleep(moveSleep);
				}
			}
		};
		Action goDown = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(play){
					if(player.isTankDown())
						move();
					else
						player.setTankDown();
					//sleep(moveSleep);
				}
			}
		};
		getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), "goLeft");
		getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), "goRight");
		getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), "goUp");
		getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), "goDown");
		getActionMap().put("goLeft", goLeft);
		getActionMap().put("goRight", goRight);
		getActionMap().put("goUp", goUp);
		getActionMap().put("goDown", goDown);

	}

	private void drawBoard(Graphics g, int level){
		Graphics2D g2d = (Graphics2D) g;

		int width = WIDTH / gameLevel[0].length;
		int height = HEIGHT /gameLevel.length;
		int px = 0;
		int py = 0;
		for (int i = 0; i < gameLevel.length; i++) {
			for (int j = 0; j < gameLevel[0].length; j++) {
				switch(gameLevel[i][j]){
					case 1: g2d.drawImage(lvlBoard.brick.getScaledInstance(width, height,Image.SCALE_FAST ), px,
							py, null);
						break;
					case 2: g2d.drawImage(lvlBoard.grass.getScaledInstance(width, height,Image.SCALE_FAST ), px,
							py, null);
						break;
					case 3: g2d.drawImage(lvlBoard.water.getScaledInstance(width, height,Image.SCALE_FAST ), px,
							py, null);
						break;
					case 5: g2d.drawImage(player.actual.getScaledInstance(width, height,Image.SCALE_FAST), px,
							py, null);
						break;
					case 6: g2d.drawImage(lvlBoard.iron.getScaledInstance(width, height,Image.SCALE_FAST ), px,
							py, null);
						break;
				}
				px = px + width;
			}
			px = 0;
			py = py + height;
		}
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawBoard(g,level);
	}
	
	private void move()//mechanika gry
	{
			if (player.up){
				System.out.println("up");
                if((gameLevel[player.y-1][player.x] == 0)||(gameLevel[player.y-1][player.x]) ==2) {
					gameLevel[player.y-1][player.x] = 5;
					gameLevel[player.y][player.x] = 0;
                    player.y--;
				}
			}
			if (player.down){
				if((gameLevel[player.y +1][player.x] == 0)||(gameLevel[player.y +1][player.x] == 2)) {
					gameLevel[player.y][player.x] = 0;
					gameLevel[player.y+1][player.x] = 5;
                    player.y++;
				}
			}
			if (player.right) {
				if((gameLevel[player.y][player.x+1] == 0)||(gameLevel[player.y][player.x+1] ==2)) {
					gameLevel[player.y][player.x] = 0;
					gameLevel[player.y][player.x+1] = 5;
                    player.x++;
				}
			}
			if (player.left){
				if((gameLevel[player.y][player.x - 1] == 0)||(gameLevel[player.y][player.x - 1] == 2)) {
					gameLevel[player.y][player.x] = 0;
					gameLevel[player.y][player.x-1] = 5;
                    player.x--;
				}
			}

	}

	
	public void startGame()
	{
		animator = new Thread(this);
        animator.start();
	}
	
	@Override
	public void run() {


        while (true) {

        	if(play)
        	{

                repaint();
        	}
        	//repaint();

			sleep(sleep);
		}
		
	}

	private void sleep(int time) {
		try {
           animator.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Interrupted: " + e.getMessage());
        }
	}

}
