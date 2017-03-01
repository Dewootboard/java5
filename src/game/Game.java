package game;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

import entities.Bullet;
import entities.Entity;
import entities.Player;
import entities.Enemy;

import javax.swing.*;

public class Game extends JFrame implements KeyListener {
	private Player player;
	private Enemy enemy;
	private ArrayList<Entity> entities = new ArrayList<>();
	private boolean jump, left, right, shoot, shootReleased = true;
	private boolean running = false;

	public Game(){
		super("My lizzle Frenq");

		//you can set the content pane of the frame
		//to your custom class.

		setContentPane(new DrawPane());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(1080, 720);

		setVisible(true);

		GameLoop();
	}

	class DrawPane extends JPanel{
		public void paintComponent(Graphics g){
			//draw on g here e.g.
			g.setColor(Color.white);
			g.drawRect(0,0,getWidth(),getHeight());
			g.fillRect(1, 1, getWidth()-2, getHeight()-2);

			for(Entity e : entities){
				e.draw(g);
			}
		}
	}

	//create a component that you can actually draw on.
	public static void main(String args[]){
		Game game = new Game();
	}


	public void update(){
		ArrayList<Entity> removal = new ArrayList<>();
		for(Entity e: entities) {
			entities = e.update(entities, e, removal);
		}
		entities.removeAll(removal);
		repaint();
	}

	private void GameLoop(){
		player = new Player(getWidth()-(40+25), getHeight()-(45 + 25), 20, 20);
		enemy = new Enemy(200, getHeight()-(40+40), 10,40);

		setBackground(Color.white);
		setFocusable(true);
		addKeyListener(this);
		entities.add(enemy);
		entities.add(player);

		boolean facingLeft = false;
		while(true){
			if(left){
				player.setXPos(player.getPosition().x-4);
				facingLeft = true;
			}
			if(right){
				player.setXPos(player.getPosition().x+4);
				facingLeft = false;
			}
			if(jump){
				player.setYPos(player.getPosition().y-2);
			}else
			if(player.getPosition().getY() <= getHeight()-2-player.getHeight()-45)
				player.setYPos(player.getPosition().y+2);
			if(shoot){
				shoot = false;
				Bullet bullet = new Bullet(player.getPosition().x-1, player.getPosition().y + 8, !facingLeft, 9, 9);
				entities.add(bullet);
			}

			update();

			try{
				Thread.sleep(25);
			}catch(Exception e){

			}
		}
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_F:
				System.exit(9000);
				break;
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_A:
				left = true;
				break;
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D:
				right = true;
				break;
			case KeyEvent.VK_SPACE:
				jump = true;
				break;
			case KeyEvent.VK_E:
				if (shootReleased)
					shoot = true;
				shootReleased = false;
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_F:
				System.exit(9000);
				break;
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_A:
				left = false;
				break;
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D:
				right = false;
				break;
			case KeyEvent.VK_SPACE:
				jump = false;
				break;
			case KeyEvent.VK_E:
				shoot = false;
				shootReleased = true;
				break;
		}
	}

	public void keyTyped(KeyEvent arg0) {}

}

/*
public class Game extends Applet implements Runnable, KeyListener{
	private Image offscreen;
	private Graphics bufferGraphics;
	private Player player;
	private ArrayList<Entity> entities = new ArrayList<>();
	private boolean jump, left, right, shoot, exit;

	Dimension dim;

	public void init(){
		exit = false;
		dim.height = 1080;
		dim.width = 720;
		setBackground(Color.white);
		offscreen = createImage(dim.width, dim.height);
		bufferGraphics = offscreen.getGraphics();
		setFocusable(true);
		addKeyListener(this);
		player = new Player(50, 500, 25, 25);
		entities.add(player);
		new Thread(()->run()).start();
	}
	
	public void paint(Graphics g){
		bufferGraphics.clearRect(0, 0, dim.width, dim.height);
		for(Entity e : entities)
			e.draw(bufferGraphics);

		g.drawImage(offscreen, 0, 0, this);
	}
	
	public void update(Graphics g){
		for(Entity e : entities){
			e.update();
		}
		paint(g);
	}

	@Override
	public void run() {
		boolean facingLeft = false;
		while(true){
			System.out.println(player.getPosition().x);
			if(left){
				player.setXPos(player.getPosition().x-4);
				System.out.println("left");
				facingLeft = true;
			}
			if(right){
				player.setXPos(player.getPosition().x+4);
				System.out.println("right");
				facingLeft = false;
			}
			if(jump){
				player.setYPos(player.getPosition().y-1);
			}else
				if(player.getPosition().getY() <= 599)
					player.setYPos(player.getPosition().y+1);
			if(shoot){
				System.out.println("Shooting");
				Bullet bullet = new Bullet(player.getPosition().x, player.getPosition().y + 8, !facingLeft, 9, 9);
				entities.add(bullet);
			}

			repaint();
			
			try{
				Thread.sleep(25);
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
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
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
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			jump = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_E){
			shoot = false;
		}
	}

	public void keyTyped(KeyEvent arg0) {}

}

*/