package gameapplication;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Random;

public class BattlefieldPanel extends JPanel {
    private SquarePanel[][] field;
    private Battlefield bf;
    public BattlefieldPanel(int rowCount, int colCount) {
        bf = new Battlefield(rowCount, colCount);
        field = new SquarePanel[rowCount][colCount];

        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                field[i][j] = new SquarePanel(bf.get(i, j));
                add(field[i][j]);
            }
        }

        setLayout(new GridLayout(4,4, 4, 4));
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    public boolean addRandomSquare(Random rand) {
        boolean result = bf.addRandomSquare(rand);
        updateField();

        return result;
    }

    public void left() {
        bf.left();
        updateField();
    }

    public void right() {
        bf.right();
        updateField();
    }

    public void up() {
        bf.up();
        updateField();
    }

    public void down() {
        bf.down();
        updateField();
    }

    public void updateField() {
        for(int i = 0; i < bf.getRowCount(); i++) {
            for(int j = 0; j < bf.getColCount(); j++) {
                updateSquare(i, j);
            }
        }
        repaint();
    }

    public int scoreSum() {
        return bf.scoreSum();
    }

    public boolean canMove() {
        return bf.canMove();
    }

    public void updateSquare(int x, int y) {
        field[x][y].setSquare(bf.get(x, y));
    }

    public void startGame(Random random) {
        bf.fillEmpty();
        addRandomSquare(random);
    }
}
