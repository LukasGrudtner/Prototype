package com.prototype;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.prototype.Prototype;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String path = getIntent().getExtras().getString("GAME");
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new Prototype(path), config);
	}
}
