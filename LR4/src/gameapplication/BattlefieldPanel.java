package gameapplication;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Random;

public class BattlefieldPanel extends JPanel {
    private SquarePanel[][] field;
    private Battlefield bf;
    public BattlefieldPanel(int rowCount, int colCount) {
        bf = new Battlefield(rowCount, colCount, SquarePanel.EmptySquare());
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

    public void addRandomSquare(Random rand) {
        Pair p = bf.addRandomSquare(rand);
        updateSquare(p.x(), p.y());
    }

    public void left() {
        bf.moveLeftAndShrink();
        updateField();
    }

    public void right() {
        bf.moveRightAndShrink();
        updateField();
    }

    public void up() {
        bf.moveUpAndShrink();
        updateField();
    }

    public void down() {
        bf.moveDownAndShrink();
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

    public void updateSquare(int x, int y) {
        field[x][y].setSquare(bf.get(x, y));
    }
}
