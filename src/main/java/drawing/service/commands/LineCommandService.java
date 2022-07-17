package drawing.service.commands;

import drawing.domain.Canvas;
import drawing.domain.Line;
import drawing.domain.Shape;

import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class LineCommandService extends AbstractCommandService<Line> {

    private final Character delimiter = '*';
    private final String regex = "^L(\\s(\\d)+){4}$";

    @Override
    public Boolean validate(String command) {
        return Pattern.matches(regex , command);
    }

    @Override
    public Line getShape(String command) {
        String[] commandArr = command.split(" ");
        int x1 = parseInt(commandArr[1]);
        int y1 = parseInt(commandArr[2]);
        int x2 = parseInt(commandArr[3]);
        int y2 = parseInt(commandArr[4]);
        Line line = new Line(x1, y1, x2, y2, delimiter);
        return line;
    }

    @Override
    public void processShape(Line shape, Canvas canvas) {
        Line line = shape;
        if (isVerticalLine(line)) {
            drawLineVertically(line.getFirstXCoordinate(), line.getSecondXCoordinate(), line.getSecondYCoordinate()
                    , canvas);
        } else if(isHorizontalLine(line)) {
            drawLineHorizontally(line.getFirstYCoordinate(), line.getSecondYCoordinate(), line.getFirstXCoordinate(), canvas);
        } else {
            throw new IllegalArgumentException("Input Line command is not valid");
        }
    }



    private boolean isHorizontalLine(Line line) {
        return line.getFirstXCoordinate().equals(line.getSecondXCoordinate());
    }

    private boolean isVerticalLine(Line line) {
        return line.getSecondYCoordinate().equals(line.getFirstYCoordinate());
    }

    public void drawLineHorizontally(int firstYCoordinate, int secondYCoordinate, int columnNum ,  Canvas canvas){
        for (int i = firstYCoordinate; i <= secondYCoordinate ; i++) {
            char[][] canvasAsCharacters = canvas.getCanvasAsCharacters();
            canvasAsCharacters[i][columnNum] = 'x';
        }
    }

    public void drawLineVertically(int firstXCoordinate, int secondXCoordinate, int rowNum ,  Canvas canvas){
        for (int i = firstXCoordinate; i <= secondXCoordinate ; i++) {
            char[][] canvasAsCharacters = canvas.getCanvasAsCharacters();
            canvasAsCharacters[rowNum][i] = 'x';
        }
    }
}
