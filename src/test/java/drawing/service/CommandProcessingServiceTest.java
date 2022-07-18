package drawing.service;

import drawing.factory.TestFactory;
import drawing.utils.PaintTestUtills;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandProcessingServiceTest {

    CommandProcessingService service;
    ByteArrayOutputStream outputCapture = new ByteArrayOutputStream();
    PaintTestUtills paintTestUtils = new PaintTestUtills();
    TestFactory testFactory = new TestFactory();

    @BeforeEach
    public void setUp(){
        service = new CommandProcessingService();
        PrintStream printStream = new PrintStream(outputCapture);
        System.setOut(printStream);
    }

    @Test
    public void givenCanvasCommandVerifyOutput(){
        String command = givenCanvasCommand();
        whenServiceIsInvoked(command);
        String output = testFactory.expectedNewCanvasOutput();
        assertThatTheResultIsAsExpected(output);
    }

    @Test
    public void givenLineCommandVerifyOutput(){
        givenCanvas();

        String command = givenLineCommand();
        whenServiceIsInvoked(command);
        String output = expectedOutputForAHorizontalLine();
        assertThatTheResultIsAsExpected(output);
    }

    @Test
    public void givenRectangleCommandVerifyOutput(){
        givenCanvas();

        String command = givenRectangleCommand();
        whenServiceIsInvoked(command);
        String output = expectedOutputForARectangle();
        assertThatTheResultIsAsExpected(output);
    }

    @Test
    public void givenCanvasWithWidthAndHeightSameVerifyOutput(){
        whenServiceIsInvoked("C 4 4");
        String output = expectedOutputForCanvasWithWidthAndHeightSame();
        assertThatTheResultIsAsExpected(output);
    }

    private String givenCanvas() {
        String command = givenCanvasCommand();
        whenServiceIsInvoked(command);
        return command;
    }

    private String givenCanvasCommand(){
        return "C 20 5";
    }

    private String givenLineCommand(){
        return "L 1 3 12 3";
    }

    private String givenRectangleCommand(){
        return "R 15 2 20 5";
    }

    private void whenServiceIsInvoked(String command){
        service.processCommand(command);
    }
    private void assertThatTheResultIsAsExpected(String expectedOutput) {
        String actual = getOutputFromConsole();
        assertEquals(expectedOutput, actual);
    }

    private String getOutputFromConsole() {
        String[] lines = outputCapture.toString().split(System.lineSeparator());
        return String.join("\n", lines);
    }

    private String expectedOutputForAHorizontalLine() {
        return paintTestUtils.concatenateOutputs(testFactory.expectedNewCanvasOutput() , testFactory.expectedOutputForAHorizontalLineWithWidth12());
    }

    private String expectedOutputForARectangle() {
        return paintTestUtils.concatenateOutputs(testFactory.expectedNewCanvasOutput() , testFactory.outputForRectangle());
    }

    private String expectedOutputForCanvasWithWidthAndHeightSame() {
        return paintTestUtils.concatenateOutputs(testFactory.expectedNewCanvasOutputWidthAndHeightSame());
    }

}