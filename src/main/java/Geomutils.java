import command.Command;
import command.CommandCreator;
import command.UnknownCommandException;
import ui.DefaultOutput;
import ui.Output;

public class Geomutils {

    public static void main(String[] args) {
        if (args.length < 1) {
            printHelp();
            return;
        }
        try {
            Output output = new DefaultOutput();
            CommandCreator commandCreator = new CommandCreator(output);
            Command command = commandCreator.create(args);
            command.execute();
        } catch (UnknownCommandException e) {
            System.out.println(e.getMessage());
            printHelp();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printHelp() {

        System.out.println("Example of usage:\r\n");
        System.out.println("\tjava Geomutils triangle-type 3.0 3.1 3.1\r\n");
        System.out.println("Here triangle-type - triangle type definition command; 3.0 3.1 3.1 - triangle sides ");
    }
}
