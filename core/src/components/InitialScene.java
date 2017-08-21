package components;

/**
 * Created by Lukas on 21/08/2017.
 */

public class InitialScene extends Scene {

    private int next;

    public InitialScene(int index, String background, String text, int next, Click click) {
        this.index = index;
        this.background = background;
        this.text = text;
        this.next = next;
//        this.click = click;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }
}
