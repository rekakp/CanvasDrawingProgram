package drawing.helper;

import drawing.domain.Canvas;
import drawing.domain.Line;
import drawing.domain.Rectangle;

public interface IDrawingHandler {
    public void drawRectangle(Rectangle rectangle, Canvas canvas);
    public void drawLine(Line line, Canvas canvas);
    public void drawCanvas(Canvas canvas) ;
}
