package com.prototype;

import model.text.TextOnBottomCenter;
import model.text.TextOnTopCenter;
import model.text.TextOnTopRight;

/**
 * Created by Lukas on 11/11/2017.
 */

 public class TextFactory {

     private static final String BOTTOM_CENTER = "Bottom Center";
     private static final String TOP_RIGHT = "Top Right";
     private static final String TOP_CENTER = "Top Center";

     public static Text getTextClass(String textType) {

         Text text;

         switch (textType) {
             case BOTTOM_CENTER:
                text = new TextOnBottomCenter();
                break;
             case TOP_RIGHT:
                text = new TextOnTopRight();
                break;
            case TOP_CENTER:
                text = new TextOnTopCenter();
                break;
            default:
                text = new TextOnBottomCenter();
         }

         return text;
     }

 }
