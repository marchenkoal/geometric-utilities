package command;

import model.Triangle;
import ui.Output;

public class TriangleTypeDetermineCommand implements Command {
    static final String COMMAND_NAME = "triangle-type";
    private String[] parameters;
    private Output output;

    TriangleTypeDetermineCommand(String[] parameters, Output output) {
        init(parameters);
        this.output = output;
    }

    private void init(String[] parameters) {
        if (parameters.length != 3) {
            throw new IllegalArgumentException(String.format("Command parameters %s must consist of 3 numbers", COMMAND_NAME));
        }
        this.parameters = parameters;
    }

    private double parseNumber(String number) {
        return Double.parseDouble(number);
    }

    @Override
    public void execute() {
        Triangle triangle = CreateTriangle(parameters);
        output.put(String.format("Triangular type is %s", triangle.getTriangleType()));
    }

    private Triangle CreateTriangle(String[] parameters) {
        return Triangle.builder()
                .firstSide(parseNumber(parameters[0]))
                .secondSide(parseNumber(parameters[1]))
                .thirdSide(parseNumber(parameters[2]))
                .build();
    }
}
