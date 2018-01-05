package model.scenes;

import com.prototype.SceneFactory;
import com.prototype.TextFactory;

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

	public SceneFactory.SceneType getSceneType() {
		switch (sceneType) {
			case "InitialScene":
				return SceneFactory.SceneType.INITIAL;
			case "IntermediateScene":
				return SceneFactory.SceneType.INTERMEDIATE;
			case "FinalScene":
				return SceneFactory.SceneType.FINAL;
            default:
                throw new RuntimeException();
		}
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
	
	public TextFactory.TextType getTextPosition() {
		switch (textPosition) {
			case "Bottom Center":
				return TextFactory.TextType.BOTTOM_CENTER;
			case "Top Right":
				return TextFactory.TextType.TOP_RIGHT;
			case "Top Center":
				return TextFactory.TextType.TOP_CENTER;
			default:
				throw new RuntimeException();
		}
	}

	public void setTextPosition(String textPosition) {
		this.textPosition = textPosition;
	}
}
