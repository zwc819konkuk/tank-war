package DP.command;

public class InsertCommand extends Command {
    Content c;
    String strToInsert = "http://www.baidu.com";

    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doIt() {
        c.msg = c.msg + strToInsert;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length() - strToInsert.length());
    }
}
