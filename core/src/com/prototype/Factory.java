package com.prototype;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import components.Click;
import components.FinalScene;
import components.InitialScene;
import components.IntermediateScene;
import components.Scene;

/**
 * Created by Lukas on 21/08/2017.
 */

public class Factory {

    public InitialScene getInitialScene(String path) {

        components.Reader reader = new components.Reader(path);

        return reader.getInitialScene();
    }

}
