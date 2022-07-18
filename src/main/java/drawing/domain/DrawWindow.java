package drawing.domain;

import java.util.Stack;

/**
 * The previousCanvas is stored to enable Undo
 */
public class DrawWindow {

    Canvas canvas;

    Stack<Canvas> previousCanvas = new Stack<>();

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Stack<Canvas> getPreviousCanvas() {
        return previousCanvas;
    }

    public void setPreviousCanvas(Stack<Canvas> previousCanvas) {
        this.previousCanvas = previousCanvas;
    }

    public void addCanvas(Canvas canvas) {
        previousCanvas.push(canvas);
    }
}
