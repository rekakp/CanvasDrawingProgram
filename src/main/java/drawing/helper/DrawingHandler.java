package drawing.helper;

import drawing.domain.Canvas;
import drawing.domain.Line;
import drawing.domain.Rectangle;

import static java.lang.String.valueOf;

public class DrawingHandler implements IDrawingHandler{


    public void drawRectangle(Rectangle rectangle, Canvas canvas) {
        rectangle.getBoundaryLines().forEach(line -> drawLine(line, canvas));
    }

    public void drawLine(Line line, Canvas canvas) {
        if (isVerticalLine(line)) {
            drawLineVertically(line.getX1(),
                    line.getX2(),
                    line.getY2()
                    , canvas,
                    line.getDelimiter());
        } else if (isHorizontalLine(line)) {
            drawLineHorizontally(line.getY1(),
                    line.getY2(),
                    line.getX1(),
                    canvas,
                    line.getDelimiter());
        } else {
            throw new IllegalArgumentException("Input Line command is not valid");
        }
    }

    public void drawCanvas(Canvas canvas) {
        final int maxWidth = canvas.getWidth() + 2;
        final int maxHeight = canvas.getHeight() + 2;
        char[][] canvasAsCharacters = canvas.getCanvasAsCharacters();
        drawCanvas(canvas, maxWidth, maxHeight, canvasAsCharacters);
    }


    private boolean isHorizontalLine(Line line) {
        return line.getX1().equals(line.getX2());
    }

    private boolean isVerticalLine(Line line) {
        return line.getY2().equals(line.getY1());
    }

    public void drawLineHorizontally(int y1, int y2, int columnNum, Canvas canvas, char delimiter) {
        for (int i = y1; i <= y2; i++) {
            char[][] canvasAsCharacters = canvas.getCanvasAsCharacters();
            canvasAsCharacters[i][columnNum] = delimiter;
        }
    }

    public void drawLineVertically(int x1, int x2, int rowNum, Canvas canvas, char delimiter) {
        for (int i = x1; i <= x2; i++) {
            char[][] canvasAsCharacters = canvas.getCanvasAsCharacters();
            canvasAsCharacters[rowNum][i] = delimiter;
        }
    }

    private void drawCanvas(Canvas canvas, int maxWidth, int maxHeight, char[][] canvasAsCharacters) {
        for (int rowNum = 0; rowNum < maxHeight; rowNum++) {
            if (isFirstLineOrLastLineInCanvas(rowNum, maxHeight)) {
                canvasAsCharacters[rowNum] = canvasFillFirstOrLastLine(maxWidth, canvas.getTopBottomBoundary());
            } else {
                canvasAsCharacters[rowNum] = canvasFillLinesBetween(canvas);
            }
        }
    }

    private char[] canvasFillLinesBetween(Canvas canvas) {
        String leftRightBoundary = valueOf(canvas.getLeftAndRightBoundary());
        String space = valueOf(canvas.getSpace());
        String blankLine = space.repeat(canvas.getWidth());
        String line = leftRightBoundary.concat(blankLine).concat(leftRightBoundary);
        return line.toCharArray();
    }

    private char[] canvasFillFirstOrLastLine(int width, Character character) {
        String firstAndLastLineBoundaryPattern = valueOf(character);
        return firstAndLastLineBoundaryPattern.repeat(width).toCharArray();
    }


    private boolean isFirstLineOrLastLineInCanvas(int rowNum, int maxHeight) {
        return rowNum == 0 || rowNum == maxHeight - 1;
    }
}
