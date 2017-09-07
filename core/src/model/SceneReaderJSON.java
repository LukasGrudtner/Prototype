package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Created by lukas on 25/08/2017.
 */

public class SceneReaderJSON {

    private static final String NUMBER_OF_SCENES = "numberOfScenes";
    private static final String SCENE_TYPE = "sceneType";
    private static final String BACKGROUND_PATH = "backgroundPath";
    private static final String TEXT = "text";
    private static final String TRANSITION_IMAGE = "transitionImage";
    private static final String TRANSITION_IMAGE_X = "transitionImageX";
    private static final String TRANSITION_IMAGE_Y = "transitionImageY";
    private static final String TRANSITION_IMAGE_WIDTH = "transitionImageWidth";
    private static final String TRANSITION_IMAGE_HEIGHT = "transitionImageHeight";

    private String filePath;

    public SceneReaderJSON(String path) {
        this.filePath = path;
    }

    public Scene getInitialScene() {
        ArrayList<Scene> sceneList = new ArrayList<Scene>();
        JSONObject jsonObject;
        JSONParser jsonParser = new JSONParser();


        FileHandle fileHandle = Gdx.files.internal(filePath);
        Reader reader = fileHandle.reader();
        BufferedReader bufferedReader = new BufferedReader(reader);

        try {
            jsonObject = (JSONObject) jsonParser.parse(bufferedReader.readLine());
            int numberOfScenes = Integer.parseInt(jsonObject.get(NUMBER_OF_SCENES).toString());

            for (int i = 0; i < numberOfScenes; i++) {
                String jsonString = bufferedReader.readLine();

                jsonObject = (JSONObject) jsonParser.parse(jsonString);

                String sceneType = (String) jsonObject.get(SCENE_TYPE);
                String backgroundPath = (String) jsonObject.get(BACKGROUND_PATH);
                String text = (String) jsonObject.get(TEXT);
                String imagePath = (String) jsonObject.get(TRANSITION_IMAGE);
                int x = Integer.parseInt(jsonObject.get(TRANSITION_IMAGE_X).toString());
                int y = Integer.parseInt(jsonObject.get(TRANSITION_IMAGE_Y).toString());
                int width = Integer.parseInt(jsonObject.get(TRANSITION_IMAGE_WIDTH).toString());
                int height = Integer.parseInt(jsonObject.get(TRANSITION_IMAGE_HEIGHT).toString());

                Scene scene = createScene(sceneType, backgroundPath, text, imagePath, x, y, width, height);
                sceneList.add(scene);
            }

            bufferedReader.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return setOrder(sceneList).get(0);
    }

    private Scene createScene(String sceneType, String backgroundPath, String text, String transitionImage,
                              int transitionX, int transitionY, int transitionWidth, int transitionHeight) {
        Scene scene = null;
        Texture textureBackground = new Texture(Gdx.files.internal(backgroundPath));
        Texture textureTransition = new Texture(Gdx.files.internal(transitionImage));
        Sprite spriteTransition = new Sprite(textureTransition, transitionX, transitionY, transitionWidth, transitionHeight);
        Transition transition = new Transition(spriteTransition);

        if (sceneType.equals(InitialScene.class.getSimpleName()))
            scene = new InitialScene(textureBackground, text, null, transition);
        else if (sceneType.equals(IntermediateScene.class.getSimpleName()))
            scene = new IntermediateScene(textureBackground, text, null, transition);
        else if (sceneType.equals(FinalScene.class.getSimpleName()))
            scene = new FinalScene(textureBackground, text, null, transition);

        return scene;
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
