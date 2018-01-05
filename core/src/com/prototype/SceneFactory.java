package com.prototype;

import model.scenes.Scene;
import model.SceneReaderJSON;
import model.scenes.InitialScene;
import model.scenes.IntermediateScene;
import model.scenes.FinalScene;
import model.text.Text;

/**
 * Created by Lukas on 11/11/2017.
 */

 public class SceneFactory {

     public enum SceneType {INITIAL, INTERMEDIATE, FINAL}

     public static Scene getInitialScene(String path) {
         SceneReaderJSON sceneReader = new SceneReaderJSON(path);
        return sceneReader.getInitialScene();
     }

     public static Scene getSceneClass(SceneType sceneType, String background, Text text) {

         switch (sceneType) {
             case INITIAL:
                return new InitialScene(background, text);
             case INTERMEDIATE:
                return new IntermediateScene(background, text);
             case FINAL:
                return new FinalScene(background, text);
            default:
                throw new RuntimeException();
         }
     }

 }
