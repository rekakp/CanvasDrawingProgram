package drawing.service.commands;

import drawing.domain.Canvas;
import drawing.domain.Shape;

public interface DrawService<T extends Shape> {

    public Boolean validate(String command);

    public T getShape(String command);

    public void processShape(T shape, Canvas canvas);

    public T draw(String command, Canvas canvas);

}
