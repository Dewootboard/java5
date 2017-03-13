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

    public ArrayList<Entity> update(ArrayList<Entity> entities, Entity e, ArrayList<Entity> removal){
        Entity closestEnt;
        if(entities.get(0) == e)
            closestEnt = entities.get(1);
        else
            closestEnt = entities.get(0);
        for(Entity ents : entities){
            if(ents != e) {
                if (Math.abs(ents.getPosition().x - e.getPosition().x) < Math.abs(closestEnt.getPosition().x - e.getPosition().x)) {
                    closestEnt = ents;
                }
            }
        }

        int dist = closestEnt.getPosition().x - e.getPosition().x;
        if(dist < 200 && dist > -200){
            if(dist > 0)
                e.setXVel(-2);
            else
                e.setXVel(2);
        }else{
            if(dist < 0) {
                e.setXVel(1);
            }else{
                e.setXVel(-1);
            }
        }

        updatePos();

        return entities;
    }
}
