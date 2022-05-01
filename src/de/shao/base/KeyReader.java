package de.shao.base;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyReader extends KeyAdapter {
    GamePanel panel;

    public KeyReader(GamePanel panel){
        this.panel = panel;
    }

    public void keyPressed(KeyEvent e){
        panel.keyPressed(e);
    }

    public void keyReleased(KeyEvent e){
        panel.keyReleased(e);
    }
}
