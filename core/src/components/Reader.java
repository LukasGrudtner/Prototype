package components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lukas on 25/08/2017.
 */

public class Reader {

    private String path;

    public Reader(String path) {
        this.path = path;
    }

    public InitialScene getInitialScene() {

        ArrayList<Scene> scenes = new ArrayList<Scene>();
        String type = "";
        String background = "";
        String text = "";
        String transitionImage = "";
        int transitionX, transitionY, transitionWidth, transitionHeight;

        FileHandle fileHandle = Gdx.files.internal(path);
        java.io.Reader reader = fileHandle.reader();

        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            int count = Integer.parseInt(bufferedReader.readLine());
            while (count > 0) {
                count--;
                Scene scene = null;
                type = bufferedReader.readLine();
                background = bufferedReader.readLine();
                text = bufferedReader.readLine();
                transitionImage = bufferedReader.readLine();
                transitionX = Integer.parseInt(bufferedReader.readLine());
                transitionY = Integer.parseInt(bufferedReader.readLine());
                transitionWidth = Integer.parseInt(bufferedReader.readLine());
                transitionHeight = Integer.parseInt(bufferedReader.readLine());

                if (type.equals("InitialScene")) {
                    Texture textureBackground = new Texture(Gdx.files.internal(background));
                    Texture textureTransition = new Texture(Gdx.files.internal(transitionImage));
                    Sprite spriteTransition = new Sprite(textureTransition, transitionX, transitionY, transitionWidth, transitionHeight);
                    Transition transition = new Transition(spriteTransition);

                    scene = new InitialScene(textureBackground, text, null, transition);
                }

                if (type.equals("IntermediateScene")) {
                    Texture textureBackground = new Texture(Gdx.files.internal(background));
                    Texture textureTransition = new Texture(Gdx.files.internal(transitionImage));
                    Sprite spriteTransition = new Sprite(textureTransition, transitionX, transitionY, transitionWidth, transitionHeight);
                    Transition transition = new Transition(spriteTransition);

                    scene = new IntermediateScene(textureBackground, text, null, transition);
                }

                if (type.equals("FinalScene")) {
                    Texture textureBackground = new Texture(Gdx.files.internal(background));
                    Texture textureTransition = new Texture(Gdx.files.internal(transitionImage));
                    Sprite spriteTransition = new Sprite(textureTransition, transitionX, transitionY, transitionWidth, transitionHeight);
                    Transition transition = new Transition(spriteTransition);

                    scene = new FinalScene(textureBackground, text, null, transition);
                }

                scenes.add(scene);

                bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (InitialScene) this.setOrder(scenes).get(0);
    }

    private ArrayList<Scene> setOrder(ArrayList<Scene> scenes) {
        for (int i = 0; i < scenes.size(); i++) {
            if (i == 0)
                ((InitialScene) scenes.get(i)).setNextScene(scenes.get(i+1));
            else if (i == scenes.size()-1)
                ((FinalScene) scenes.get(i)).setPreviousScene(scenes.get(i-1));
            else {
                ((IntermediateScene) scenes.get(i)).setNextScene(scenes.get(i+1));
                ((IntermediateScene) scenes.get(i)).setPreviousScene(scenes.get(i-1));
            }
        }

        return scenes;
    }
}
