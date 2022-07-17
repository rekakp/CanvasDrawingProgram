package drawing.service;

import drawing.domain.Canvas;

import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.util.regex.Pattern.matches;

public class CanvasService {

    private final String canvasRegex= "^C\\s(\\d)+\\s(\\d)+$";

    public Boolean validate(String command) {
        return matches(canvasRegex , command);
    }

    public Canvas getCanvas(String command) {
        String[] commandArr = command.split(" ");
        int width = parseInt(commandArr[1]);
        int height = parseInt(commandArr[2]);
        return new Canvas(height , width , '|' , '-' , ' ');
    }

    public void printCanvas(Canvas canvas) {
        Arrays.stream(canvas.getCanvasAsCharacters()).forEach(System.out::println);
    }

    public void fillCanvas(Canvas canvas) {
        populateLines(canvas);
    }

    private void populateLines(Canvas canvas) {
        final int maxWidth = canvas.getWidth() + 2;
        final int maxHeight = canvas.getHeight() + 2;
        char[][] canvasAsCharacters = canvas.getCanvasAsCharacters();
        for (int rowNum = 0; rowNum < maxHeight; rowNum++) {
            if (firstLineOrLastLine(rowNum, maxHeight)) {
                canvasAsCharacters[rowNum] = fillFirstOrLastLine(maxWidth , canvas.getTopBottomBoundary());
            } else {
                canvasAsCharacters[rowNum] = fillOtherLines(canvas);
            }
        }
    }

    private char[] fillOtherLines(Canvas canvas) {
        String leftRightBoundary = valueOf(canvas.getLeftAndRightBoundary());
        String space = valueOf(canvas.getSpace());
        String blankLine = space.repeat(canvas.getWidth());
        String line = leftRightBoundary.concat(blankLine).concat(leftRightBoundary);
        return line.toCharArray();
    }

    private char[] fillFirstOrLastLine(int width, Character character) {
        String firstAndLastLineBoundaryPattern = valueOf(character);
        return firstAndLastLineBoundaryPattern.repeat(width).toCharArray();
    }


    private boolean firstLineOrLastLine(int rowNum, int maxHeight) {
        return rowNum == 0 || rowNum == maxHeight - 1;
    }

}
