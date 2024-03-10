package Base.UserInterface;

public class Command {
    String command, arg2, arg1;

    public Command(String command, String arg1, String arg2) {
        this.command = command;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public String getCommand() {
        return command;
    }

    public String getArg2() {
        return arg2;
    }

    public String getArg1() {
        return arg1;
    }
}
