package drawing.service.commands;

import drawing.domain.Canvas;
import drawing.domain.Shape;

public abstract class AbstractCommandService<T extends Shape> implements CommandService<T>{

    public T executeTheSteps(String command, Canvas canvas) {
        if ( validate(command)) {
            T shape = getShape(command);
            processShape(shape , canvas);
            return shape;
        } else {
            throw new IllegalArgumentException("Input command is not valid: " + command);
        }
    }
}
