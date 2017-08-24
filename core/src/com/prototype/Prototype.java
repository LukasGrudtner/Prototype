package com.prototype;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

import components.FinalScene;
import components.Scene;


public class Prototype implements ApplicationListener {

    private Scene currentScene;

    private SpriteBatch batch;
    private BitmapFont font;
    private GlyphLayout layout;
    private Sprite seta;
    private Rectangle rectangle;

    private Fabrica fabrica;
    private int numberGame;

    // Câmera
    private OrthographicCamera camera;
    private Viewport viewport;
    private float VIRTUAL_WIDTH = 0;
    private float VIRTUAL_HEIGHT = 0;

    public Prototype(int numberGame) {
        this.numberGame = numberGame;
    }

	@Override
	public void create() {

        fabrica = new Fabrica();
        currentScene = fabrica.getInitialScene(numberGame);

        rectangle = new Rectangle();
        layout = new GlyphLayout();

        batch = new SpriteBatch();

        seta = new Sprite(new Texture(Gdx.files.internal("seta.png")));

        font = new BitmapFont();
        font.getData().setScale(3);

        VIRTUAL_HEIGHT = Gdx.graphics.getHeight();
        VIRTUAL_WIDTH = Gdx.graphics.getWidth();

        // Configuração da Cãmera
        camera = new OrthographicCamera();
        camera.position.set(VIRTUAL_WIDTH/2, VIRTUAL_HEIGHT/2, 0);
        viewport = new StretchViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);

	}

	@Override
	public void resize(int width, int height) {
        viewport.update(width, height);
	}

	@Override
	public void render() {

        camera.update();

		// Limpa a tela antes de desenhar
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        // Configurar dados de projeção da câmera
        batch.setProjectionMatrix(camera.combined);

        // Chama o método para renderizar o batch
        currentScene.show(this, batch, layout, font, rectangle, seta);

	}

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    public void exit() {
        Gdx.app.exit();
    }

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
        batch.dispose();
	}
}
