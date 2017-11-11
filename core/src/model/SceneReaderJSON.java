package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import model.scenes.InitialScene;
import model.scenes.IntermediateScene;
import model.scenes.Scene;
import model.scenes.SerializableScene;
import model.text.Text;

import com.prototype.TextFactory;
import com.prototype.SceneFactory;

/**
 * Created by lukas on 25/08/2017.
 */

public class SceneReaderJSON {

    private String filePath;

    public SceneReaderJSON(String path) {
        this.filePath = path;
    }

    public Scene getInitialScene() {
        ArrayList<Scene> sceneList = createScenes(readSerializableScenes());
        return setOrder(sceneList).get(0);
    }

    private ArrayList<SerializableScene> readSerializableScenes() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<SerializableScene>>() {}.getType();
        String stringJson = "";

        try {
            FileHandle fileHandle = Gdx.files.internal(filePath);
            Reader reader = fileHandle.reader();
            BufferedReader bufferedReader = new BufferedReader(reader);
            stringJson = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return gson.fromJson(stringJson, type);
    }

    private ArrayList<Scene> createScenes(ArrayList<SerializableScene> serializableSceneList) {
        ArrayList<Scene> sceneList = new ArrayList<Scene>();


        for (SerializableScene serializableScene : serializableSceneList) {
            String background = serializableScene.getBackgroundPath();

            /* Define o texto. */
            Text text = TextFactory.getTextClass(serializableScene.getTextPosition());

            text.setText(serializableScene.getText());
            text.setColor(new Color(serializableScene.getTextColorRed(), serializableScene.getTextColorGreen(),
                    serializableScene.getTextColorBlue(), serializableScene.getTextColorAlpha()));

            /* Inicializa a cena com base no seu tipo. */
            Scene scene = SceneFactory.getSceneClass(serializableScene.getSceneType(), background, text);

            sceneList.add(scene);
        }

        return sceneList;
    }

    /* Define a cena anterior e sucessora de cada cena na lista. */
    private ArrayList<Scene> setOrder(ArrayList<Scene> scenes) {
        for (int i = 0; i < scenes.size(); i++) {
            if (i == 0)
                ((InitialScene) scenes.get(i)).setNextScene(scenes.get(i+1));
            else if (i == scenes.size()-1)
                ((model.scenes.FinalScene) scenes.get(i)).setPreviousScene(scenes.get(i-1));
            else {
                ((model.scenes.IntermediateScene) scenes.get(i)).setNextScene(scenes.get(i+1));
                ((IntermediateScene) scenes.get(i)).setPreviousScene(scenes.get(i-1));
            }
        }

        return scenes;
    }
}
