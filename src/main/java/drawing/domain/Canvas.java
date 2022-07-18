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
        this.canvasAsCharacters = new char[height + 2][width + 2];
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Canvas canvas = (Canvas) o;

        if (height != canvas.height) return false;
        if (width != canvas.width) return false;
        if (leftAndRightBoundary != null ? !leftAndRightBoundary.equals(canvas.leftAndRightBoundary) : canvas.leftAndRightBoundary != null)
            return false;
        if (topAndBottomLineBoundary != null ? !topAndBottomLineBoundary.equals(canvas.topAndBottomLineBoundary) : canvas.topAndBottomLineBoundary != null)
            return false;
        return space != null ? space.equals(canvas.space) : canvas.space == null;
    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + width;
        result = 31 * result + (leftAndRightBoundary != null ? leftAndRightBoundary.hashCode() : 0);
        result = 31 * result + (topAndBottomLineBoundary != null ? topAndBottomLineBoundary.hashCode() : 0);
        result = 31 * result + (space != null ? space.hashCode() : 0);
        return result;
    }
}
