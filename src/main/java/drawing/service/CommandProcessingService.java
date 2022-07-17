package drawing.service;

import drawing.domain.Canvas;
import drawing.domain.Shape;
import drawing.service.commands.CommandService;
import drawing.service.factory.CommandFactory;

import java.util.Optional;

public class CommandProcessingService {

    public static final String CANVAS_PATTERN = "C";
    private Optional<Canvas> existingCanvas;
    private final CanvasService canvasService;
    private final CommandFactory commandFactory;

    public CommandProcessingService() {
        existingCanvas = Optional.empty();
        canvasService = new CanvasService();
        commandFactory = new CommandFactory();
    }


    public void processCommand(String command){
        try{
            if(command.startsWith(CANVAS_PATTERN)){
                validateAndCreateCanvas(command);
            } else {
                processOtherShapeCommands(command);
            }
            printCanvas();
        } catch (IllegalArgumentException exception){
            printError(exception.getMessage());
        }

    }

    private void printCanvas() {
        existingCanvas.ifPresent(canvasService::printCanvas);
    }

    private void printError(String message) {
        System.out.println(message);
    }

    private Shape  processOtherShapeCommands(String command) {
        Canvas canvas = existingCanvas.orElseThrow(() -> new IllegalArgumentException("Canvas not available to paint"));
        CommandService commandService = commandFactory.getCommandService(command);
         commandService.executeTheSteps(command, canvas);
         return null;
    }

    private void validateAndCreateCanvas(String command) {
        if(canvasService.validate(command)){
            Canvas canvas = createCanvas(command);
            canvasService.fillCanvas(canvas);
        } else {
            throw new IllegalArgumentException("Input command is not valid: " + command);
        }
    }

    private Canvas createCanvas(String command) {
        Canvas canvas = canvasService.getCanvas(command);
        setExistingCanvas(Optional.of(canvas));
        return canvas;
    }

    public void setExistingCanvas(Optional<Canvas> existingCanvas) {
        this.existingCanvas = existingCanvas;
    }
}
