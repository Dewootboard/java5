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
		new Thread(()->run()).start();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		System.out.println("leadadadft");
		g.setColor(Color.red);
		g.fillRect(0, 0, 1080, 720);
		g.setColor(Color.white);
		player.draw(g);
		for(Entity e : entities)
			e.draw(g);
	}
	
	public void update(Graphics g){
		for(Entity e : entities){
			e.update();
		}
		paint(g);
	}

	@Override
	public void run() {
		while(true){
			System.out.println(player.getPosition().x);
			if(left){
				player.setXPos(player.getPosition().x-4);
				repaint( player.getPosition().x-4, player.getPosition().y, 34, 34);
				System.out.println("left");
			}
			if(right){
				player.setXPos(player.getPosition().x+4);
				repaint(player.getPosition().x-4, player.getPosition().y-4, 33, 33);
				System.out.println("right");
			}
			if(jump){
				player.setYVel(-10);
			}else
				if(player.getPosition().getY() <= 599)
				player.setYVel(10);
			if(shoot){
				System.out.println("Shooting");
				Bullet bullet = new Bullet(player.getPosition(), !left);
				entities.add(bullet);
			}

			update(d);
			
			try{
				Thread.sleep(20);
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
		if(e.getKeyCode() == KeyEvent.VK_E){
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
		if(e.getKeyCode() == KeyEvent.VK_E){
			shoot = false;
		}
	}

	public void keyTyped(KeyEvent arg0) {}

}
