package DP.command;

public class Main {
    public static void main(String[] args) {
        Content c = new Content();

        Command insertCommand = new InsertCommand(c);
        insertCommand.doIt();
        insertCommand.undo();

        Command copyCommand = new CopyCommand(c);
        copyCommand.doIt();
//        copyCommand.undo();

        System.out.println(c);
    }
}
