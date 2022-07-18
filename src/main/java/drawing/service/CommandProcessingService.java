package drawing.service;

import drawing.domain.Canvas;
import drawing.service.commands.DrawService;
import drawing.service.factory.ShapeFactory;

import java.util.Optional;

public class CommandProcessingService {

    public static final String CANVAS_PATTERN = "C";
    private Optional<Canvas> existingCanvas;
    private final CanvasService canvasService;
    private final ShapeFactory shapeFactory;

    public CommandProcessingService() {
        existingCanvas = Optional.empty();
        canvasService = new CanvasService();
        shapeFactory = new ShapeFactory();
    }

    public void processCommand(String command) {
        try {
            if (command.startsWith(CANVAS_PATTERN)) {
                Canvas canvas = canvasService.validateAndCreateCanvas(command);
                existingCanvas = Optional.of(canvas);
            } else {
                Canvas canvas = existingCanvas.orElseThrow(() -> new IllegalArgumentException("Canvas not available to paint"));
                processOtherShapeCommands(command , canvas);
            }
            existingCanvas.ifPresent(canvasService::printCanvas);
        } catch (IllegalArgumentException exception) {
            printError(exception.getMessage());
        }
    }

    private void  processOtherShapeCommands(String command , Canvas canvas) {
        DrawService drawService = shapeFactory.getDrawService(command);
        drawService.draw(command, canvas);
    }

    private void printError(String message) {
        System.out.println(message);
    }
}
