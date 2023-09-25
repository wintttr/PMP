package gameapplication;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

import static java.lang.System.exit;

class ArrowKeysListener extends KeyAdapter {
    private BattlefieldPanel bfp;
    private Random rand;
    private JLabel scoreLabel;
    ArrowKeysListener(JLabel scoreLabel, BattlefieldPanel bfp, Random rand) {
        this.rand = rand;
        this.bfp = bfp;
        this.scoreLabel = scoreLabel;
    }

    private void gameOver() {
        JOptionPane.showMessageDialog(null, "Game over!");
        exit(0);
    }

    private void addRandomSquare() {
        if(!bfp.addRandomSquare(this.rand) && !bfp.canMove()) {
            gameOver();
        }

        scoreLabel.setText("Score: " + bfp.scoreSum());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> {
                bfp.left();
                addRandomSquare();
            }
            case KeyEvent.VK_RIGHT -> {
                bfp.right();
                addRandomSquare();
            }
            case KeyEvent.VK_UP -> {
                bfp.up();
                addRandomSquare();
            }
            case KeyEvent.VK_DOWN -> {
                bfp.down();
                addRandomSquare();
            }
        }
    }
}

public class Game {
    public static void main(String[] args) {
        Random rand = new Random(new Date().getTime());
        JFrame f = new JFrame();
        f.setSize(400, 430);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BattlefieldPanel bfPanel = new BattlefieldPanel(4, 4);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel scoreLabel = new JLabel();
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        panel.add(scoreLabel);
        panel.add(bfPanel);

        f.add(panel);
        f.setVisible(true);

        f.addKeyListener(new ArrowKeysListener(scoreLabel, bfPanel, rand));

        bfPanel.startGame(rand);
        scoreLabel.setText("Score: " + bfPanel.scoreSum());
    }
}
