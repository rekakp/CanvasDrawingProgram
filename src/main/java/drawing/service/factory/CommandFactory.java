package drawing.service.factory;

import drawing.domain.Line;
import drawing.domain.Shape;
import drawing.service.commands.CommandService;
import drawing.service.commands.LineCommandService;
import drawing.service.commands.RectangleCommandService;

public class CommandFactory {

    public  CommandService getCommandService(String command){
        if(command.startsWith("L"))
            return new LineCommandService();
        else if(command.startsWith("R"))
            return new RectangleCommandService();

        throw new IllegalArgumentException("Invalid Command Passed");
    }

}
