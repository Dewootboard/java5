package game;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import entities.Bullet;
import entities.Entity;
import entities.Player;
import entities.Vector2;


public class Game extends Applet implements Runnable, KeyListener{
	private Image offscreen;
	private Graphics d;
	private Player player;
	private ArrayList<Entity> entities = new ArrayList<>();
	private boolean jump, left, right, shoot, exit;
	
	public void init(){
		exit = false;
		setSize(1080,720);
		offscreen = createImage(1280,720);
		d = offscreen.getGraphics();
		setFocusable(true);
		addKeyListener(this);
		player = new Player(50, 500);
		entities.add(player);
		run();
	}
	
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.fillRect(0, 600, 1280, 120);
		for(Entity e : entities)
			e.draw(g);
		g.drawLine(100, 100, 200, 200);
	}
	
	public void update(Graphics g){
		for(Entity e : entities)
			e.update();
		paint(g);
	}

	@Override
	public void run() {
		while(true){
			System.out.println("WAHT");
			if(left){
				player.setXVel(-2);
			}
			if(right){
				player.setXVel(2);
			}
			if(jump){
				player.setYVel(-10);
			}else
				if(player.getPosition().getY() <= 599)
				player.setYVel(10);
			if(shoot){
				Bullet bullet = new Bullet(player.getPosition(), !left);
				entities.add(bullet);
			}

			update(d);
			
			try{
				Thread.sleep(4);
			}catch(Exception e){
				
			}
		}
	}

	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_F){
			System.exit(9000);
		}
		if(e.getKeyCode() == 37){
			left = true;
		}
		if(e.getKeyCode() == 39){
			right = true;
		}
		if(e.getKeyCode() == 32){
			jump = true;
		}
		if(e.getKeyCode() == 'e'){
			shoot = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 37){
			left = false;
		}
		if(e.getKeyCode() == 39){
			right = false;
		}
		if(e.getKeyCode() == 32){
			jump = false;
		}
		if(e.getKeyCode() == 'e'){
			shoot = false;
		}
	}

	public void keyTyped(KeyEvent arg0) {}

}
