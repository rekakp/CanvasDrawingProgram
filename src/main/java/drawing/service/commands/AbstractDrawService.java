package drawing.service.commands;

import drawing.domain.Canvas;
import drawing.domain.Shape;

import drawing.helper.DrawingHelper;
import drawing.validator.ShapeValidator;

public abstract class AbstractDrawService<T extends Shape> implements DrawService<T> {

   protected DrawingHelper drawingHelper;
   protected ShapeValidator validator;

    public AbstractDrawService() {
        this.drawingHelper = new DrawingHelper();
        this.validator = new ShapeValidator();
    }

    public T draw(String command, Canvas canvas) {
        if ( validate(command)) {
            T shape = getShape(command);
            processShape(shape , canvas);
            return shape;
        } else {
            throw new IllegalArgumentException("Input command is not valid: " + command);
        }
    }
}
