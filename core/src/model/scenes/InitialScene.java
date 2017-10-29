package model.scenes;

import com.badlogic.gdx.graphics.Texture;

import model.Scene;
import model.text.Text;

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
