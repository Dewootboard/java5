package entities;
import java.awt.Graphics;


public class Bullet extends Entity{
	public Bullet(int x, int y, boolean right){
		super(x, y);
		velocity.setY(0);
		velocity.setX(right?4:-4);
	}
	
	public Bullet(Vector2 position, boolean right){
		super(position.getX(), position.getY());
		velocity.setY(0);
		velocity.setX(right?6:-6);
	}
	
	@Override
	public void draw(Graphics g){
		g.fillOval(position.x, position.y, 5, 3);
	}

	@Override
	public void update(){
		position.x = getVelocity().x + getPosition().x;
		position.y = getVelocity().y + getPosition().y;
	}
}
