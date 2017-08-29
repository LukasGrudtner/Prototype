package com.prototype;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import components.InitialScene;
import jdk.nashorn.internal.parser.JSONParser;
import json.JSONObject;

/**
 * Created by Lukas on 21/08/2017.
 */

public class Factory {

    public InitialScene getInitialScene(String path) {

        components.Reader reader = new components.Reader(path);

        return reader.getInitialScene();
    }

    public void createJSON() {
        JSONObject jsonObject = new JSONObject();
        FileWriter fileWriter = null;



        FileHandle fileHandle = Gdx.files.internal("teste.json");
        Writer writer = fileHandle.writer(false);

        jsonObject.put("Nome", "Lukas");
        jsonObject.put("Sobrenome", "Grüdtner");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(jsonObject.toString());
            bufferedWriter.close();

            Gdx.app.log("TESTE", "criou o arquivo");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gdx.app.log("TESTE", jsonObject + "");
    }

//    public void readJSON() {
//        JSONObject jsonObject;
//        JSONParser parser = new JSONParser();
//
//        String nome, sobrenome;
//
//        try {
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

}
