package entities;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by jocke on 2/28/2017.
 */
public class Enemy extends Entity{
    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.green);
        g.drawRect(position.x, position.y, width, height);
    }

    public ArrayList<Entity> update(ArrayList<Entity> entities, Entity e){
        updatePos();
        return entities;
    }
}
