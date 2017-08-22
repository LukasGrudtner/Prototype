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

    public ArrayList<Scene> getScenesGame(int numberGame) {

        ArrayList<Scene> scenes = new ArrayList<Scene>();

        if (numberGame == 1) {
            Click clickObject = new Click(new Texture(Gdx.files.internal("seta.png")));

            Texture background = new Texture(Gdx.files.internal("fundo.png"));
            Texture background2 = new Texture(Gdx.files.internal("fundo2.png"));
            Texture background3 = new Texture(Gdx.files.internal("fundo3.png"));
            Texture background4 = new Texture(Gdx.files.internal("fundo.png"));

            Scene scene1 = new InitialScene(0, background, "Finalmente chegou o dia de ir ao dentista!", 2, null);
            Scene scene2 = new IntermediateScene(1, background2, "E por isto este roteiro irá me ajudar a entender e aprender tudo o que é preciso para tornar este dia muito especial!", 1, 3, null);
            Scene scene3 = new IntermediateScene(2, background3, "Quando você estiver pronto, aperte na seta para iniciarmos nossa jornada!", 2, 4, clickObject);
            Scene scene4 = new FinalScene(3, background, "Aperte na seta para finalizar!", 3, clickObject);

            scenes.add(scene1);
            scenes.add(scene2);
            scenes.add(scene3);
            scenes.add(scene4);
        }

        if (numberGame == 2) {

            Texture background = new Texture(Gdx.files.internal("fundo3.png"));
            Texture background2 = new Texture(Gdx.files.internal("fundo2.png"));
            Texture background3 = new Texture(Gdx.files.internal("fundo3.png"));

            Scene scene1 = new InitialScene(0, background3, "Segundo jogo!", 2, null);
            Scene scene2 = new IntermediateScene(1, background3, "Tela 2 do segundo jogo, clique para continuar", 1, 3, null);
            Scene scene3 = new FinalScene(2, background2, "Última tela! Clique para finalizar", 2, null);

            scenes.add(scene1);
            scenes.add(scene2);
            scenes.add(scene3);
        }

        if (numberGame == 3) {

            Click clickObject = new Click(new Texture(Gdx.files.internal("seta.png")));
            Texture background = new Texture(Gdx.files.internal("fundo3.png"));
            Texture background2 = new Texture(Gdx.files.internal("fundo2.png"));
            Texture background3 = new Texture(Gdx.files.internal("fundo3.png"));

            Scene scene1 = new InitialScene(0, background, "1", 2, clickObject);
            Scene scene2 = new IntermediateScene(1, background, "2", 1, 3, clickObject);
            Scene scene3 = new IntermediateScene(1, background, "3", 2, 4, null);
            Scene scene4 = new IntermediateScene(1, background, "4", 3, 5, clickObject);
            Scene scene5 = new FinalScene(2, background2, "5", 4, clickObject);

            scenes.add(scene1);
            scenes.add(scene2);
            scenes.add(scene3);
            scenes.add(scene4);
            scenes.add(scene5);
        }

        return scenes;
    }

}
