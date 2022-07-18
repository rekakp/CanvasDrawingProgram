package drawing.factory;

import drawing.PaintIntegrationTest;
import drawing.domain.Canvas;
import drawing.domain.Line;
import drawing.domain.Rectangle;
import drawing.utils.PaintTestUtills;

public class TestFactory {

    PaintTestUtills paintTestUtils;
    public static final String ENTER_CMD_PROMPT = "Enter the command";

    public TestFactory() {
        this.paintTestUtils = new PaintTestUtills();
    }

    public Rectangle newRectangle(int x1, int y1, int x2, int y2, char delimiter) {
        //"R 15 2 20 5"
        Rectangle rectangle = new Rectangle();
        Line upperBound = new Line(x1, y1, x1, y2, delimiter);
        Line lowerBound = new Line(x2, y1, x2, y2, delimiter);
        Line leftBound = new Line(x1, y1, x2, y1, delimiter);
        Line rightBound = new Line(x1, y2, x2, y2, delimiter);
        rectangle.addLine(upperBound);
        rectangle.addLine(lowerBound);
        rectangle.addLine(leftBound);
        rectangle.addLine(rightBound);
        return rectangle;
    }

    public Canvas newCanvasArray(int height, int width) {
        Canvas canvas = new Canvas(height , width , '|', '-', ' ');
        canvas.setCanvasAsCharacters(getNewCanvasAsArray( height,  width));
        return canvas;
    }

    private char[][] getNewCanvasAsArray(int height, int width){
        return getCharArray(height, width,
                "----------------------",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "----------------------");
    }

    public char[][] getNewCanvasWithRectangleArrr(int height, int width){
        return getCharArray(height, width,
                "----------------------",
                "|                    |",
                "|              xxxxxx|",
                "|              x    x|",
                "|              x    x|",
                "|              xxxxxx|",
                "----------------------");
    }

    private String newCanvasOutputArr() {

        return paintTestUtils.concatenateOutputs(
                "----------------------",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "----------------------");
    }


    private char[][] getCharArray(int row, int column, String... lines ){
        char[][] chars = new char[row][column];
        for (int i = 0; i < lines.length ; i++) {
            chars[i] = lines[i].toCharArray();
        }
        return chars;
    }

    public String expectedNewCanvasOutputWithPrompt() {
        return paintTestUtils.concatenateOutputs(ENTER_CMD_PROMPT, expectedNewCanvasOutput());
    }

    public String expectedNewCanvasOutput() {
        return paintTestUtils.concatenateOutputs(
                "----------------------",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "|                    |",
                "----------------------");
    }

    public String expectedNewCanvasOutputWidthAndHeightSame() {
        return paintTestUtils.concatenateOutputs(
                "------",
                "|    |",
                "|    |",
                "|    |",
                "|    |",
                "------");
    }

    public String expectedOutputForAHorizontalLineWithPrompt() {
        return paintTestUtils.concatenateOutputs(ENTER_CMD_PROMPT,
                expectedOutputForAHorizontalLine()
        );
    }

    public String expectedOutputForAHorizontalLine() {
        return paintTestUtils.concatenateOutputs(
                "----------------------",
                "|                    |",
                "|                    |",
                "|xxxxxxx             |",
                "|                    |",
                "|                    |",
                "----------------------"
        );
    }

    public String expectedOutputForAHorizontalLineWithWidth12() {
        return paintTestUtils.concatenateOutputs(
                "----------------------",
                "|                    |",
                "|                    |",
                "|xxxxxxxxxxxx        |",
                "|                    |",
                "|                    |",
                "----------------------"
        );
    }

    public String expectedOutputForAVerticalLineWithPrompt() {
        return paintTestUtils.concatenateOutputs(ENTER_CMD_PROMPT,
                expectedOutputForAVerticalLine()
        );
    }

    public String expectedOutputForAVerticalLine() {
        return paintTestUtils.concatenateOutputs(
                "----------------------",
                "|      x             |",
                "|      x             |",
                "|      x             |",
                "|                    |",
                "|                    |",
                "----------------------"
        );
    }

    public String expectedOutputForHorizontalAndVerticalLineWithPrompt() {
        return paintTestUtils.concatenateOutputs(ENTER_CMD_PROMPT,
                expectedOutputForHorizontalAndVerticalLine()
        );
    }

    public String expectedOutputForHorizontalAndVerticalLine() {
        return paintTestUtils.concatenateOutputs(
                "----------------------",
                "|      x             |",
                "|      x             |",
                "|xxxxxxx             |",
                "|                    |",
                "|                    |",
                "----------------------"
        );
    }

    public String outputForLinesAndRectangle() {
        return paintTestUtils.concatenateOutputs(PaintIntegrationTest.ENTER_CMD_PROMPT,
                "----------------------",
                "|      x             |",
                "|      x       xxxxxx|",
                "|xxxxxxx       x    x|",
                "|              x    x|",
                "|              xxxxxx|",
                "----------------------"
        );
    }

    public String outputForRectangle() {
        return paintTestUtils.concatenateOutputs(
                "----------------------",
                "|                    |",
                "|              xxxxxx|",
                "|              x    x|",
                "|              x    x|",
                "|              xxxxxx|",
                "----------------------");

    }
}
