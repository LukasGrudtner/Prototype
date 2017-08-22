package components;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Lukas on 21/08/2017.
 */

public class Click {

    Texture image;
    int x, y, length, width;

    public Click(Texture image) {//, int x, int y, int length, int width) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }

    public Texture getImage() {
        return image;
    }

    public void setImage(Texture image) {
        this.image = image;
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
