package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Lukas on 21/08/2017.
 */

public class Transition {

    private Sprite sprite;

    public Transition(Sprite sprite) {
        this.sprite = sprite;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public int getX() {
        return sprite.getRegionX();
    }

    public int getY() {
        return sprite.getRegionY();
    }

    public float getHeight() {
        return sprite.getHeight();
    }

    public float getWidth() {
        return sprite.getWidth();
    }
}
