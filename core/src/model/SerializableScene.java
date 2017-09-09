package model;

import java.awt.Color;

public class SerializableScene {
	
	private String sceneType;
	private String backgroundPath;
	private String text;
	private int textColorRed;
	private int textColorGreen;
	private int textColorBlue;
	private int textColorAlpha;
	private int fontSize;
	private int textX;
	private int textY;
	private int textWidth;
	private int textHeight;
	private String transitionImagePath;
	private int transitionImageX;
	private int transitionImageY;
	private int transitionImageWidth;
	private int transitionImageHeight;
	
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
	
	public int getTextX() {
		return textX;
	}
	
	public void setTextX(int textX) {
		this.textX = textX;
	}
	
	public int getTextY() {
		return textY;
	}
	
	public void setTextY(int textY) {
		this.textY = textY;
	}
	
	public int getTextWidth() {
		return textWidth;
	}
	
	public void setTextWidth(int textWidth) {
		this.textWidth = textWidth;
	}
	
	public int getTextHeight() {
		return textHeight;
	}
	
	public void setTextHeight(int textHeight) {
		this.textHeight = textHeight;
	}
	
	public String getTransitionImagePath() {
		return transitionImagePath;
	}
	
	public void setTransitionImagePath(String transitionImagePath) {
		this.transitionImagePath = transitionImagePath;
	}
	
	public int getTransitionImageX() {
		return transitionImageX;
	}
	
	public void setTransitionImageX(int transitionImageX) {
		this.transitionImageX = transitionImageX;
	}
	
	public int getTransitionImageY() {
		return transitionImageY;
	}
	
	public void setTransitionImageY(int transitionImageY) {
		this.transitionImageY = transitionImageY;
	}
	
	public int getTransitionImageWidth() {
		return transitionImageWidth;
	}
	
	public void setTransitionImageWidth(int transitionImageWidth) {
		this.transitionImageWidth = transitionImageWidth;
	}
	
	public int getTransitionImageHeight() {
		return transitionImageHeight;
	}
	
	public void setTransitionImageHeight(int transitionImageHeight) {
		this.transitionImageHeight = transitionImageHeight;
	}
}
