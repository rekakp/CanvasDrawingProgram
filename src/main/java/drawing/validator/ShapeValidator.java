package drawing.validator;

import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class ShapeValidator {
    private final String LINE_REGEX = "^L(\\s(\\d)+){4}$";
    private final String RECTANGLE_REGEX = "^R(\\s(\\d)+){4}$";
    private final String CANVAS_REGEX = "^C\\s(\\d)+\\s(\\d)+$";

    public Boolean validateLine(String command) {
        boolean matches = Pattern.matches(LINE_REGEX, command);
        if (!matches) {
            return false;
        } else {
            String[] commandArr = command.split(" ");
            int x1 = parseInt(commandArr[1]);
            int y1 = parseInt(commandArr[2]);
            int x2 = parseInt(commandArr[3]);
            int y2 = parseInt(commandArr[4]);
            return x1 == x2 || y1 == y2;
        }
    }

    public Boolean validateRectangle(String command) {
        return Pattern.matches(RECTANGLE_REGEX, command);
    }

    public Boolean validateCanvas(String command) {
        return Pattern.matches(CANVAS_REGEX, command);
    }
}
