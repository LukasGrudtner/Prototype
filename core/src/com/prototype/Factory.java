package com.prototype;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.Reader;
import components.InitialScene;

/**
 * Created by Lukas on 21/08/2017.
 */

public class Factory {

    public InitialScene getInitialScene(String path) {

        components.Reader reader = new components.Reader(path);
        readJSON();
        return reader.getInitialScene();
    }

    public void readJSON() {
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();

        String text;
        FileHandle fileHandle = Gdx.files.internal("teste.json");
        Reader reader = fileHandle.reader();
        try {
            jsonObject = (JSONObject) parser.parse(reader);
            text = (String) jsonObject.get("text");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
