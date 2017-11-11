package model.text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by Lukas on 09/09/2017.
 */

public abstract class Text {

    private String text = "";
    private Color color;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract int getSize();

    public abstract int getX();

    public abstract int getY();

    public abstract int getAlign();
}
