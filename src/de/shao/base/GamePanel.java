package de.shao.base;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel implements ActionListener {

    Player player;
    Timer gameTimer;
    ArrayList<Terrain> walls = new ArrayList<>();

    public GamePanel(){

        player = new Player(400,300, this);
        makeGround();

        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.set();
                repaint();
            }
        }, 0, 17);
    }

    public void paint(Graphics g){
        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;
        player.draw(gtd);
        for (Terrain wall: walls) wall.draw(gtd);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a' -> player.keyLeft = true;
            case 'd' -> player.keyRight = true;
            case KeyEvent.VK_SPACE -> player.keyJump = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a' -> player.keyLeft = false;
            case 'd' -> player.keyRight = false;
            case KeyEvent.VK_SPACE -> player.keyJump = false;
        }
    }

    public void makeGround(){
        for (int i = 50; i < 900; i+=50){
            walls.add(new Terrain(i, 600 , 50,50));
        }
    }
}
