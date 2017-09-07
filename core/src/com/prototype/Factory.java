package com.prototype;

import model.InitialScene;
import model.SceneReaderJSON;

/**
 * Created by Lukas on 21/08/2017.
 */

public class Factory {

    public InitialScene getInitialScene(String path) {

        SceneReaderJSON sceneReader = new SceneReaderJSON(path);
        return (InitialScene) sceneReader.getInitialScene();
    }
}
