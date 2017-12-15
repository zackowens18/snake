import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class game extends JPanel {
	private boolean north, south, east, west;
	private int direction, delay;
	private int i = 0;
	private javax.swing.Timer timer;
	public snakebody snakebody;
	public food food;



	public game(int width, int height){
	setBackground(Color.WHITE);
	addKeyListener(new TypeListener());
	setFocusable(true);
	timer = new javax.swing.Timer(100, new MoveListener());
	snakebody = new snakebody(500, 500, 10, 10, 10, 5);
	snakebody.setEast(true);

	food = new food();
	snakebody.start();
	snakebody.setEast(true);
	timer.start();
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		snakebody.drawBody(g);
		food.draw(g);

	}

	private class MoveListener implements ActionListener{
			@Override
		public void actionPerformed(ActionEvent e){
				snakebody.move();
				snakebody.Collision();
				snakebody.foodC(food);
				repaint();
				timer.start();

		}
	}
	 private class TypeListener extends KeyAdapter{
			 @Override
			 public void keyPressed(KeyEvent e){
				 int button = e.getKeyCode();
				if (button == KeyEvent.VK_LEFT){
					 snakebody.setWest(true);
				 }
				if (button == KeyEvent.VK_RIGHT){
					 snakebody.setEast(true);
				 }
				 if (button == KeyEvent.VK_UP){
						 snakebody.setNorth(true);
				 }
				 if (button == KeyEvent.VK_DOWN){
				 				 snakebody.setSouth(true);
				 }
			 }
    }
}
