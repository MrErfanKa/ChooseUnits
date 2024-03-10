package Base.UserInterface;

import Base.Accounts.Account;
import Base.Accounts.Admin;
import Base.Accounts.Student;
import Base.CLI;
import Base.Units.CoreCourse;
import Base.Units.Course;
import Base.Units.SpecializedCourse;
import Base.University.College;

import java.util.ArrayList;
import java.util.Scanner;

public class Process {
    private CLI cli;
    private ArrayList<Student> students;
    private ArrayList<College> colleges;
    private Admin admin = new Admin("admin", "1234");

    public Process(CLI cli) {
        students = new ArrayList<>();
        colleges = new ArrayList<>();
        this.cli = cli;
        init();
    }
    public void init(){
        College math = new College("Math");
        math.addCourseToCollege(new CoreCourse("poornaki", "22016", 257, 4, "12:00",
                "Shanbe - Doshanbe", "10:30-12:30", "1403/3/24", "riazi2"));
        math.addCourseToCollege(new SpecializedCourse("ardeshir", "22142", 70, 4, "08:00",
                "Yekshanbe - Seshanbe", "10:30-12:30", "1403/3/22", "mabani-riazi"));
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
                "Yekshanbe - Seshanbe", "09:00-10:30", "1403/3/24", "madar-Manteghi"));
        computer.addCourseToCollege(new CoreCourse("abam", "40254", 50, 3, "09:00",
                "Shanbe - Doshanbe", "10:30-12:30", "1403/3/22", "algorithm"));

        College mechanic = new College("Mechanic");
        mechanic.addCourseToCollege(new SpecializedCourse("jokar", "28015", 35, 3, "15:30",
                "Yekshanbe - Seshanbe", "15:00-16:30", "1403/3/21", "static"));
        mechanic.addCourseToCollege(new CoreCourse("dorali", "28139", 37, 2, "15:00",
                "Shanbe - Doshanbe", "12:30-16:30", "1403/3/25", "ashMech"));
        mechanic.addCourseToCollege(new SpecializedCourse("afshin", "28116", 58, 3, "15:30",
                "Shanbe - Doshanbe", "09:00-10:30", "1403/3/30", "thermodynamic"));

        colleges.add(math);
        colleges.add(physic);
        colleges.add(computer);
        colleges.add(mechanic);
    }

    public void showCourse(Course course1){
        System.out.println(course1.getNameCode() + " " + course1.getName() + " "
                + (course1 instanceof CoreCourse ? "omoomi" : "takhassosi") + " "
                + course1.getTeacher() + " " + course1.getCredit() + " " + course1.getClassDate()
                + " " + course1.getClassTime() + " "
                + course1.getExamDate() + " " + course1.getExamTime() + " " + course1.getStudents().size() + "/"
                + course1.getCapacity());
    }

    public void showHelpCourses(){
        System.out.println("Code / Name / Type / Teacher / Vahed / ClassDate / ClassTime" +
                " / ExamDate / ExamTime / Zarfiat");
    }

    public boolean find(College college, String want){
        for(Course course1 : college.getCourses()){
            if(course1.getNameCode().equals(want))
                return true;
        }
        return false;
    }

    public void execute(Command command){
        if(command.command.equals("signUp")){
            String username = command.arg1;
            String password = command.arg2;
            for(Student student : students){
                if(student.getUserName().equals(username)) {
                    System.out.println("This username already taken");
                    return;
                }
            }
            if(username.equals("admin")) {
                System.out.println("invalid username");
                return;
            }
            System.out.println("the new account created");
            cli.type = "welcomePage";
            students.add(new Student(command.arg1, command.arg2));
        }
        else if(command.command.equals("logIn")){
            String username = command.arg1;
            String password = command.arg2;
            if(admin.getUserName().equals(username) && admin.getPassword().equals(password)){
                cli.setAccount(admin);
                cli.type = "adminHomePage";
                System.out.println("logged in");
                return;
            }
            for(Student student : students){
                if(student.getUserName().equals(username) && student.getPassword().equals(password)){
                    cli.setAccount(student);
                    System.out.println("logged in");
                    cli.type = "homePage";
                    return;
                }
                System.out.println("the username was not found");
                return;
            }
        }
        else if(command.command.equals("units")){
            ArrayList<Course> courses = ((Student)cli.getAccount()).getCourses();
            for(Course course1 : courses){
                showCourse(course1);
            }
        }
        else if(command.command.equals("colleges")){
            for (College college1 : colleges)
                System.out.println(college1.getName());
        }
        else if(command.command.equals("chooseCollege")){
            College nowCollege = null;
            for(College college1 : colleges)
                if(college1.getName().equals(command.arg1)){
                    nowCollege = college1;
                    break;
                }
            if(nowCollege == null){
                System.out.println("\ninvalid College name\n");
                return;
            }
            System.out.println();
            cli.setCollege(nowCollege);
            cli.type = "showCourseDetail";
        }
        else if(command.command.equals("chooseUnit")){
            String arg1 = null, arg2 = null;
            int t = -1;
            for(int i = 1; i < command.arg1.length(); i++)
                if(command.arg1.charAt(i) == ' ' && i < command.arg1.length() - 1){
                    t = i;
                    arg1 = command.arg1.substring(0, i);
                    arg2 = command.arg1.substring(i + 1);
                }
            if(t == -1 || !arg1.equals("get") || !find(cli.getCollege(), arg2)){
                System.out.println("\ninvalid Command or Course Code");
                System.out.println();
                return;
            }
            Course nowCourse = null;
            for(Course course1 : cli.getCollege().getCourses())
                if(course1.getNameCode().equals(arg2)){
                    nowCourse = course1;
                    break;
                }
            cli.setCourse(nowCourse);
            System.out.println();
            if(((Student)cli.getAccount()).isTimeValid(nowCourse)){
                ((Student) cli.getAccount()).addCourse(nowCourse);
            }
            else if(((Student) cli.getAccount()).getCourses().contains(nowCourse)){
                System.out.println("this course has taken before");
                return;
            }else{
                System.out.println("this class couldn't take " +
                        "(interference with other taken courses)");
                return;
            }
            System.out.println("the \"" + nowCourse.getName() + "\" successfully took");
        }
        else if(command.command.equals("rmUnitsByStudent")){
            for(Course course : ((Student)cli.getAccount()).getCourses()){
                if(course.getNameCode().equals(command.arg1)){
                    ((Student) cli.getAccount()).removeCourse(course);
                    course.removeStudent(((Student)cli.getAccount()));
                    System.out.println();
                    System.out.println(course.getName() + " was successfully removed");
                    return;
                }
            }
            System.out.println();
            System.out.println("fail to remove (maybe because invalid code or you don't have this class)");
        }
    }

}
