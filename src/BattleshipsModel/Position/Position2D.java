package BattleshipsModel.Position;

import java.util.Objects;

public class Position2D {
    private int x;
    private int y;
    private char charX;

    public Position2D(int x, int y) {
        this.x = x;
        this.y = y;
        calcCharX();
    }

    public Position2D(char charX, int y) {
        this.charX = charX;
        this.y = y;
        calcIntX();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getCharX() {
        if (charX == '\u0000'){calcCharX();}
        return charX;
    }

    private void calcCharX(){
        charX = (char) (64+x%26);
    }

    private void calcIntX(){
        x = ((int) charX) - 64;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position2D that)) return false;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString(){
        return "("+x+ ", "+y +")";
    }

    public String userReadable(){
        return charX+""+y;
    }
}
