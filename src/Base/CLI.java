package Base;

import Base.Accounts.Account;
import Base.Accounts.Admin;
import Base.Units.CoreCourse;
import Base.Units.Course;
import Base.Units.SpecializedCourse;
import Base.University.College;
import Base.UserInterface.Command;
import Base.UserInterface.Process;

import java.util.ArrayList;
import java.util.Scanner;

public class CLI {
    private Account account;
    private Process process;
    private College college;
    private Course course;
    private Scanner sc;
    private String enter;

    public Account getAccount() {
        return account;
    }


    public Course getCourse() {
        return course;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public College getCollege() {
        return college;
    }

    public String type = "welcomePage";
    public void init(){
        College math = new College("Math");
        math.addCourseToCollege(new CoreCourse("poornaki", "22016", 257, 4, "12:00",
                "Shanbe - Doshanbe", "10:30-12:30", "1403/3/24", "riazi2"));
        math.addCourseToCollege(new SpecializedCourse("ardeshir", "22142", 70, 4, "08:00",
                "Yekshanbe - Seshanbe", "10:30-12:30", "1403/3/22", "mabani riazi"));
        math.addCourseToCollege(new SpecializedCourse("Boomery", "22815", 111, 4, "15:30",
                "Shanbe - Doshanbe", "13:00-15:00", "1403/3/26", "AP"));


        College physic = new College("Physic");
        physic.addCourseToCollege(new CoreCourse("AboalHassani", "24012", 40, 3, "09:00",
                "Shanbe - Doshanbe", "10:30-12:00", "1403/3/31", "Physic2"));
        physic.addCourseToCollege(new CoreCourse("araghi", "24001", 40, 3, "12:00",
                "Yekshanbe - Seshanbe", "09:00-10:30", "1403/3/20", "Physic1"));
        physic.addCourseToCollege(new SpecializedCourse("mirkamali", "24214", 35, 3, "09:00",
                "Shanbe - Doshanbe", "16:30-18:00", "1403/3/26", "Electro"));

        College computer = new College("CE");
        computer.addCourseToCollege(new SpecializedCourse("zarabi", "40115", 200, 3, "09:00",
                "Yekshanbe - Seshanbe", "10:30-12:30", "1403/3/22", "gossaste"));
        computer.addCourseToCollege(new SpecializedCourse("hesabi", "40212", 95, 3, "15:30",
                "Yekshanbe - Seshanbe", "09:00-10:30", "1403/3/24", "medar Manteghi"));
        computer.addCourseToCollege(new CoreCourse("abam", "40254", 50, 3, "09:00",
                "Shanbe - Doshanbe", "10:30-12:30", "1403/3/22", "algorithm"));

        College mechanic = new College("Mech");
        mechanic.addCourseToCollege(new SpecializedCourse("jokar", "28015", 35, 3, "15:30",
                "Yekshanbe - Seshanbe", "15:00-16:30", "1403/3/21", "static"));
        mechanic.addCourseToCollege(new CoreCourse("dorali", "28139", 37, 2, "15:00",
                "Shanbe - Doshanbe", "12:30-16:30", "1403/3/25", "ashMech"));
        mechanic.addCourseToCollege(new SpecializedCourse("afshin", "28116", 58, 3, "15:30",
                "Shanbe - Doshanbe", "09:00-10:30", "1403/3/30", "thermodynamic"));
    }
    public CLI() {
        sc = new Scanner(System.in);
        process = new Process(this);
    }
    public boolean check(String in){
        for(int i = 0; i < in.length(); i++){
            char c = in.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '1' && c <= '9'))
                continue;
            return false;
        }
        return true;
    }

    public void run(){
        while(true){
            {

            }
            if (type.equals("welcomePage")) {
                System.out.println("\nWelcome! \n\"sign up\" - \"log in\"");
                System.out.println();
                enter = sc.nextLine();
                if (enter.equals("sign up"))
                    type = enter;
                else if(enter.equals("log in"))
                    type = enter;
                else{
                    System.out.println("invalid command");
                }
            }
            else if(type.equals("sign up")){
                String username, password, againPassword;
                System.out.println("enter your username");
                username = sc.nextLine();
                System.out.println("enter your password");
                password = sc.nextLine();
                System.out.println("confirm your password");
                againPassword = sc.nextLine();
                if(!check(username) || !check(password)){
                    System.out.println("your username or password contains invalid character");
//                    continue;
                }
                else if(!password.equals(againPassword)) {
                    System.out.println("different password");
                }else{
                    process.execute(new Command("signUp", username, password));
                }
            }
            else if (type.equals("log in")){
                String username, password;
                System.out.println("enter your username : ");
                username = sc.nextLine();
                System.out.println("enter your password : ");
                password = sc.nextLine();
                process.execute(new Command("logIn", username, password));
            }
            else if(type.equals("homePage")){
                System.out.println("\n" + account.getUserName() + "----" + "homePage\n");
                System.out.println("type \"sc\" to see all Colleges");
                System.out.println("type \"cu\" to see chosen units");
                System.out.println();
                enter = sc.nextLine();
                if(enter.equals("sc")){
                    type = "showColleges";
                }else if(enter.equals("cu")){
                    type = "chosenUnits";
                }else{
                    System.out.println("invalid command");
                }
            }
            else if(type.equals("adminHomePage")){
                System.out.println("\n" + account.getUserName() + "----" + "homePage\n");
                System.out.println("type \"sc\" to see all Colleges");
                System.out.println();
                enter = sc.nextLine();
                if(enter.equals("sc"))
                    type = "adminShowColleges";
                else{
                    System.out.println("invalid command");
                }
            }
            else if(type.equals("chosenUnits")){
                System.out.println("\n" + account.getUserName() + "----" + "chosen units");
                System.out.println();
                process.execute(new Command("units", "", ""));
                System.out.println("\ntype \"rm\" + \"your unit Code\" to remove a unit");
                System.out.println("type \"back\" to got to the previous page");
                System.out.println();
                enter = sc.nextLine();
                if(enter.equals("back")) {
                    type = "homePage";
                }
                else{
                    //here !!!!!!
                    //!!!!!!!
                    Scanner b = new Scanner(enter);
                    String s = b.next();
                    if(!s.equals("rm")){
                        System.out.println();
                        System.out.println("invalid command");
                        continue;
                    }else if(!b.hasNext()){
                        System.out.println();
                        System.out.println("no Code entered");
                        continue;
                    }
                    process.execute(new Command("rmUnitsByStudent", enter.substring(3), ""));
                }
            }
            else if(type.equals("showColleges")){
                System.out.println("\n" + account.getUserName() + "----" + "all Colleges \n");
                process.execute(new Command("colleges", "", ""));
                System.out.println();
                System.out.println("type \"goto\" + \"name\" to see all their courses - \"back\" to back to home page");
                System.out.println();
                enter = sc.nextLine();
                if(enter.equals("back")){
                    type = "homePage";
                    continue;
                }else{
                    if(!enter.substring(0, 4).equals("goto")){
                        System.out.println();
                        System.out.println("invalid command");
                        continue;
                    }
                    enter = enter.substring(5);
                }
                process.execute(new Command("chooseCollege", enter, ""));
            }
            else if(type.equals("showCourseDetail")){
                System.out.println("\n" + account.getUserName() + "----" + "chosen units");
                System.out.println();
                process.showHelpCourses();
                System.out.println();
                for(Course course1 : college.getCourses()){
                    process.showCourse(course1);
                }
                System.out.println();
                System.out.println("type \"get\" + \"your class code\" to catch the class - " +
                        "\"back\" to get back to College page\n");
                enter = sc.nextLine();
                if(enter.equals("back")){
                    type = "showColleges";
                    continue;
                }
                process.execute(new Command("chooseUnit", enter, ""));
            }

        }
    }
}


//log out need