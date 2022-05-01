package de.shao.base;

import java.awt.*;

public class Terrain {
    int x,y;
    int width, height;

    Rectangle hitBox;

    public Terrain(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.hitBox = new Rectangle(x,y,width,height);
    }

    public void draw(Graphics2D gtd){
        gtd.setColor(Color.BLACK);
        gtd.drawRect(x,y,width,height);
        gtd.setColor(Color.WHITE);
        gtd.fillRect(x+1,y+1,width-2,height-2);
    }
}
