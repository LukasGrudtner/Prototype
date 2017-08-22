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

    SpriteBatch batch;
    Sprite dialogBox;
    BitmapFont text;
    Texture background, background2, background3;
    GlyphLayout layout;
    Sprite seta;
    Rectangle rectangle;
    TextField textField;
    private Fabrica fabrica;
    private ArrayList<Scene> scenes;
    private int currentScene = 0;
    private int numberGame;

    float alturaDispositivo = 0;
    float larguraDispositivo = 0;

    // Câmera
    OrthographicCamera camera;
    Viewport viewport;
    float VIRTUAL_WIDTH = 0;
    float VIRTUAL_HEIGHT = 0;

    Texture[] textures;
    float variacao = 0;
    float movimentacao = -200;

    public Prototype(int numberGame) {
        this.numberGame = numberGame;
    }

	@Override
	public void create() {

        fabrica = new Fabrica();
        scenes = fabrica.getScenesGame(numberGame);

        rectangle = new Rectangle();
        layout = new GlyphLayout();

        batch = new SpriteBatch();
        dialogBox = new Sprite(new Texture(Gdx.files.internal("dialogBox.png")));
        seta = new Sprite(new Texture(Gdx.files.internal("seta.png")));
        dialogBox.setPosition(50, 150);
        text = new BitmapFont();
        text.getData().setScale(3);

        alturaDispositivo = VIRTUAL_HEIGHT = Gdx.graphics.getHeight();
        larguraDispositivo = VIRTUAL_WIDTH = Gdx.graphics.getWidth();

        dialogBox.setSize(larguraDispositivo - 80, alturaDispositivo - 600);

        // Configuração da Cãmera
        camera = new OrthographicCamera();
        camera.position.set(VIRTUAL_WIDTH/2, VIRTUAL_HEIGHT/2, 0);
        viewport = new StretchViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);

        textures = new Texture[11];
        textures[0] = new Texture("pomba1.png");
        textures[1] = new Texture("pomba2.png");
        textures[2] = new Texture("pomba3.png");
        textures[3] = new Texture("pomba4.png");
        textures[4] = new Texture("pomba5.png");
        textures[5] = new Texture("pomba6.png");
        textures[6] = new Texture("pomba7.png");
        textures[7] = new Texture("pomba8.png");
        textures[8] = new Texture("pomba9.png");
        textures[9] = new Texture("pomba10.png");
        textures[10] = new Texture("pomba11.png");
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

        batch.begin();
        batch.draw(scenes.get(currentScene).getBackground(), 0, 0, larguraDispositivo, alturaDispositivo);
        dialogBox.draw(batch);
        layout.setText(text, scenes.get(currentScene).getText(), Color.BLACK, dialogBox.getWidth(), Align.center, true);
        text.draw(batch, layout, dialogBox.getX()+(dialogBox.getWidth()-layout.width)/2 - 20, dialogBox.getY()+(dialogBox.getHeight()+layout.height)/2 + 50);

        if (scenes.get(currentScene).getClick() != null) {
            rectangle.set(larguraDispositivo-250, 50, 200, 125);
            seta.setSize(200, 125);
            seta.setPosition(larguraDispositivo-250, 50);
            seta.draw(batch);
        }


        batch.end();

        if (Gdx.input.justTouched()) {

            if (scenes.get(currentScene).getClick() != null) {
                int x = Gdx.input.getX();
                int y = Gdx.input.getY();

                if (rectangle.contains(x, alturaDispositivo - y)) {
                    if (!scenes.get(currentScene).getClass().equals(FinalScene.class))
                        currentScene++;
                    else {
                        Gdx.app.exit();
                    }
                }
            } else {
                if (!scenes.get(currentScene).getClass().equals(FinalScene.class))
                    currentScene++;
                else
                    Gdx.app.exit();
            }
        }

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
