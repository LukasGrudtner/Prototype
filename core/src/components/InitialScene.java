package components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.ArrayList;

/**
 * Created by Lukas on 21/08/2017.
 */

public class InitialScene extends Scene {

    private Scene nextScene;

    public InitialScene(Texture background, String text, ArrayList<Sprite> imageList, Transition transition) {
        super(background, text, imageList, transition);
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

    }
}
