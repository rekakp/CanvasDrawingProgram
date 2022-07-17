package drawing.utils;

import java.io.ByteArrayInputStream;

public class PaintTestUtills {

    public void setInput(String userInput) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
    }

    public void givenCommands(String... commands) {
        String input = String.join("\n", commands);
        setInput(input);
    }

    public String concatenateOutputs(String... outputLines) {
        return String.join("\n", outputLines);
    }
}
