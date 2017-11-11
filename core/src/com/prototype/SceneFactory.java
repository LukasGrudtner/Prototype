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

     private static final String INITIAL_SCENE = "InitialScene";
     private static final String INTERMEDIATE_SCENE = "IntermediateScene";
     private static final String FINAL_SCENE = "FinalScene";

     public static Scene getInitialScene(String path) {
         SceneReaderJSON sceneReader = new SceneReaderJSON(path);
        return sceneReader.getInitialScene();
     }

     public static Scene getSceneClass(String sceneType, String background, Text text) {

         Scene scene;

         switch (sceneType) {
             case INITIAL_SCENE:
                scene = new InitialScene(background, text);
                break;
            case INTERMEDIATE_SCENE:
                scene = new IntermediateScene(background, text);
                break;
            case FINAL_SCENE:
                scene = new FinalScene(background, text);
                break;
            default:
                scene = null;
         }

         return scene;
     }

 }
