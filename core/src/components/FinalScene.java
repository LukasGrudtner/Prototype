package components;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Lukas on 21/08/2017.
 */

public class FinalScene extends Scene {

    private int previous;

    public FinalScene(int index, Texture background, String text, int previous, Click click) {
        this.index = index;
        this.background = background;
        this.text = text;
        this.previous = previous;
        this.click = click;
    }


}
