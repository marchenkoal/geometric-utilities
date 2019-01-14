package command;

import lombok.NonNull;
import ui.Output;

import java.util.Arrays;

public class CommandCreator {
    private Output output;

    public CommandCreator(@NonNull Output output) {
        this.output = output;
    }
    public Command create(String[] commandLineArguments) throws UnknownCommandException {
        String commandType = commandLineArguments[0];
        String[] commandParameters = getCommandParameters(commandLineArguments);
        switch (commandType) {
            case TriangleTypeDetermineCommand.COMMAND_NAME:
                return new TriangleTypeDetermineCommand(commandParameters, output);
            default:
                throw new UnknownCommandException(String.format("Unknown command %s", commandType));
        }
    }

    private String[] getCommandParameters(String[] arguments) {
        if (arguments.length > 1) {
            return Arrays.copyOfRange(arguments, 1, arguments.length);
        }
        return new String[0];
    }
}
