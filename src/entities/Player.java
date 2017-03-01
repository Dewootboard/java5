package entities;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Player extends Entity{

	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	@Override
	public void draw(Graphics g){
		g.drawString("PLAYER: Position " + position.x, 10, 10);
		g.setColor(Color.black);
		g.drawRect(position.x, position.y, width, height);
	}

	public ArrayList<Entity> update(ArrayList<Entity> entities, Entity e, ArrayList<Entity> removal){
		updatePos();
		return entities;
	}
}
