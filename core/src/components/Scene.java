package components;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Lukas on 21/08/2017.
 */

public abstract class Scene {

    protected int index;
    protected Texture background;
    protected String text;
    protected Click click;


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
}
