package model.text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Align;

/**
 * Created by Lukas on 29/10/2017.
 */

public class TextOnTopRight extends Text {

    @Override
    public int getSize() {
        /* Retira 1/2 do tamanho da tela de cada lado do texto. */
        int maxSize = Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8;
        return maxSize;
    }

    @Override
    public int getX() {
        int margin = Gdx.graphics.getWidth()/2 + Gdx.graphics.getWidth()/15;
        return margin;
    }

    @Override
    public int getY() {
        int height = Gdx.graphics.getHeight();
        return height - height/10;
    }

    @Override
    public int getAlign() {
        return Align.topRight;
    }
}
