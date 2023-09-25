package gameapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battlefield {
    private final int rowCount;
    private final int colCount;

    private final Square[][] squares;

    public Square get(int x, int y) {
        return squares[x][y];
    }

    public void set(int x, int y, Square newSquare) {
        squares[x][y] = newSquare;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public List<Pair> emptySquaresList() {
        List<Pair> list = new ArrayList<>(rowCount * colCount);

        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                if(get(i, j).equals(Square.Zero())) {
                    list.add(new Pair(i, j));
                }
            }
        }

        return list;
    }

    public boolean addRandomSquare(Random rand) {
        List<Pair> emptyList = emptySquaresList();

        if(emptyList.size() > 0) {
            Pair randomPair = emptyList.get(rand.nextInt(emptyList.size()));
            set(randomPair.x(), randomPair.y(), new Square(2));
            return true;
        }
        else {
            return false;
        }
    }

    public void left() {
        moveLeftAndShrink();
        leftCollect();
        moveLeftAndShrink();
    }

    public void right() {
        moveRightAndShrink();
        rightCollect();
        moveRightAndShrink();
    }

    public void up() {
        moveUpAndShrink();
        upCollect();
        moveUpAndShrink();
    }

    public void down() {
        moveDownAndShrink();
        downCollect();
        moveDownAndShrink();
    }

    public void leftCollect() {
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j + 1 < colCount; j++) {
                if(get(i, j).equals(get(i, j + 1))) {
                    set(i, j, Square.Doubled(get(i, j)));
                    set(i, j + 1, Square.Zero());
                    j++;
                }
            }
        }
    }

    public void rightCollect() {
        for(int i = 0; i < rowCount; i++) {
            for(int j = colCount - 1; j > 0; j--) {
                if(get(i, j).equals(get(i, j - 1))) {
                    set(i, j, Square.Doubled(get(i, j)));
                    set(i, j - 1, Square.Zero());
                    j--;
                }
            }
        }
    }

    public void upCollect() {
        for(int j = 0; j < colCount; j++) {
            for(int i = 0; i + 1 < rowCount; i++) {
                if(get(i, j).equals(get(i + 1, j))) {
                    set(i, j, Square.Doubled(get(i, j)));
                    set(i + 1, j, Square.Zero());
                    i++;
                }
            }
        }
    }

    public void downCollect() {
        for(int j = 0; j < colCount; j++) {
            for(int i = rowCount - 1; i > 0; i--) {
                if(get(i, j).equals(get(i - 1, j))) {
                    set(i, j, Square.Doubled(get(i, j)));
                    set(i - 1, j, Square.Zero());
                    i--;
                }
            }
        }
    }

    public void moveLeftAndShrink() {
        Square emptySquare = Square.Zero();

        for(int i = 0; i < rowCount; i++) {
            ArrayList<Square> newList = new ArrayList<>(colCount);

            for(int j = 0; j < colCount; j++) {
                if(!get(i, j).equals(emptySquare)) {
                    newList.add(get(i, j));
                }
            }

            int j;
            for(j = 0; j < newList.size(); j++) {
                set(i, j, newList.get(j));
            }
            for(; j < colCount; j++) {
                set(i, j, emptySquare);
            }
        }
    }

    public void moveRightAndShrink() {
        Square emptySquare = Square.Zero();

        for(int i = 0; i < rowCount; i++) {
            ArrayList<Square> newList = new ArrayList<>(colCount);

            for(int j = 0; j < colCount; j++) {
                if(!get(i, j).equals(emptySquare)) {
                    newList.add(get(i, j));
                }
            }

            int j;
            for(j = 0; j < colCount - newList.size(); j++) {
                set(i, j, emptySquare);
            }
            for(int k = 0; k < newList.size(); j++, k++) {
                set(i, j, newList.get(k));
            }
        }
    }

    public void moveUpAndShrink() {
        Square emptySquare = Square.Zero();

        for(int j = 0; j < colCount; j++) {
            ArrayList<Square> newList = new ArrayList<>(rowCount);

            for(int i = 0; i < rowCount; i++) {
                if(!get(i, j).equals(emptySquare)) {
                    newList.add(get(i, j));
                }
            }

            int i;
            for(i = 0; i < newList.size(); i++) {
                set(i, j, newList.get(i));
            }
            for(; i < rowCount; i++) {
                set(i, j, emptySquare);
            }
        }
    }

    public void moveDownAndShrink() {
        Square emptySquare = Square.Zero();

        for(int j = 0; j < colCount; j++) {
            ArrayList<Square> newList = new ArrayList<>(rowCount);

            for(int i = 0; i < rowCount; i++) {
                if(!get(i, j).equals(emptySquare)) {
                    newList.add(get(i, j));
                }
            }

            int i;
            for(i = 0; i < rowCount - newList.size(); i++) {
                set(i, j, emptySquare);
            }
            for(int k = 0; k < newList.size(); i++, k++) {
                set(i, j, newList.get(k));
            }
        }
    }

    public Battlefield(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;

        squares = new Square[rowCount][colCount];
        fillEmpty();
    }

    public void fillEmpty() {
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                set(i, j, Square.Zero());
            }
        }
    }

    public int scoreSum() {
        int sum = 0;
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                sum += get(i, j).getScore();
            }
        }
        return sum;
    }

    public boolean canMove() {
        for(int i = 0; i + 1 < rowCount; i++) {
            for(int j = 0; j + 1 < colCount; j++) {
                if(get(i, j).equals(get(i, j + 1))) {
                    return true;
                }
                if(get(i, j).equals(get(i + 1, j))) {
                    return true;
                }
            }
        }

        return false;
    }
}
