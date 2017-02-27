package entities;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Entity{
	public Player(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(Graphics g){
		g.drawOval(position.x, position.y, 25, 25);
	}
}
