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

import components.DialogBox;

public class Prototype implements ApplicationListener {

    SpriteBatch batch;
    Sprite dialogBox;
    BitmapFont text;
    Texture background, background2, background3;
    GlyphLayout layout;
    Sprite seta;
    Rectangle rectangle;
    TextField textField;

    boolean finalizar = false;

    int act = 1;

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
    // Teste
//    DialogBox dialogBox;

	@Override
	public void create() {

        rectangle = new Rectangle();
        layout = new GlyphLayout();

        batch = new SpriteBatch();
        background = new Texture(Gdx.files.internal("fundo.png"));
        background2 = new Texture(Gdx.files.internal("fundo2.png"));
        background3 = new Texture(Gdx.files.internal("fundo3.png"));
        dialogBox = new Sprite(new Texture(Gdx.files.internal("dialogBox.png")));
        seta = new Sprite(new Texture(Gdx.files.internal("seta.png")));
        dialogBox.setPosition(50, 150);
        text = new BitmapFont();
        text.getData().setScale(3);

        TextField.TextFieldStyle tfs = new TextField.TextFieldStyle();
        tfs.font = text;
        textField = new TextField("Qual é o seu nome?", tfs);

//        dialogBox = new DialogBox("Oi, eu sou o Goku!", new Texture(Gdx.files.internal("dialogBox.png")), batch, 50, 150, 300, 100, 4)

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

        // Desenha a textura
        batch.begin();

        if (act == 1)
            act1();
        if (act == 2)
            act2();
        if (act == 3)
            act3();
        if (act == 4)
            act4();

        batch.end();

        if (Gdx.input.justTouched()) {
            if (act < 3)
                act++;
        }

	}

    private void act1() {
        batch.draw(background, 0, 0, larguraDispositivo, alturaDispositivo);
        dialogBox.draw(batch);
        layout.setText(text, "Finalmente chegou o dia de ir ao dentista!", Color.BLACK, dialogBox.getWidth(), Align.center, true);
        text.draw(batch, layout, dialogBox.getX()+(dialogBox.getWidth()-layout.width)/2 - 20, dialogBox.getY()+(dialogBox.getHeight()+layout.height)/2 + 50);
    }

    private void act2() {
        batch.draw(background2, 0, 0, larguraDispositivo, alturaDispositivo);
        dialogBox.draw(batch);
        text.getData().setScale(2);
        layout.setText(text, "E por isso este roteiro irá me ajudar a entender e aprender tudo que é preciso para tornar este dia muito especial!", Color.BLACK, dialogBox.getWidth()-50, Align.center, true);
        text.draw(batch, layout, dialogBox.getX()+(dialogBox.getWidth()-layout.width)/2, dialogBox.getY()+(dialogBox.getHeight()+layout.height)/2+50);
    }

    private void act3() {
        batch.draw(background3, 0, 0, larguraDispositivo, alturaDispositivo);
        dialogBox.draw(batch);

        rectangle.set(larguraDispositivo-250, 50, 200, 125);

        seta.setSize(200, 125);
        seta.setPosition(larguraDispositivo-250, 50);
        seta.draw(batch);

        text.getData().setScale(2);
        layout.setText(text, "Quando você estiver pronto, aperte na seta para iniciarmos nossa jornada!", Color.BLACK, dialogBox.getWidth()-50, Align.center, true);
        text.draw(batch, layout, dialogBox.getX()+(dialogBox.getWidth()-layout.width)/2, dialogBox.getY()+(dialogBox.getHeight()+layout.height)/2+50);

        if (Gdx.input.isTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();

            if (rectangle.contains(x, alturaDispositivo-y))
                act = 4;
        }
    }

    private void act4() {
        batch.draw(background, 0, 0, larguraDispositivo, alturaDispositivo);
        if (variacao > 10)
            variacao = 0;

        if (movimentacao > Gdx.graphics.getWidth())
            movimentacao = -200;

        batch.draw(textures[(int) variacao], movimentacao, 800);
        variacao += Gdx.graphics.getDeltaTime() * 10;
        movimentacao += Gdx.graphics.getDeltaTime() * 400;

        dialogBox.draw(batch);
        text.getData().setScale(3);
        layout.setText(text, "Aperte na seta para finalizar", Color.BLACK, dialogBox.getWidth()-50, Align.center, true);
        text.draw(batch, layout, dialogBox.getX()+(dialogBox.getWidth()-layout.width)/2, dialogBox.getY()+(dialogBox.getHeight()+layout.height)/2+80);

        rectangle.set(50, 50, 200, 125);

        seta.setSize(200, 125);
        seta.setPosition(50, 50);
        seta.draw(batch);

        if (Gdx.input.isTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();

            if (rectangle.contains(x, alturaDispositivo-y)) {
                Gdx.app.log("TOUCHED", "foi clicado na tela " + act);
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
