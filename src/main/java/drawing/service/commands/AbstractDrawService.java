package drawing.service.commands;

import drawing.domain.Canvas;
import drawing.domain.Shape;
import drawing.helper.DrawingHandler;
import drawing.validator.ShapeValidator;

public abstract class AbstractDrawService<T extends Shape> implements DrawService<T> {

    protected DrawingHandler drawingHandler;
    protected ShapeValidator validator;

    public AbstractDrawService() {
        this.drawingHandler = new DrawingHandler();
        this.validator = new ShapeValidator();
    }

    public T draw(String command, Canvas canvas) {
        if (validate(command)) {
            T shape = getShape(command);
            processShape(shape, canvas);
            return shape;
        } else {
            throw new IllegalArgumentException("Input command is not valid: " + command);
        }
    }
}
