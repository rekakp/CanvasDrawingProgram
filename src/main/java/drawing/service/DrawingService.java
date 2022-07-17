package drawing.service;

import drawing.domain.Canvas;
import drawing.domain.Line;
import drawing.domain.Rectangle;
import drawing.service.commands.LineCommandService;

public class DrawingService {


    public void process(Rectangle shape, Canvas canvas) {
        Rectangle rectangle =  shape;
        LineCommandService lineCommandService = new LineCommandService();
        rectangle.getBoundaryLines().forEach(line -> process(line, canvas));
    }

    public void process(Line line, Canvas canvas) {
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
