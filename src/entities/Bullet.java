package entities;
import java.awt.*;
import java.util.ArrayList;


public class Bullet extends Entity{
	public Bullet(int x, int y, boolean right, int width, int height){
		super(x, y, width, height);
		velocity.setY(0);
		velocity.setX(right?2:-2);
	}
	
	public Bullet(Vector2 position, boolean right, int width, int height){
		super(position.getX(), position.getY(), width, height);
		velocity.setY(0);
		velocity.setX(right?2:-2);
	}
	
	@Override
	public void draw(Graphics g){
		g.setColor(Color.red);
		g.fillOval(position.x, position.y, width, height);
	}

	public ArrayList<Entity> update(ArrayList<Entity> entities, Entity e){
		for(Entity ent : entities)
			if(e.getPosition().x == ent.getPosition().x && ent != e){
				ent.setXPos(3000);
				ent.setYPos(-3000);
				e.setXPos(3000);
				e.setYPos(3000);
			}
		updatePos();
		return entities;
	}
}
