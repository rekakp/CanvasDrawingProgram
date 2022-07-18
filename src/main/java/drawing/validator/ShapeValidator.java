package drawing.validator;

import java.util.regex.Pattern;

public class ShapeValidator {
    private final String LINE_REGEX = "^L(\\s(\\d)+){4}$";
    private final String RECTANGLE_REGEX = "^R(\\s(\\d)+){4}$";
    private final String CANVAS_REGEX = "^C\\s(\\d)+\\s(\\d)+$";

    public Boolean validateLine(String command) {
        return Pattern.matches(LINE_REGEX, command);
    }

    public Boolean validateRectangle(String command) {
        return Pattern.matches(RECTANGLE_REGEX, command);
    }

    public Boolean validateCanvas(String command) {
        return Pattern.matches(CANVAS_REGEX, command);
    }
}
