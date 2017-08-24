package components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.ArrayList;

/**
 * Created by Lukas on 21/08/2017.
 */

public class IntermediateScene extends Scene {

    private Scene previousScene;
    private Scene nextScene;

    public IntermediateScene(Texture background, String text, ArrayList<Sprite> imageList, Click click) {
        super(background, text, imageList, click);
    }

    public Scene getPreviousScene() {
        return previousScene;
    }

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }

    public Scene getNextScene() {
        return nextScene;
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
