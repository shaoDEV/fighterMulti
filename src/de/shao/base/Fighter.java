package de.shao.base;

import javax.swing.*;
import java.awt.*;

public class Fighter {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();

        frame.setSize(1000,700);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setResizable(false);
        frame.setTitle("FighterPrototype");
        frame.setVisible(true);
    }
}
