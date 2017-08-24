package com.prototype;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import components.Click;
import components.FinalScene;
import components.InitialScene;
import components.IntermediateScene;
import components.Scene;

/**
 * Created by Lukas on 21/08/2017.
 */

public class Fabrica {


    public ArrayList<Scene> readAllScenes() {
        ArrayList<Scene> scenes = new ArrayList<Scene>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/android/res/raw/config.txt"));
            Gdx.app.log("TESTE", "encontrou arquivo");
            int index;
            String backgroundPath, text;
            String linha = "";

            Scene scene;

            while (bufferedReader.ready()) {
                linha = bufferedReader.readLine();
                index = Integer.parseInt(linha);
                backgroundPath = bufferedReader.readLine();
                text = bufferedReader.readLine();
                bufferedReader.readLine();

//                scene = new InitialScene(index, backgroundPath, text, 0, null);
//                scenes.add(scene);
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scenes;
    }

    public InitialScene getInitialScene(int numberGame) {

        InitialScene initialScene = new InitialScene(null, null, null, null);

        if (numberGame == 1) {
            Click clickObject = new Click(new Texture(Gdx.files.internal("seta.png")) );

            Texture background = new Texture(Gdx.files.internal("fundo.png"));

            initialScene = new InitialScene(background, "Cena inicial", null, clickObject);
            IntermediateScene scene2 = new IntermediateScene(background, "Cena 2", null, clickObject);
            IntermediateScene scene3 = new IntermediateScene(background, "Cena 3", null, clickObject);
            FinalScene finalScene = new FinalScene(background, "Cena final", null, clickObject);

            initialScene.setNextScene(scene2);
            scene2.setPreviousScene(initialScene);
            scene2.setNextScene(scene3);
            scene3.setPreviousScene(scene2);
            scene3.setNextScene(finalScene);
            finalScene.setPreviousScene(scene3);
        }

        if (numberGame == 2) {
            Click clickObject = new Click(new Texture(Gdx.files.internal("seta.png")) );

            Texture background2 = new Texture(Gdx.files.internal("fundo2.png"));

            initialScene = new InitialScene(background2, "Cena inicial", null, clickObject);
            IntermediateScene scene2 = new IntermediateScene(background2, "Cena 2", null, clickObject);
            IntermediateScene scene3 = new IntermediateScene(background2, "Cena 3", null, clickObject);
            FinalScene finalScene = new FinalScene(background2, "Cena final", null, clickObject);

            initialScene.setNextScene(scene2);
            scene2.setPreviousScene(initialScene);
            scene2.setNextScene(scene3);
            scene3.setPreviousScene(scene2);
            scene3.setNextScene(finalScene);
            finalScene.setPreviousScene(scene3);
        }

        if (numberGame == 3) {
            Click clickObject = new Click(new Texture(Gdx.files.internal("seta.png")) );

            Texture background3 = new Texture(Gdx.files.internal("fundo3.png"));

            initialScene = new InitialScene(background3, "Cena inicial", null, clickObject);
            IntermediateScene scene2 = new IntermediateScene(background3, "Cena 2", null, clickObject);
            IntermediateScene scene3 = new IntermediateScene(background3, "Cena 3", null, clickObject);
            FinalScene finalScene = new FinalScene(background3, "Cena final", null, clickObject);

            initialScene.setNextScene(scene2);
            scene2.setPreviousScene(initialScene);
            scene2.setNextScene(scene3);
            scene3.setPreviousScene(scene2);
            scene3.setNextScene(finalScene);
            finalScene.setPreviousScene(scene3);
        }


        return initialScene;
    }

}
