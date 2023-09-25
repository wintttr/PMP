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

    static public Square Doubled(Square sq) {
        return new Square(sq.score * 2);
    }

    static public Square Zero() {
        return new Square(0);
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
