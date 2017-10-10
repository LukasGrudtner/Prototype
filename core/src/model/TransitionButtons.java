package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Lukas on 10/10/2017.
 */

public class TransitionButtons {

    private static final String MOVE_ON_TRANSITION_IMAGE_PATH = "seta.png";
    private static final String GO_BACK_TRANSITION_IMAGE_PATH = "seta.png";
    public static final int SCREEN_SIZE_RATIO = 8;

    private Rectangle rectangeMoveOn, rectangleGoBack;
    private Sprite spriteMoveOn, spriteGoBack;

    public TransitionButtons() {
        rectangeMoveOn = new Rectangle();
        rectangleGoBack = new Rectangle();

        spriteMoveOn = new Sprite(new Texture(MOVE_ON_TRANSITION_IMAGE_PATH));
        spriteGoBack = new Sprite(new Texture(GO_BACK_TRANSITION_IMAGE_PATH));
        this.setSpritesBounds();
        this.setRectanglesBounds();
    }

    private void setSpritesBounds() {
        int heightScreen = Gdx.graphics.getHeight();
        int widthScreen = Gdx.graphics.getWidth();

        /* x, y, width, height */
        spriteGoBack.setBounds(0, 0, heightScreen/SCREEN_SIZE_RATIO, heightScreen/SCREEN_SIZE_RATIO);
        spriteMoveOn.setBounds(widthScreen-(heightScreen/SCREEN_SIZE_RATIO), 0, heightScreen/SCREEN_SIZE_RATIO, heightScreen/SCREEN_SIZE_RATIO);
    }

    private void setRectanglesBounds() {
        int heightScreen = Gdx.graphics.getHeight();
        int widthScreen = Gdx.graphics.getWidth();

        /* x, y, width, height */
        rectangleGoBack.set(0, 0, heightScreen/SCREEN_SIZE_RATIO, heightScreen/SCREEN_SIZE_RATIO);
        rectangeMoveOn.set(widthScreen-(heightScreen/SCREEN_SIZE_RATIO), 0, heightScreen/SCREEN_SIZE_RATIO, heightScreen/SCREEN_SIZE_RATIO);
    }

    public Rectangle getRectangeMoveOn() {
        return rectangeMoveOn;
    }

    public Rectangle getRectangleGoBack() {
        return rectangleGoBack;
    }

    public Sprite getSpriteMoveOn() {
        return spriteMoveOn;
    }

    public Sprite getSpriteGoBack() {
        return spriteGoBack;
    }

}
