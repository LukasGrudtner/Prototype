package com.prototype;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.prototype.Prototype;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		int numberGame = getIntent().getExtras().getInt("GAME");
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new Prototype(numberGame), config);
	}
}
