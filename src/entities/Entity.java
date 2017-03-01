package entities;
import java.awt.Graphics;
import java.util.ArrayList;


public class Entity{
	protected Vector2 position;
	protected Vector2 velocity;
	protected int width;
	protected int height;
	
	public Entity(int x, int y, int width, int height){
		position = new Vector2(x, y);
		velocity = new Vector2();
		this.width = width;
		this.height = height;
	}
	
	public void setVelocity(Vector2 velocity){
		this.velocity = velocity;
	}

	public Vector2 getVelocity(){
		return velocity;
	}
	
	public void setXVel(int x){
		velocity.setX(x);
	}

	public void setXPos(int x){
		position.setX(x);
	}

	public void setYPos(int y){
		position.setY(y);
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public void setYVel(int y){
		velocity.setY(y);
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public void draw(Graphics g){

	}

	public ArrayList<Entity> update(ArrayList<Entity> entities, Entity e, ArrayList<Entity> removal){
		updatePos();
		return entities;
	}

	public void updatePos()
	{
		position.x = position.x + velocity.x;
		position.y = position.y + velocity.y;
	}
}