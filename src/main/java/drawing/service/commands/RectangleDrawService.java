package drawing.service.commands;


import drawing.domain.Canvas;
import drawing.domain.Line;
import drawing.domain.Rectangle;

import static java.lang.Integer.parseInt;

public class RectangleDrawService extends AbstractDrawService<Rectangle> {

    private final Character delimiter = 'x';

    @Override
    public Boolean validate(String command) {
        return validator.validateRectangle(command);
    }

    @Override
    public Rectangle getShape(String command) {
        String[] commandArr = command.split(" ");
        int x1 = parseInt(commandArr[1]);
        int y1 = parseInt(commandArr[2]);
        int x2 = parseInt(commandArr[3]);
        int y2 = parseInt(commandArr[4]);

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

    @Override
    public void processShape(Rectangle shape, Canvas canvas) {
        drawingHelper.drawRectangle(shape, canvas);
    }

}
