import javax.swing.*;
import java.awt.*;
public class snakebody{
	private boolean north, south, east, west;
	private int height, width, startX, startY, speed, joint, u;
	private int[] x = new int[1000];
	private int[] y = new int[1000];
	public snakebody(int x, int y, int h, int w, int s, int j){
	startX = x;
	startY = y;
	height = h;
	width = w;
	speed = s;
	joint = j;
	}
	public void start(){
		x[0] = startX;
		y[0] = startY;
	}
	public void setX(int x){
	startX = x;
	}
	public void setY(int y){
	startY = y;
	}
	public void setHeight(int h){
	height = h;
	}
	public void setWdith(int w){
	width = w;
	}
	public int getX(){
	return startX;
	}
	public int getY(){
	return startY;
	}
	public int getHeight(){
	return height;
	}
	public int getWidth(){
	return width;
	}
	public int getSpeed(){
		return speed;
	}
	public void setSpeed(int s){
		speed = s;
	}
	public void move(){
		for(int i = joint - 1 ; i > 0; i--){
					x[i] = x[(i-1)];
					y[i] = y[(i-1)];

		}
		if(south == true){
			y[0] = y[0] + speed;
		}
		if(east == true){
			x[0] = x[0] + speed;
		}
		if(north == true){
			y[0] = y[0] - speed;
		}
		if(west == true){
			x[0] = x[0] - speed;
		}
	}
	public void drawBody(Graphics g){
		Color oldColor = g.getColor();
		u = 0;
		for(int i = joint; u != i; u++){
			g.drawRect(x[u],y[u], width, height);
		}
		g.setColor(oldColor);

	}
	public int getJoint(){
		return joint;
	}
	public void setJoint(int j){
		joint = j;
	}
	public void addJoint(){
		joint = joint + 1;
	}
	public int[] getXArray(){
		return x;
	}
	public int[] getYArray(){
		return y;
	}
	public void setNorth(boolean j){
			north = true;
			south = false;
			east = false;
			west = false;
	}
	public void setSouth(boolean j){
				north = false;
				south = true;
				east = false;
				west = false;
	}
	public void setEast(boolean j){
				north = false;
				south = false;
				east = true;
				west = false;
	}
	public void setWest(boolean j){
				north = false;
				south = false;
				east = false;
				west = true;
	}
	public boolean getNorth(boolean n){
		return north;
	}
	public boolean getSouth(boolean n){
			return south;
	}
	public boolean getEast(boolean n){
			return east;
	}
	public boolean getWest(boolean n){
			return west;
	}
	public void Collision(){
		int i = joint;
		while(i != 0){
			if(y[0] > 1000 || y[0] < 0 || x[0] < 0 || x[0] > 1000){
				x[0] = 100;
				y[0] = 100;
				joint = 3;
				break;
			}

			if(x[0] == x[i] && y[0] == y[i]){
				x[0] = 100;
				y[0] = 100;
				joint = 3;
				break;
			}
			else{
				i--;
			}
		}
	}
	public void foodC(food f){
		if(x[0] == f.getX() && y[0] == f.getY()){
			this.addJoint();
			f.creatNewC(this);
		}
	}
}



