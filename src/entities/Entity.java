package entities;
import java.awt.Graphics;


public class Entity{
	protected Vector2 position;
	protected Vector2 velocity;
	
	public Entity(int x, int y){
		position = new Vector2(x, y);
		velocity = new Vector2();
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

	public void setYVel(int y){
		velocity.setY(y);
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public void draw(Graphics g){

	}
	
	public void update(){	}
}