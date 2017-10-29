package com.prototype;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import model.Scene;


public class Prototype implements ApplicationListener {

    private Scene currentScene;

    private SpriteBatch batch;
    private BitmapFont font;
    private GlyphLayout layout;
    private Texture textureTransition;

    private Rectangle rectangle;


    private Factory factory;
    private String path;

    // Câmera
    private OrthographicCamera camera;
    private Viewport viewport;
    private float VIRTUAL_WIDTH = 0;
    private float VIRTUAL_HEIGHT = 0;

    // Objetos padrões da tela


    public Prototype(String path) {
        this.path = path;
    }

	@Override
	public void create() {

        factory = new Factory();
        currentScene = factory.getInitialScene(path);

        layout = new GlyphLayout();

        batch = new SpriteBatch();

        font = new BitmapFont();
        font.getData().setScale(2);

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
        currentScene.show(this, batch, layout, font);

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
