package com.prototype;

import model.scenes.InitialScene;
import model.scenes.IntermediateScene;
import model.scenes.FinalScene;
import model.text.Text;

/**
 * Created by Lukas on 11/11/2017.
 */

 public class SceneFactory {

     private static final String INITIAL_SCENE = InitialScene.getClass().getSimpleName();
     private static final String INTERMEDIATE_SCENE = IntermediateScene.getClass().getSimpleName();
     private static final String FINAL_SCENE = FinalScene.getClass().getSimpleName();

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
