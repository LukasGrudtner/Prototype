package components;

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
    protected String text;
    protected ArrayList<Sprite> imageList;
    protected Click click;

    public Scene(Texture background, String text, ArrayList<Sprite> imageList, Click click) {
        this.background = background;
        this.text = text;
        this.imageList = imageList;
        this.click = click;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Click getClick() {
        return click;
    }

    public void setClick(Click click) {
        this.click = click;
    }

    public void show(Prototype prototype, Batch batch, GlyphLayout layout, BitmapFont font, Rectangle rectangle, Sprite seta) {
        this.prototype = prototype;

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        layout.setText(font, text, Color.BLACK, 300, Align.center, true);
        font.draw(batch, layout, 100, 300);

        if (click != null) {
            rectangle.set(Gdx.graphics.getWidth() - 250, 50, 200, 125);
            seta.setSize(200, 125);
            seta.setPosition(Gdx.graphics.getWidth() - 250, 50);
            seta.draw(batch);
        }

        batch.end();

        this.handlesClick(rectangle);
    }

    public void handlesClick(Rectangle rectangle) {
        if (Gdx.input.justTouched()) {
            if (click != null) {
                int x = Gdx.input.getX();
                int y = Gdx.input.getY();

                if (rectangle.contains(x, Gdx.graphics.getHeight() - y)) {
                    toNext();
                }
            } else {
                toNext();
            }
        }
    }

    public abstract void toNext();

    public abstract void toPrevious();
}
