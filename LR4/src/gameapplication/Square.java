package gameapplication;

import java.awt.*;

public class Square {
    private final int score;

    public Square(int score) {
        this.score = score;
    }

    public Square(Square sq) {
        this.score = sq.score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Square s) {
            return score == s.score;
        }
        else {
            return false;
        }
    }
}
