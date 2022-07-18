package drawing;

import drawing.factory.TestFactory;
import drawing.utils.PaintTestUtills;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaintIntegrationTest {

    public static final String CANVAS_NOT_AVAILABLE_TO_PAINT = "Canvas not available to paint";
    public static final String INVALID_INPUT_ERR = "Input command is not valid: ";
    public static final String ENTER_CMD_PROMPT = "Enter the command";
    ByteArrayOutputStream outputCapture = new ByteArrayOutputStream();
    PaintTestUtills paintTestUtils = new PaintTestUtills();
    TestFactory testFactory = new TestFactory();

    @BeforeEach
    public void setUp() {
        PrintStream printStream = new PrintStream(outputCapture);
        System.setOut(printStream);
    }

    @AfterEach
    public void tearDown() {
        outputCapture = new ByteArrayOutputStream();
    }

    @Test
    public void testNewCanvas() {
        paintTestUtils.givenCommands("C 20 5", "Q");
        whenPaintIsInvoked();
        String output = expectedOutputForANewCanvas();
        assertThatTheResultIsAsExpected(output);
    }

    @Test
    public void testCanvasWithHorizontalLine() {
        paintTestUtils.givenCommands("C 20 5", "L 1 3 7 3", "Q");
        whenPaintIsInvoked();
        String output = expectedOutputForCanvasWithHorizontalLine();
        assertThatTheResultIsAsExpected(output);
    }

    @Test
    public void testCanvasWithVerticalLine() {
        paintTestUtils.givenCommands("C 20 5", "L 7 1 7 3", "Q");
        whenPaintIsInvoked();
        String output = expectedOutputForCanvasWithVerticalLine();
        assertThatTheResultIsAsExpected(output);
    }

    @Test
    public void testCanvasWithHorizontalAndVerticalLine() {
        paintTestUtils.givenCommands("C 20 5", "L 7 1 7 3", "L 1 3 7 3", "Q");
        whenPaintIsInvoked();
        assertThatTheResultIsAsExpected(expectedOutputForCanvasWithVerticalAndHorizontalLine());
    }

    @Test
    public void testCanvasWithHorizontalAndVerticalLineAndRectangle() {
        paintTestUtils.givenCommands("C 20 5", "L 7 1 7 3", "L 1 3 7 3", "R 15 2 20 5", "Q");
        whenPaintIsInvoked();
        assertThatTheResultIsAsExpected(expectedOutputForCanvasWithLinesAndRectangle());
    }

    @Test
    public void testPaintWithoutCanvas() {
        paintTestUtils.givenCommands("L 7 1 7 3", "Q");
        whenPaintIsInvoked();
        assertThatTheResultIsAsExpected(expectedOutputForPaintingOnEmptyCanvas(CANVAS_NOT_AVAILABLE_TO_PAINT));
    }

    @Test
    public void testPaintWithInvalidCommand() {
        String invalidCommand = "LA 7 1 7 3";
        paintTestUtils.givenCommands("C 20 5", invalidCommand, "Q");
        whenPaintIsInvoked();
        assertThatTheResultIsAsExpected(expectedOutputForInvalidCommand(INVALID_INPUT_ERR + invalidCommand));
    }

    private void whenPaintIsInvoked() {
        InputScanner.main(null);
    }

    private void assertThatTheResultIsAsExpected(String expectedOutput) {
        String actual = getOutputFromConsole();
        assertEquals(expectedOutput, actual);
    }

    private String getOutputFromConsole() {
        String[] lines = outputCapture.toString().split(System.lineSeparator());
        return String.join("\n", lines);
    }

    private String endingCommands() {
        return paintTestUtils.concatenateOutputs(ENTER_CMD_PROMPT,
                "Quitting!");
    }

    private String expectedOutputForANewCanvas() {
        return paintTestUtils.concatenateOutputs(testFactory.expectedNewCanvasOutputWithPrompt(), endingCommands());
    }

    private String expectedOutputForCanvasWithHorizontalLine() {
        return paintTestUtils.concatenateOutputs(testFactory.expectedNewCanvasOutputWithPrompt(), testFactory.expectedOutputForAHorizontalLineWithPrompt(), endingCommands());
    }

    private String expectedOutputForCanvasWithVerticalLine() {
        return paintTestUtils.concatenateOutputs(testFactory.expectedNewCanvasOutputWithPrompt(), testFactory.expectedOutputForAVerticalLineWithPrompt(), endingCommands());
    }

    private String expectedOutputForCanvasWithVerticalAndHorizontalLine() {
        return paintTestUtils.concatenateOutputs(testFactory.expectedNewCanvasOutputWithPrompt(),
                testFactory.expectedOutputForAVerticalLineWithPrompt(),
                testFactory.expectedOutputForHorizontalAndVerticalLineWithPrompt(),
                endingCommands());
    }

    private String expectedOutputForCanvasWithLinesAndRectangle() {
        return paintTestUtils.concatenateOutputs(testFactory.expectedNewCanvasOutputWithPrompt(),
                testFactory.expectedOutputForAVerticalLineWithPrompt(),
                testFactory.expectedOutputForHorizontalAndVerticalLineWithPrompt(),
                testFactory.outputForLinesAndRectangle(),
                endingCommands());
    }

    private String expectedOutputForPaintingOnEmptyCanvas(String expectedMessage) {
        return paintTestUtils.concatenateOutputs(ENTER_CMD_PROMPT,
                expectedMessage,
                endingCommands());
    }

    private String expectedOutputForInvalidCommand(String expectedMessage) {
        return paintTestUtils.concatenateOutputs(testFactory.expectedNewCanvasOutputWithPrompt(),
                ENTER_CMD_PROMPT,
                expectedMessage,
                endingCommands());
    }

}
