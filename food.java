import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class food{
	Random gen = new Random();
	private int rX, rY, j;
	public food(){
	rX = gen.nextInt(99) * 10;
	rY = gen.nextInt(99) * 10;
	}
	public void draw(Graphics g){
		Color oldColor = g.getColor();
		g.setColor(Color.RED);
		g.fillRect(rX, rY, 10, 10);
		g.setColor(oldColor);
	}
	public int getX(){
		return rX;
	}
	public int getY(){
		return rY;
	}
	public void creatNewC(snakebody s){
		int[] copyx = s.getXArray().clone();
		int[] copyy = s.getYArray().clone();
		j = s.getJoint();

			while(true){
				rX = gen.nextInt(98) * 10;
				rY = gen.nextInt(98) * 10;
				if(rX != copyx[j] && rY != copyy[j]){
					break;
				}
				else{
					j--;
				}

		}
	}
}

