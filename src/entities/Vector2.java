package entities;

public class Vector2 {
	public int x, y;
	
	public Vector2(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Vector2(){
		this.x = 0;
		this.y = 0;
	}
	
	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void addVector2(Vector2 add){
		this.y = this.y + add.y;
		this.x = this.x + add.x;
	}

}
