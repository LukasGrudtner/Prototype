package components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by lukas on 05/08/2017.
 */

public class DialogBox {

    private SpriteBatch batch;
    private Texture texture;
    private String text = "";
    private float x = 0;
    private float y = 0;
    private float width = 0;
    private float height = 0;
    private BitmapFont font;

    public DialogBox(String text, Texture texture, SpriteBatch batch, float x, float y, float width, float height, int fontSize) {
        this.batch = batch;
        this.text = text;
        this.x = x;
        this.y = y;

        this.texture = texture;
        font = new BitmapFont();
        font.getData().setScale(fontSize);
        font.setColor(Color.BLACK);
    }

    public void draw() {
        batch.draw(texture, x, y, width, height);
        font.draw(batch, text, x, y);
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
