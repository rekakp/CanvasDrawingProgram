package drawing;

import drawing.service.CommandProcessingService;

import java.util.Scanner;

public class InputScanner {

    public static void main(String[] args) {

        String  command;
        CommandProcessingService commandProcessingService = new CommandProcessingService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the command");
        while(!(command = scanner.nextLine()).equals("Q")) {
            commandProcessingService.processCommand(command.trim());
            System.out.println("Enter the command");
        }
        System.out.println("Quitting!");
    }
}
