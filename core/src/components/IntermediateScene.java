package components;

/**
 * Created by Lukas on 21/08/2017.
 */

public class IntermediateScene extends Scene {

    private int previous, next;

    public IntermediateScene(int index, String background, String text, int previous, int next, Click click) {
        this.index = index;
        this.background = background;
        this.text = text;
        this.previous = previous;
        this.next = next;
//        this.click = click;
    }

}