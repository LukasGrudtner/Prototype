package factories;

import model.text.Text;
import model.text.TextOnBottomCenter;
import model.text.TextOnTopCenter;
import model.text.TextOnTopRight;

/**
 * Created by Lukas on 11/11/2017.
 */

 public class TextFactory {

     public enum TextType {BOTTOM_CENTER, TOP_RIGHT, TOP_CENTER}

     public static Text getTextClass(TextType textType) {

         switch (textType) {
             case BOTTOM_CENTER:
                return new TextOnBottomCenter();
             case TOP_RIGHT:
                return new TextOnTopRight();
            case TOP_CENTER:
                return new TextOnTopCenter();
            default:
                throw new RuntimeException();
         }
     }

 }
