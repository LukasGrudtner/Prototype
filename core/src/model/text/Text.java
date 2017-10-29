package model.text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by Lukas on 09/09/2017.
 */

public abstract class Text {

    private String text = "";
    private Color color;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract int getSize();
//    public int getSize() {
//        /* Retira 1/10 do tamanho da tela de cada lado do texto. */
//        int maxSize = Gdx.graphics.getWidth()-(Gdx.graphics.getWidth()/5);
//        return maxSize;
//    }

    public abstract int getX();
//    public int getX() {
//        int margin = Gdx.graphics.getWidth() - this.getSize();
//        return margin/2;
//    }

    public abstract int getY();
//    public int getY() {
//        /* Define o número de linhas do texto, para ajustar a altura do texto na tela. */
//        int extraLines = text.length()/50;
//        int height = Gdx.graphics.getHeight();
//        return extraLines*height/32 + height/8;
//    }

    public abstract int getAlign();
}
