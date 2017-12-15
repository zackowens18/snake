import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class main{

	public static void main(String[]args){
		JFrame f = new JFrame("Play Me");
		game g = new game(1000,1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(g);
		f.setResizable(false);
		f.setSize(1000,1000);
		f.setVisible(true);

	}
}