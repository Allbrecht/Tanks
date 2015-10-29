import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Tank {

	private static Image tank_up;
	private static Image tank_down;
	private static Image tank_right;
	private static Image tank_left;
	public static Image actual;
	public static boolean up, down, right, left;
	public  static int x, y;

	public Tank(int[][] board)
	{
		try
		{
			tank_up=ImageIO.read(new File("Graphic\\Tank.png"));
			tank_down=ImageIO.read(new File("Graphic\\Tank3.png"));
			tank_right=ImageIO.read(new File("Graphic\\Tank2.png"));
			tank_left=ImageIO.read(new File("Graphic\\Tank4.png"));
		}
		catch(IOException e)
		{
			System.err.println("System error - coœ z obrazkami");
			e.printStackTrace();
		}
		setPosition(board);
		setTankUp();
		up=false;
		
	}
	
/*	public void drawTank(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(actual,x,y,null);
	}*/

	public static void setTankUp() {
		actual=tank_up;
		up=true;
		down=false;
		right=false;
		left=false;
	}
	public static void setTankDown() {
		actual = tank_down;
		left = false;
		right = false;
		up = false;
		down = true;
	}
	public static void setTankRight() {
		actual = tank_right;
		left = false;
		right = true;
		up = false;
		down = false;
	}
	public static void setTankLeft() {
		actual = tank_left;
		left = true;
		right = false;
		up = false;
		down = false;
	}
	public boolean isTankLeft(){
		if(left==true){
			return true;
		}
		else
			return false;
	}
	public boolean isTankRight(){
		if(right==true){
			return true;
		}
		else
			return false;
	}
	public boolean isTankUp(){
		if(up==true){
			return true;
		}
		else
			return false;
	}
	public boolean isTankDown(){
		if(down==true){
			return true;
		}
		else
			return false;
	}
	public void setPosition(int[][] board){
		for(int i=0; i< board.length; i++)
			for(int j=0; j< board[i].length; j++) {
				if (board[i][j] == 5) {
					x = j;
					y = i;
				}
			}
	}
}
