package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;
import com.prototype.Prototype;

import java.util.ArrayList;

/**
 * Created by Lukas on 21/08/2017.
 */

public abstract class Scene {

    protected Prototype prototype;
    protected Texture background;
    protected Text text;
    protected ArrayList<Sprite> imageList;
    protected Transition transition;
    private TransitionButtons transitionButtons;

    public Scene(Texture background, Text text, ArrayList<Sprite> imageList, Transition transition) {
        this.background = background;
        this.text = text;
        this.imageList = imageList;
        this.transition = transition;
        transitionButtons = new TransitionButtons();
    }

    public ArrayList<Sprite> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<Sprite> imageList) {
        this.imageList = imageList;
    }

    public Texture getBackground() {
        return background;
    }

    public void setBackground(Texture background) {
        this.background = background;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Transition getTransition() {
        return transition;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    public void show(Prototype prototype, Batch batch, GlyphLayout layout, BitmapFont font) {
        this.prototype = prototype;

        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();

        batch.begin();
        batch.draw(background, 0, 0, width, height);
        layout.setText(font, text.getText(), text.getColor(), text.getWidth(), Align.center, true);
        font.draw(batch, layout, text.getX(), text.getY());

        /* Desenha texturas para os botões de transição da cena, definidos na classe
            TransitionButtons. */
        transitionButtons.getSpriteGoBack().draw(batch);
        transitionButtons.getSpriteMoveOn().draw(batch);

        batch.end();

        this.handleTransition(transitionButtons.getRectangeMoveOn(), transitionButtons.getRectangleGoBack());
    }

    public void handleTransition(Rectangle rectangleMoveOn, Rectangle rectangleGoBack) {
        if (Gdx.input.justTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();

            if (rectangleMoveOn.contains(x, Gdx.graphics.getHeight() - y))
                toNext();

            else if (rectangleGoBack.contains(x, Gdx.graphics.getHeight() - y))
                toPrevious();
        }
    }

    public abstract void toNext();

    public abstract void toPrevious();
}
