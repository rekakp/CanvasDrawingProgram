package drawing.service.commands;


import drawing.domain.Canvas;
import drawing.domain.Rectangle;
import drawing.domain.Shape;
import drawing.domain.Line;
import drawing.service.commands.AbstractCommandService;
import drawing.service.commands.LineCommandService;

import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class RectangleCommandService extends AbstractCommandService<Rectangle> {

    private final Character delimiter = '*';
    private final String regex = "^R(\\s(\\d)+){4}$";

    @Override
    public Boolean validate(String command) {
        return Pattern.matches(regex , command);
    }

    @Override
    public Rectangle getShape(String command) {
        String[] commandArr = command.split(" ");
        int x1 = parseInt(commandArr[1]);
        int y1 = parseInt(commandArr[2]);
        int x2 = parseInt(commandArr[3]);
        int y2 = parseInt(commandArr[4]);

        Rectangle rectangle = new Rectangle();
        Line upperBound = new Line(x1, y1 , x1 , y2 , delimiter);
        Line lowerBound = new Line(x2, y1 , x2, y2 , delimiter);
        Line leftBound = new Line( x1 , y1 , x2, y1 , delimiter);
        Line rightBound = new Line( x1 , y2 , x2, y2 , delimiter);
        rectangle.addLine(upperBound);
        rectangle.addLine(lowerBound);
        rectangle.addLine(leftBound);
        rectangle.addLine(rightBound);
        return rectangle;
    }

    @Override
    public void processShape(Rectangle shape, Canvas canvas) {
        Rectangle rectangle =  shape;
        LineCommandService lineCommandService = new LineCommandService();
        rectangle.getBoundaryLines().forEach(line -> lineCommandService.processShape(line, canvas));
    }

}
