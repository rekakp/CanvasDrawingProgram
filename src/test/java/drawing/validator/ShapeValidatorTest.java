package drawing.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShapeValidatorTest {

    ShapeValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new ShapeValidator();
    }

    @ParameterizedTest
    @MethodSource("givenRectangleInvalidInputs")
    public void givenInvalidRectangleCommandFalseShouldBeReturned(String parameter) {
        assertFalse(validator.validateRectangle(parameter));
    }

    @ParameterizedTest
    @MethodSource("givenLineInvalidInputs")
    public void givenInvalidLineCommandFalseShouldBeReturned(String parameter) {
        assertFalse(validator.validateLine(parameter));
    }

    @ParameterizedTest
    @MethodSource("givenInvalidCanvasInputs")
    public void givenInvalidCanvasCommandFalseShouldBeReturned(String parameter) {
        assertFalse(validator.validateCanvas(parameter));
    }

    @Test
    public void givenValidCanvasCommandTrueShouldBeReturned() {
        assertTrue(validator.validateCanvas("C 20 5"));
    }

    @Test
    public void givenValidLineCommandTrueShouldBeReturned() {
        assertTrue(validator.validateLine("L 7 1 7 3"));
    }

    @Test
    public void givenValidRectangleCommandTrueShouldBeReturned() {
        assertTrue(validator.validateRectangle("R 15 2 20 5"));
    }


    private static Stream<Arguments> givenRectangleInvalidInputs() {
        return Stream.of(
                Arguments.of("Ra 15 2 20 5"),
                Arguments.of("R 15 2 20 5 1"),
                Arguments.of("R 2 20 5"),
                Arguments.of("R 15 2 20 five"));
    }

    private static Stream<Arguments> givenLineInvalidInputs() {
        return Stream.of(
                Arguments.of("La 7 1 7 3"),
                Arguments.of("R 15 2 20 5"),
                Arguments.of("L 7 1 7"),
                Arguments.of("L 7 1 7 3 1"),
                Arguments.of("L 7 1 10 11"));
    }

    private static Stream<Arguments> givenInvalidCanvasInputs() {
        return Stream.of(
                Arguments.of("C 7 1 7 3"),
                Arguments.of("Ca 15 2"),
                Arguments.of("Ca 152"));
    }
}
