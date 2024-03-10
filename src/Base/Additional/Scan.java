package Base.Additional;

import Base.CLI;
import Base.UserInterface.Process;

import java.io.InputStream;
import java.io.Writer;
import java.util.Scanner;

public class Scan {
    private Scanner scanner;

    private Process process;
    public Scan(InputStream args, Process process){
        scanner = new Scanner(args);
        this.process = process;
    }
    public Scan(InputStream args){
        scanner = new Scanner(args);
    }
    public String next(){
        String ans = scanner.next();
        if(ans.equals("exit")){
            System.exit(0);
        }
        return ans;
    }
    public String nextLine(){
        String ans = scanner.nextLine();
        if(ans.equals("exit")){
            System.exit(0);
        }
        return ans;
    }
}
