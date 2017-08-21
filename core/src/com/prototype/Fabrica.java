package com.prototype;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import components.InitialScene;
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

                scene = new InitialScene(index, backgroundPath, text, 0, null);
                scenes.add(scene);
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scenes;
    }
}
