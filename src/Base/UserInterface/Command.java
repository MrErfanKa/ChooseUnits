package Base;

public class Command {
    String args, command;

    public Command(String args, String command) {
        this.args = args;
        this.command = command;
    }

    public String getArgs() {
        return args;
    }

    public String getCommand() {
        return command;
    }
}
