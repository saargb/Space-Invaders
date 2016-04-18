package flyingObjects;

import static java.awt.event.KeyEvent.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Spaceship extends Movement {
	
	private static final String PATHNAME = "player.png";
	public static final int SPEED = 1000;
	
	private BufferedImage image;
	private ImageIcon[] sprite;
	private int x;
	private int y;
	private int whichImage = 0;
	
	public Spaceship(int width, int height) {
		super(SPEED);
		sprite = new ImageIcon[4];
		try {
			image = ImageIO.read(new File(PATHNAME));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		for (int i = 0; i < 4; i++) {
			sprite[i] = new ImageIcon(image.getSubimage(i, 0, imageWidth / 4, imageHeight));
		}
		this.x = width / 2;
		this.y = height / 2;
	}
	
	public void draw(JComponent comp, Graphics g) {
		sprite[whichImage].paintIcon(comp, g, x - image.getWidth() / 8, y + image.getHeight() / 2);
	}
	
	public void changeDirection(int keyCode) {
		if (keyCode == VK_W) {
			whichImage = 0;
		}
		else if (keyCode == VK_S) {
			whichImage = 2;
		}
		else if (keyCode == VK_D) {
			whichImage = 3;
		}
		else if (keyCode == VK_A) {
			whichImage = 1;
		}
	}

	@Override
	protected void oneCycle() {
		if (whichImage == 0) {
			y--;
		}
		else if (whichImage == 2) {
			y++;
		}
		else if (whichImage == 3) {
			x++;
		}
		else if (whichImage == 1) {
			x++;
		}
	}

}

//@Override
//protected void setX(int x) {
//	this.x = x;
//}
//
//@Override
//protected void setY(int y) {
//	this.y = y;
//}
//
//@Override
//protected int getX() {
//	return x;
//}
//
//@Override
//protected int getY() {
//	return y;
//}
