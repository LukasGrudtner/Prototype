package com.prototype;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import static com.prototype.R.id.button2;

public class MainActivity extends Activity {

    private Button button1, button2, button3;
    private static final String ARQUIVO_PREFERENCIAS = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initGame(1);
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initGame(2);
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initGame(3);
            }
        });

    }

    private void saveNumberGame(int number) {
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIAS, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("GAME", number);
        editor.commit();
    }

    private void initGame(int numberGame) {
        Intent intent = new Intent(MainActivity.this, AndroidLauncher.class);
        intent.putExtra("GAME", numberGame);
        startActivity(intent);
    }

}

