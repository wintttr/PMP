package gameapplication;

import javax.swing.*;
import java.awt.*;

public class SquarePanel extends JPanel {
    private Square square;
    private JLabel scoreLabel;

    private Color getColor() {
        if(square.getScore() == 0) {
            return new Color(0xee, 0xee, 0xee);
        }

        float h = (float) (Math.log(square.getScore()) / Math.log(2)) / 10.0f;
        float s = 0.5f;
        float b = 0.9f;

        return Color.getHSBColor(h , s, b);
    }

    public void setSquare(Square square) {
        this.square = new Square(square);
        updateBody();
    }

    public Square getSquare() {
        return square;
    }

    public void updateBody() {
        if(square.getScore() > 0) {
            scoreLabel.setText(String.valueOf(square.getScore()));
        }
        else {
            scoreLabel.setText(null);
        }

        setBackground(getColor());
    }

    public SquarePanel(Square square) {
        setLayout(new BorderLayout());
        scoreLabel = new JLabel();
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Sans", Font.BOLD, 18));
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setVerticalAlignment(JLabel.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(scoreLabel, BorderLayout.CENTER);

        setSquare(square);
    }

    public static Square EmptySquare() {
        return new Square(0);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SquarePanel squarePanel) {
            return square.equals(squarePanel.square);
        }
        else {
            return false;
        }
    }
}
