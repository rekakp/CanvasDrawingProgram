package drawing.service;

import drawing.domain.Canvas;
import drawing.helper.DrawingHelper;
import drawing.validator.ShapeValidator;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class CanvasService {

    protected DrawingHelper drawingHelper;
    protected ShapeValidator validator;

    public CanvasService() {
        this.drawingHelper = new DrawingHelper();
        this.validator = new ShapeValidator();
    }

    public Boolean validate(String command) {
        return validator.validateCanvas(command);
    }

    public Canvas createCanvas(String command) {
        String[] commandArr = command.split(" ");
        int width = parseInt(commandArr[1]);
        int height = parseInt(commandArr[2]);
        return new Canvas(height, width, '|', '-', ' ');
    }

    public void printCanvas(Canvas canvas) {
        Arrays.stream(canvas.getCanvasAsCharacters()).forEach(System.out::println);
    }

    public Canvas validateAndCreateCanvas(String command) {
        if (validate(command)) {
            Canvas canvas = createCanvas(command);
            drawingHelper.fillCanvas(canvas);
            return canvas;
        } else {
            throw new IllegalArgumentException("Input command is not valid: " + command);
        }
    }

}
