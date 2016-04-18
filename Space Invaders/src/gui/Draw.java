package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

import flyingObjects.Spaceship;

public class Draw extends JComponent implements KeyListener {
	
	Spaceship player;
	
	private int drawWidth;
	private int drawHeight;
	private boolean isFirstKeyHit = true;
	
	public Draw(int drawWidth, int drawHeight) {
		super();
		this.drawWidth = drawWidth;
		this.drawHeight = drawHeight;
		player = new Spaceship(drawWidth, drawHeight);
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.clearRect(0, 0, drawWidth, drawHeight);
		player.draw(this, g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Key Hit!");
		player.changeDirection(e.getKeyCode());
		if (isFirstKeyHit) {
			player.start();
			isFirstKeyHit = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
