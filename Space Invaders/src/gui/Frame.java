package gui;

import javax.swing.JFrame;

public class Frame {
	
	public static final int WIDTH = 700;
	public static final int HEIGHT = 700;
	public static JFrame frame;
	
	public static void main(String[] args) {
		frame = new JFrame("Space Invaders");
		System.out.println("the game begins...");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.add(new Draw(WIDTH, HEIGHT));
		frame.setVisible(true);
	}
}
