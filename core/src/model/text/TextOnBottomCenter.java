package model.text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Align;

/**
 * Created by Lukas on 29/10/2017.
 */

public class TextOnBottomCenter extends Text {
    @Override
    public int getSize() {
        int maxSize = Gdx.graphics.getWidth()-(Gdx.graphics.getWidth()/5);
        return maxSize;
    }

    @Override
    public int getX() {
        int margin = Gdx.graphics.getWidth() - this.getSize();
        return margin/2;
    }

    @Override
    public int getY() {
        int extraLines = getText().length()/50;
        int height = Gdx.graphics.getHeight();
        return extraLines*height/32 + height/8;
    }

    @Override
    public int getAlign() {
        return Align.center;
    }
}
