package drawing.service;

import drawing.service.commands.DrawService;
import drawing.service.commands.LineDrawService;
import drawing.service.commands.RectangleDrawService;
import drawing.service.factory.ShapeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

class ShapeFactoryTest {

    ShapeFactory shapeFactory;

    @BeforeEach
    public void setUp(){
        shapeFactory = new ShapeFactory();
    }

    @Test
    public void givenRectangleCommandVerifyIfCorrectHandlerIsReturned(){
        String command = givenRectangleInput();
        DrawService drawService = whenFactoryMethodIsInvoked(command);
        assertThat(drawService, instanceOf(RectangleDrawService.class));
    }

    @Test
    public void givenLineCommandVerifyIfCorrectHandlerIsReturned(){
        String command = givenLineInput();
        DrawService drawService = whenFactoryMethodIsInvoked(command);
        assertThat(drawService, instanceOf(LineDrawService.class));
    }

    private DrawService whenFactoryMethodIsInvoked(String command) {
        return shapeFactory.getDrawService(command);
    }

    private String givenRectangleInput() {
        return "R 15 2 20 5";
    }

    private String givenLineInput() {
        return "L 15 5 20 5";
    }

}