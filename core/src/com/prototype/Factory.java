package com.prototype;

import components.InitialScene;

/**
 * Created by Lukas on 21/08/2017.
 */

public class Factory {

    public InitialScene getInitialScene(String path) {

        components.Reader reader = new components.Reader(path);

        return reader.getInitialScene();
    }

}
