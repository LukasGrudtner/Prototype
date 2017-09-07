package com.prototype;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import static com.prototype.R.id.button2;

public class MainActivity extends Activity {

    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONParser parser = new JSONParser();

        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initGame("game1.json");
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initGame("game2.txt");
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initGame("game3.txt");
            }
        });
    }

    private void initGame(String path) {
        Intent intent = new Intent(MainActivity.this, AndroidLauncher.class);
        intent.putExtra("GAME", path);
        startActivity(intent);
    }

}

