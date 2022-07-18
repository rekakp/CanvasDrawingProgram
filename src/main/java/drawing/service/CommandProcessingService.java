package drawing.service;

import drawing.domain.Canvas;
import drawing.domain.DrawWindow;
import drawing.service.commands.DrawService;
import drawing.service.factory.ShapeFactory;

import java.util.Optional;

public class CommandProcessingService {

    public static final String CANVAS_PATTERN = "C";
    private final CanvasService canvasService;
    private final ShapeFactory shapeFactory;
    private Optional<Canvas> existingCanvas;
    private DrawWindow drawWindow;

    public CommandProcessingService() {
        existingCanvas = Optional.empty();
        canvasService = new CanvasService();
        shapeFactory = new ShapeFactory();
        drawWindow = new DrawWindow();
    }

    public void processCommand(String command) {
        // This enables to support undo command in future.
        drawWindow.addCanvas(existingCanvas.orElse(null));
        Canvas canvas;
        try {
            if (command.startsWith(CANVAS_PATTERN)) {
                canvas = canvasService.validateAndCreateCanvas(command);
                existingCanvas = Optional.of(canvas);
            } else {
                canvas = existingCanvas.orElseThrow(() -> new IllegalArgumentException("Canvas not available to paint"));
                processOtherShapeCommands(command, canvas);
            }
            drawWindow.setCanvas(canvas);
            draw(drawWindow);
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
        }
    }

    private void processOtherShapeCommands(String command, Canvas canvas) {
        DrawService drawService = shapeFactory.getDrawService(command);
        drawService.draw(command, canvas);
    }

    private void printError(String message) {
        System.out.println(message);
    }

    private void draw(DrawWindow drawWindow) {
        canvasService.printCanvas(drawWindow.getCanvas());
    }
}
