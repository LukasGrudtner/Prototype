package model.text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Align;

/**
 * Created by Lukas on 29/10/2017.
 */

public class TextOnTopCenter extends Text {
    @Override
    public int getSize() {
        /* Retira 1/10 do tamanho da tela de cada lado do texto. */
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
        int height = Gdx.graphics.getHeight();
        return height - height/10;
    }

    @Override
    public int getAlign() {
        return Align.center;
    }
}
