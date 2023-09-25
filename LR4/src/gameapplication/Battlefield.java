package gameapplication;

import java.util.ArrayList;
import java.util.Random;

public class Battlefield {
    private final int rowCount;
    private final int colCount;

    private final Square[][] squares;

    public Square get(int x, int y) {
        return new Square(squares[x][y]);
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

    public Pair addRandomSquare(Random rand) {
        Square emptySquare = SquarePanel.EmptySquare();
        int x;
        int y;

        do {
            x = rand.nextInt(getRowCount());
            y = rand.nextInt(getColCount());
        } while(!squares[x][y].equals(emptySquare));

        squares[x][y] = new Square(2);
        return new Pair(x, y);
    }

    public void moveLeftAndShrink() {
        Square emptySquare = SquarePanel.EmptySquare();

        for(int i = 0; i < rowCount; i++) {
            ArrayList<Square> newList = new ArrayList<>();

            for(int j = 0; j < colCount; j++) {
                if(!squares[i][j].equals(emptySquare)) {
                    newList.add(squares[i][j]);
                }
            }


            int j;
            for(j = 0; j < newList.size(); j++) {
                squares[i][j] = newList.get(j);
            }
            for(; j < colCount; j++) {
                squares[i][j] = SquarePanel.EmptySquare();
            }
        }
    }

    public void moveRightAndShrink() {
        Square emptySquare = SquarePanel.EmptySquare();

        for(int i = 0; i < rowCount; i++) {
            ArrayList<Square> newList = new ArrayList<>();

            for(int j = 0; j < colCount; j++) {
                if(!squares[i][j].equals(emptySquare)) {
                    newList.add(squares[i][j]);
                }
            }

            int j;
            for(j = 0; j < colCount - newList.size(); j++) {
                squares[i][j] = SquarePanel.EmptySquare();
            }
            for(int k = 0; k < newList.size(); j++, k++) {
                squares[i][j] = newList.get(k);
            }
        }
    }

    public void moveUpAndShrink() {
        Square emptySquare = SquarePanel.EmptySquare();

        for(int j = 0; j < colCount; j++) {
            ArrayList<Square> newList = new ArrayList<>();

            for(int i = 0; i < rowCount; i++) {
                if(!squares[i][j].equals(emptySquare)) {
                    newList.add(squares[i][j]);
                }
            }

            int i;
            for(i = 0; i < newList.size(); i++) {
                squares[i][j] = newList.get(i);
            }
            for(; i < rowCount; i++) {
                squares[i][j] = SquarePanel.EmptySquare();
            }
        }
    }

    public void moveDownAndShrink() {
        Square emptySquare = SquarePanel.EmptySquare();

        for(int j = 0; j < colCount; j++) {
            ArrayList<Square> newList = new ArrayList<>();

            for(int i = 0; i < rowCount; i++) {
                if(!squares[i][j].equals(emptySquare)) {
                    newList.add(squares[i][j]);
                }
            }

            int i;
            for(i = 0; i < rowCount - newList.size(); i++) {
                squares[i][j] = SquarePanel.EmptySquare();
            }
            for(int k = 0; k < newList.size(); i++, k++) {
                squares[i][j] = newList.get(k);
            }
        }
    }


    public Battlefield(int rowCount, int colCount, Square defaultSquare) {
        this.rowCount = rowCount;
        this.colCount = colCount;

        squares = new Square[rowCount][colCount];
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                squares[i][j] = defaultSquare;
            }
        }
    }
}
