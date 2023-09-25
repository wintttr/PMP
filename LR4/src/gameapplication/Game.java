package gameapplication;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

class ArrowKeysListener extends KeyAdapter {
    private BattlefieldPanel bfp;
    ArrowKeysListener(BattlefieldPanel bfp) {
        this.bfp = bfp;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> bfp.left();
            case KeyEvent.VK_RIGHT -> bfp.right();
            case KeyEvent.VK_UP -> bfp.up();
            case KeyEvent.VK_DOWN -> bfp.down();
        }
    }
}

public class Game {
    public static void main(String[] args) {
        Random rand = new Random(new Date().getTime());
        JFrame f = new JFrame();
        f.setSize(400, 400);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BattlefieldPanel panel = new BattlefieldPanel(4, 4);
        panel.addRandomSquare(rand);
        f.add(panel);
        f.setVisible(true);

        f.addKeyListener(new ArrowKeysListener(panel));
    }
}
