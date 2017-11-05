package model;

import java.awt.Color;

public class SerializableScene {
	
	private String sceneType;
	private String backgroundPath;
	private String text;
	private String textPosition;
	private int textColorRed;
	private int textColorGreen;
	private int textColorBlue;
	private int textColorAlpha;
	private int fontSize;
	
	public SerializableScene() {
	
	}

	public String getSceneType() {
		return sceneType;
	}

	public void setSceneType(String sceneType) {
		this.sceneType = sceneType;
	}

	public String getBackgroundPath() {
		return backgroundPath;
	}
	
	public void setBackgroundPath(String backgroundPath) {
		this.backgroundPath = backgroundPath;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public int getTextColorRed() {
		return textColorRed;
	}
	
	public int getTextColorGreen() {
		return textColorGreen;
	}
	
	public int getTextColorBlue() {
		return textColorBlue;
	}

	public int getTextColorAlpha() { return textColorAlpha; }
	
	public void setTextColor(Color textColor) {
		this.textColorRed = textColor.getRed();
		this.textColorGreen = textColor.getGreen();
		this.textColorBlue = textColor.getBlue();
		this.textColorAlpha = textColor.getAlpha();
	}
	
	public int getFontSize() {
		return fontSize;
	}
	
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	
	public String getTextPosition() {
		return textPosition;
	}

	public void setTextPosition(String textPosition) {
		this.textPosition = textPosition;
	}
}
