package model.scenes;

import com.badlogic.gdx.graphics.Texture;

import model.Scene;
import model.text.Text;

/**
 * Created by Lukas on 21/08/2017.
 */

public class IntermediateScene extends Scene {

    private Scene previousScene;
    private Scene nextScene;

    public IntermediateScene(Texture background, Text text) {
        super(background, text);
    }

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
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
        prototype.setCurrentScene(previousScene);
    }
}
