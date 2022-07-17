package drawing.domain;

public class Canvas {

    int height;
    int width;
    Character leftAndRightBoundary;
    Character topAndBottomLineBoundary;
    Character space;

    char[][] canvasAsCharacters;

    public Canvas(int height, int width) {
        this.height = height;
        this.width = width;
        this.canvasAsCharacters = new char[height + 2][width+ 2];
    }

    public Canvas(int height, int width, Character leftRightBoundary, Character topBottomBoundary, Character space) {
        this(height, width);
        this.leftAndRightBoundary = leftRightBoundary;
        this.topAndBottomLineBoundary = topBottomBoundary;
        this.space = space;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getCanvasAsCharacters() {
        return canvasAsCharacters;
    }

    public void setCanvasAsCharacters(char[][] canvasAsCharacters) {
        this.canvasAsCharacters = canvasAsCharacters;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Character getLeftAndRightBoundary() {
        return leftAndRightBoundary;
    }

    public Character getTopBottomBoundary() {
        return topAndBottomLineBoundary;
    }

    public Character getSpace() {
        return space;
    }
}
