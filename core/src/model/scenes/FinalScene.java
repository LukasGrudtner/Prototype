package model.scenes;

import model.text.Text;

/**
 * Created by Lukas on 21/08/2017.
 */

public class FinalScene extends Scene {

    private Scene previousScene;

    public FinalScene(String background, Text text) {
        super(background, text);
    }

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }

    @Override
    public void toNext() {
        prototype.exit();
    }

    @Override
    public void toPrevious() {
        prototype.setCurrentScene(previousScene);
    }
}
