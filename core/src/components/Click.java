package components;

/**
 * Created by Lukas on 21/08/2017.
 */

public class Click {

    String objectImagePath;
    int x, y, length, width;

    public Click(String objectImagePath, int x, int y, int length, int width) {
        this.objectImagePath = objectImagePath;
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }

    public String getObjectImagePath() {
        return objectImagePath;
    }

    public void setObjectImagePath(String objectImagePath) {
        this.objectImagePath = objectImagePath;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}