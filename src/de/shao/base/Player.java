package de.shao.base;

import java.awt.*;

public class Player {

    int x,y;
    int width, height;

    double xSpeed, ySpeed;

    Rectangle hitbox;

    boolean keyLeft, keyRight, keyJump;

    GamePanel panel;

    public Player(int x, int y, GamePanel panel){
        this.panel = panel;
        this.x = x;
        this.y = y;

        width = 50;
        height = 100;
        hitbox = new Rectangle(x,y,width,height);
    }

    public void set(){
        if (keyLeft && keyRight || !keyLeft && !keyRight) xSpeed *= 0.8;
        else if (keyLeft) xSpeed--;
        else xSpeed++;

        if (xSpeed > 0 && xSpeed < 0.75) xSpeed = 0;
        if (xSpeed < 0 && xSpeed > -0.75) xSpeed = 0;

        if (xSpeed > 7) xSpeed = 7;
        if (xSpeed < -7) xSpeed = -7;

        if (keyJump){

            hitbox.y ++;
            for (Terrain wall: panel.walls){
                if (wall.hitBox.intersects(hitbox)) ySpeed = -12;
            }
            hitbox.y--;
        }
        ySpeed += 0.6;

        //Horizontal
        hitbox.x += xSpeed;
        for (Terrain wall: panel.walls){
            if (hitbox.intersects(wall.hitBox)){
                hitbox.x -= xSpeed;
                while (!wall.hitBox.intersects(hitbox)) hitbox.x += Math.signum(xSpeed);
                hitbox.x -= Math.signum(xSpeed);
                xSpeed = 0;
                x = hitbox.x;
            }
        }

        //Vertical
        hitbox.y += ySpeed;
        for (Terrain wall: panel.walls){
            if (hitbox.intersects(wall.hitBox)){
                hitbox.y -= ySpeed;
                while (!wall.hitBox.intersects(hitbox)) hitbox.y += Math.signum(ySpeed);
                hitbox.y -= Math.signum(ySpeed);
                ySpeed = 0;
                y = hitbox.y;
            }
        }

        x += xSpeed;
        y += ySpeed;

        hitbox.x = x;
        hitbox.y = y;
    }

    public void draw(Graphics2D gtd){
        gtd.setColor(Color.black);
        gtd.fillRect(x,y,width,height);
    }
}
