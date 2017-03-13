package entities;
import java.awt.*;
import java.util.ArrayList;


public class Bullet extends Entity{
	public Bullet(int x, int y, boolean right, int width, int height){
		super(x, y, width, height);
		velocity.setY(0);
		velocity.setX(right?3:-3);
	}
	
	public Bullet(Vector2 position, boolean right, int width, int height){
		super(position.getX(), position.getY(), width, height);
		velocity.setY(0);
		velocity.setX(right?3:-3);
	}
	
	@Override
	public void draw(Graphics g){
		g.setColor(Color.red);
		g.fillOval(position.x, position.y, width, height);
	}

	public ArrayList<Entity> update(ArrayList<Entity> entities, Entity e, ArrayList<Entity> removal){
		for(Entity ent : entities) {
			if (ent != e && e.getPosition().y+e.getHeight() > ent.getPosition().y && e.getPosition().y < ent.getPosition().y + ent.getHeight() &&
					e.getPosition().x+e.getWidth() > ent.getPosition().x && e.getPosition().x < ent.getPosition().x + ent.getWidth()) {
				removal.add(ent);
				removal.add(e);
			}
		}
		updatePos();
		return entities;
	}
}
