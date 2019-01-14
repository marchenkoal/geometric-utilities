package ui;

public class DefaultOutput implements Output{
    @Override
    public void put(String outString) {
        System.out.println(outString);
    }
}
