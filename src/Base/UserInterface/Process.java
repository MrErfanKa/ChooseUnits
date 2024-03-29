package Base.UserInterface;

import Base.Accounts.Account;
import Base.Accounts.Admin;
import Base.Accounts.Menu;
import Base.Accounts.Student;
import Base.Additional.Scan;
import Base.CLI;
import Base.Times.Time;
import Base.Times.TimeHelper;
import Base.Units.CoreCourse;
import Base.Units.Course;
import Base.Units.SpecializedCourse;
import Base.University.College;

import java.util.ArrayList;
import java.util.Scanner;

public class Process {
    private CLI cli;
    private ArrayList<Student> students;
    private Menu menu;
    private ArrayList<College> colleges;
    private Admin admin = new Admin("admin", "1234");

    public Process(CLI cli, Menu menu) {
        students = new ArrayList<>();
        colleges = new ArrayList<>();
        this.cli = cli;
        this.menu = menu;
        menu.makeCollegesAndStudents(colleges, students);
    }
    public void save(){
        menu.save(colleges, students);
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
    public void makeNewCourse(){
        String code, name, type, teacher, classDate, classTime, classStartTime, classFinishTime, ExamDate, ExamTime;
        int vahed, zarfiat;
        Scan sc = cli.getSc();
        System.out.println("enter your Class code - \"back\" to go to sign up/log in page");
        code = sc.nextLine();
        for(int i = 0; i < code.length(); i++)
            if(code.charAt(i) < '0' || code.charAt(i) > '9'){
                code = "";
                break;
            }
        if(code.equals("")){
            System.out.println();
            System.out.println("please enter a valid code");
            cli.type = "adminShowCourseDetail";
            return;
        }
        if(code.equals("back")){
            cli.type = "adminShowCourseDetail";
            return;
        }
        for(Course course : cli.getCollege().getCourses())
            if(course.getNameCode().equals(code)){
                System.out.println();
                System.out.println("same code with other courses");
                return;
            }

        System.out.println("enter your Class name - \"back\" to go to sign up/log in page");
        name = sc.nextLine();
        if(name.equals("")){
            System.out.println();
            System.out.println("please enter a valid name");
            cli.type = "adminShowCourseDetail";
            return;
        }
        if(name.equals("back")){
            cli.type = "adminShowCourseDetail";
            return;
        }

        System.out.println("enter your Class type between omoomi-takhassosi - \"back\" to go to sign up/log in page");
        type = sc.nextLine();
        if(type.equals("") || (!type.equals("omoomi") && !type.equals("takhassosi"))){
            System.out.println();
            System.out.println("please enter a valid type");
            cli.type = "adminShowCourseDetail";
            return;
        }
        if(type.equals("back")){
            cli.type = "adminShowCourseDetail";
            return;
        }

        System.out.println("enter your Class teacher - \"back\" to go to sign up/log in page");
        teacher = sc.nextLine();
        if(teacher.equals("")){
            System.out.println();
            System.out.println("please enter a valid teacher");
            cli.type = "adminShowCourseDetail";
            return;
        }
        if(teacher.equals("back")){
            cli.type = "adminShowCourseDetail";
            return;
        }

        System.out.println("enter your Class vahed between 0-4 - \"back\" to go to sign up/log in page");
        String vahedS = sc.nextLine();
        if(vahedS.equals("back")){
            cli.type = "adminShowCourseDetail";
            return;
        }
        if(vahedS.length() != 1){
            vahedS = "";
        }
        for(int i = 0; i < vahedS.length(); i++)
            if(vahedS.charAt(i) > '9' || vahedS.charAt(i) < '0'){
                vahedS = "";
                break;
            }
        if(vahedS.equals("")){
            System.out.println();
            System.out.println("please enter a valid vahed");
            cli.type = "adminShowCourseDetail";
            return;
        }
        vahed = vahedS.charAt(0) - '0';
        if(vahed > 4){
            System.out.println();
            System.out.println("you can use vahed between 0 - 4");
            cli.type = "adminShowCourseDetail";
            return;
        }

        System.out.println("enter your Class date number - \"back\" to go to sign up/log in page");
        classDate = TimeHelper.chooseDayes(sc);
        if(classDate.equals("")){
            System.out.println();
            System.out.println("please enter a valid date");
            cli.type = "adminShowCourseDetail";
            return;
        }
        if(classDate.equals("back")){
            cli.type = "adminShowCourseDetail";
            return;
        }

        System.out.println("enter your Class start time in form \"hh:mm\" - \"back\" to go to sign up/log in page");
        classStartTime = sc.nextLine();
        try {
            int h = (classStartTime.charAt(0) - '0') * 10 + (classStartTime.charAt(1) - '0');
            int m = (classStartTime.charAt(3) - '0') * 10 + (classStartTime.charAt(4) - '0');
            if(h > 23 || m >= 60 || h < 0 || m < 0)
                classStartTime = "";
        }catch (Exception e){
            classStartTime = "";
        }
        if (classStartTime.equals("") || classStartTime.length() > 5 || classStartTime.charAt(2) != ':'){
            System.out.println();
            System.out.println("please enter a valid Exam Time");
            cli.type = "adminShowCourseDetail";
            return;
        }
        if(classStartTime.equals("back")){
            cli.type = "adminShowCourseDetail";
            return;
        }

        System.out.println("enter your Class finish time in form \"hh:mm\" - \"back\" to go to sign up/log in page");
        classFinishTime = sc.nextLine();
        try {
            int h = (classFinishTime.charAt(0) - '0') * 10 + (classFinishTime.charAt(1) - '0');
            int m = (classFinishTime.charAt(3) - '0') * 10 + (classFinishTime.charAt(4) - '0');
            if(h > 23 || m >= 60 || h < 0 || m < 0)
                classFinishTime = "";
        }catch (Exception e){
            classFinishTime = "";
        }
        if (classFinishTime.equals("") || classFinishTime.length() > 5 || classFinishTime.charAt(2) != ':'){
            System.out.println();
            System.out.println("please enter a valid Exam Time");
            cli.type = "adminShowCourseDetail";
            return;
        }
        if(classFinishTime.equals("back")){
            cli.type = "adminShowCourseDetail";
            return;
        }

        classTime = classStartTime + "-" + classFinishTime;

        System.out.println("enter your Exam month in 1403 month between 1-4 + date between 1-31 - \"back\" to go to sign up/log in page");
        ExamDate = sc.nextLine();
        int date = 0;
        int month = 0;
        try {
            Scanner b = new Scanner(ExamDate);
            month = b.nextInt();
            date = b.nextInt();
        }catch (Exception x){
            ExamDate = "";
        }
        if(date < 1 || date > 31 || month < 1 || month > 4)
            ExamDate = "";
        if(ExamDate.equals("")){
            System.out.println();
            System.out.println("please enter a valid examDate");
            cli.type = "adminShowCourseDetail";
            return;
        }
        if(ExamDate.equals("back")){
            cli.type = "adminShowCourseDetail";
            return;
        }
        ExamDate = "1403/" + month + "/" + date;

        System.out.println("enter your Exam time in form \"hh:mm\" - \"back\" to go to sign up/log in page");
        ExamTime = sc.nextLine();
        try {
            int h = (ExamTime.charAt(0) - '0') * 10 + (ExamTime.charAt(1) - '0');
            int m = (ExamTime.charAt(3) - '0') * 10 + (ExamTime.charAt(4) - '0');
            if(h > 23 || m >= 60 || h < 0 || m < 0)
                ExamTime = "";
        }catch (Exception e){
            ExamTime = "";
        }
        if (ExamTime.equals("") || ExamTime.length() > 5 || ExamTime.charAt(2) != ':'){
            System.out.println();
            System.out.println("please enter a valid Exam Time");
            cli.type = "adminShowCourseDetail";
            return;
        }
        if(ExamTime.equals("back")){
            cli.type = "adminShowCourseDetail";
            return;
        }

        System.out.println("enter your Class zarfiat - \"back\" to go to sign up/log in page");
        String zarfiatS = sc.nextLine();
        if(zarfiatS.equals("back")){
            cli.type = "adminShowCourseDetail";
            return;
        }
        for(int i = 0; i < zarfiatS.length(); i++)
            if(zarfiatS.charAt(i) > '9' || zarfiatS.charAt(i) < '0'){
                zarfiatS = "";
                break;
            }
        if(zarfiatS.equals("")){
            System.out.println();
            System.out.println("please enter a valid zarfiat");
            cli.type = "adminShowCourseDetail";
            return;
        }
        zarfiat = new Scanner(zarfiatS).nextInt();

        for(Course course : cli.getCollege().getCourses()){
            if(course.getNameCode().equals(code) || course.getName().equals(name))
                return;
        }

        if(type.equals("omoomi"))
            cli.getCollege().addCourseToCollege(new CoreCourse(teacher, code, zarfiat, vahed, ExamTime, classDate, classTime, ExamDate, name));
        else if(type.equals("takhassosi"))
            cli.getCollege().addCourseToCollege(new SpecializedCourse(teacher, code, zarfiat, vahed, ExamTime, classDate, classTime, ExamDate, name));
        System.out.println();
        System.out.println("the class \"" + name + "\" successfully created");
    }

    public void load(){
        colleges.clear();
        students.clear();
        menu.makeCollegesAndStudents(colleges, students);
    }
    public void execute(Command command){
        if(command.command.equals("signUp")){
            String username = command.arg1;
            String password = command.arg2;
            for(Student student : students){
                if(student.getUserName().equals(username)) {
                    System.out.println("This username already taken");
                    System.out.println();
                    return;
                }
            }
            if(username.equals("admin")) {
                System.out.println("invalid username");
                System.out.println();
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
            }
            System.out.println("the username was not found");
            System.out.println();
            return;
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
        else if(command.command.equals("adminChooseCollege")){
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
            cli.type = "adminShowCourseDetail";
        }
        else if(command.command.equals("increaseCapacity")){
            Course newCourse = null;
            for(Course course : cli.getCollege().getCourses()){
                if(course.getNameCode().equals(command.arg1)){
                    newCourse = course;
                    break;
                }
            }
            if(newCourse == null){
                System.out.println();
                System.out.println("invalid Class Code");
                return;
            }
            for(int i = 0; i < command.arg2.length(); i++){
                if(command.arg2.charAt(i) <'0' || command.arg2.charAt(i) > '9'){
                    System.out.println();
                    System.out.println("invalid number");
                    return;
                }
            }
            int num = new Scanner(command.arg2).nextInt();
            ((Admin)cli.getAccount()).increaseCapacity(newCourse, num);
            System.out.println();
            System.out.println("Capacity increased " + num);
        }
        else if(command.command.equals("adminRemoveCourse")){
            Course newCourse = null;
            for(Course course : cli.getCollege().getCourses())
                if(course.getNameCode().equals(command.arg1)){
                    newCourse = course;
                    break;
                }
            if(newCourse == null){
                System.out.println();
                System.out.println("invalid Code");
                return;
            }
            ArrayList<Student> students1 = newCourse.getStudents();
            for(Student student : students1){
                student.removeCourse(newCourse);
            }
            cli.getCollege().removeCourseFromCollege(newCourse);
            System.out.println();
            System.out.println(newCourse.getName() + " was successfully removed");
        }
        else if(command.command.equals("adminAddCourse")){
            System.out.println();
            makeNewCourse();

        }
        else if(command.command.equals("showStudents")){
            Course newCourse = null;
            for (Course course1 : cli.getCollege().getCourses()){
                if(course1.getNameCode().equals(command.arg1)) {
                    newCourse = course1;
                    cli.setCourse(newCourse);
                    break;
                }
            }
            if(newCourse == null){
                System.out.println();
                System.out.println("invalid code");
                return;
            }
            System.out.println("\n" + cli.getAccount().getUserName() + "----" + "all Colleges \n");
//            System.out.println(cli.getAccount().getUserName() + "");
            for(Student student : newCourse.getStudents()){
                System.out.print(student.getUserName()
                        + (student != newCourse.getStudents().get(newCourse.getStudents().size() - 1) ? " - " : "\n"));
            }
            cli.type = "showStudents";
            System.out.println();
            System.out.println("type \"add\" + \"name\" to add a student to this course - "
                    + "\"rm\" + \"name\" to remove a student from this course");
            System.out.println("type \"back\" to get back to show courses page");
        }
        else if(command.command.equals("addStudent")){
            Student newStudent = null;
            for(Student student : cli.getCourse().getStudents())
                if(student.getUserName().equals(command.arg1)){
                    System.out.println();
                    System.out.println("the student already had this course");
                    return;
                }
            for(Student student : students)
                if(student.getUserName().equals(command.arg1)){
                    newStudent = student;
                    break;
                }
            if(newStudent == null){
                System.out.println();
                System.out.println("invalid name");
                return;
            }
            if(!newStudent.isTimeValid(cli.getCourse())){
                System.out.println();
                System.out.println("the student could not take this course (interference with other taken courses)");
                return;
            }
            System.out.println();
            System.out.println(cli.getCourse().getName() + " is successfully added to \"" + newStudent.getUserName() + "\" courses");
            newStudent.addCourse(cli.getCourse());
        }
        else if(command.command.equals("rmStudent")){
            Student newStudent = null;
            for(Student student : cli.getCourse().getStudents())
                if(student.getUserName().equals(command.arg1)){
                    newStudent = student;
                    break;
                }
            if(newStudent == null){
                System.out.println();
                System.out.println("this student don't have this course");
                return;
            }
            System.out.println();
            System.out.println(cli.getCourse().getName() + " is successfully removed from \"" + newStudent.getUserName() + "\" courses");
            newStudent.removeCourse(cli.getCourse());
        }
    }

}
