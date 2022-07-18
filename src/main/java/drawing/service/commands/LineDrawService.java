package drawing.service.commands;

import drawing.domain.Canvas;
import drawing.domain.Line;

import static java.lang.Integer.parseInt;

public class LineDrawService extends AbstractDrawService<Line> {

    private final Character delimiter = 'x';

    @Override
    public Boolean validate(String command) {
        return validator.validateLine(command);
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
        drawingHelper.drawLine(shape, canvas);
    }

}
