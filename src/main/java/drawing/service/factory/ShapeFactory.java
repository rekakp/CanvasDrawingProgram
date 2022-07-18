package drawing.service.factory;

import drawing.service.commands.DrawService;
import drawing.service.commands.LineDrawService;
import drawing.service.commands.RectangleDrawService;

public class ShapeFactory {

    public static final String LINE_PREFIX = "L";
    public static final String RECTANGLE_PREFIX = "R";

    public DrawService getDrawService(String command){

        if(command.startsWith(LINE_PREFIX))
            return new LineDrawService();
        else if(command.startsWith(RECTANGLE_PREFIX))
            return new RectangleDrawService();

        throw new IllegalArgumentException("Invalid Command Passed");
    }

}
