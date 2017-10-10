package model.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.ArrayList;

import model.Scene;
import model.Text;

/**
 * Created by Lukas on 21/08/2017.
 */

public class InitialScene extends Scene {

    private Scene nextScene;

    public InitialScene(Texture background, Text text) {
        super(background, text);
    }

    public void setNextScene(Scene nextScene) {
        this.nextScene = nextScene;
    }

    @Override
    public void toNext() {
        prototype.setCurrentScene(nextScene);
    }

    @Override
    public void toPrevious() {
        prototype.exit();
    }
}
