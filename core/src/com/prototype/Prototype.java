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
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import components.DialogBox;

public class Prototype implements ApplicationListener {

    SpriteBatch batch;
    Sprite dialogBox;
    BitmapFont text;
    Texture background;
    GlyphLayout layout;
    Sprite seta;
    Rectangle rectangle;

    int act = 1;

    float alturaDispositivo = 0;
    float larguraDispositivo = 0;

    // Câmera
    OrthographicCamera camera;
    Viewport viewport;
    float VIRTUAL_WIDTH = 0;
    float VIRTUAL_HEIGHT = 0;

    // Teste
//    DialogBox dialogBox;

	@Override
	public void create() {

        rectangle = new Rectangle();
        layout = new GlyphLayout();

        batch = new SpriteBatch();
        background = new Texture(Gdx.files.internal("fundo.png"));
        dialogBox = new Sprite(new Texture(Gdx.files.internal("dialogBox.png")));
        seta = new Sprite(new Texture(Gdx.files.internal("seta.png")));
        dialogBox.setPosition(50, 150);
        text = new BitmapFont();
        text.getData().setScale(4);

//        dialogBox = new DialogBox("Oi, eu sou o Goku!", new Texture(Gdx.files.internal("dialogBox.png")), batch, 50, 150, 300, 100, 4)

        alturaDispositivo = VIRTUAL_HEIGHT = Gdx.graphics.getHeight();
        larguraDispositivo = VIRTUAL_WIDTH = Gdx.graphics.getWidth();

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

        // Desenha a textura
        batch.begin();
        batch.draw(background, 0, 0, larguraDispositivo, alturaDispositivo);

        if (act == 1)
            act1();
        if (act == 2)
            act2();
        if (act == 3)
            act3();
        if (act == 4)
            act4();

        batch.end();

        if (Gdx.input.justTouched())
            if (act < 3)
                act++;



	}

    private void act1() {
        dialogBox.draw(batch);
        layout.setText(text, "Finalmente chegou\no dia de ir ao dentista!", Color.BLACK, dialogBox.getWidth(), Align.center, true);
        text.draw(batch, layout, dialogBox.getX()+(dialogBox.getWidth()-layout.width)/2-40, dialogBox.getY()+(dialogBox.getHeight()+layout.height)/2+80);
    }

    private void act2() {
        dialogBox.draw(batch);
        text.getData().setScale(3);
        layout.setText(text, "E por isso este roteiro irá me ajudar a entender e aprender tudo que é preciso para tornar este dia muito especial!", Color.BLACK, dialogBox.getWidth()-50, Align.center, true);
        text.draw(batch, layout, dialogBox.getX()+(dialogBox.getWidth()-layout.width)/2, dialogBox.getY()+(dialogBox.getHeight()+layout.height)/2+80);
    }

    private void act3() {
        dialogBox.draw(batch);

        rectangle.set(500, 50, 200, 125);

        seta.setSize(200, 125);
        seta.setPosition(500, 50);
        seta.draw(batch);

        text.getData().setScale(3);
        layout.setText(text, "Quando você estiver pronto, aperte na seta para iniciarmos nossa jornada!", Color.BLACK, dialogBox.getWidth()-50, Align.center, true);
        text.draw(batch, layout, dialogBox.getX()+(dialogBox.getWidth()-layout.width)/2, dialogBox.getY()+(dialogBox.getHeight()+layout.height)/2+80);

        if (Gdx.input.isTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            
            if (rectangle.contains(x, alturaDispositivo-y))
                act = 4;
        }
    }

    private void act4() {
        dialogBox.draw(batch);
        text.getData().setScale(5);
        layout.setText(text, "Tela 4", Color.BLACK, dialogBox.getWidth()-50, Align.center, true);
        text.draw(batch, layout, dialogBox.getX()+(dialogBox.getWidth()-layout.width)/2, dialogBox.getY()+(dialogBox.getHeight()+layout.height)/2+80);
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
