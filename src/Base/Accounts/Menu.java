package Base.Accounts;

import Base.Units.CoreCourse;
import Base.Units.Course;
import Base.Units.SpecializedCourse;
import Base.University.College;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void makeCollegesAndStudents(ArrayList<College> colleges, ArrayList<Student> students){
        File file = new File("src\\Base\\Files\\Colleges.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        }catch (Exception e){

        }
        int k = scanner.nextInt();
        for(int i = 0; i < k; i++){
            String name, pass;
            name = scanner.next();
            pass = scanner.next();
            students.add(new Student(name, pass));
        }
        k = scanner.nextInt();
        for(int l = 0; l < k; l++){
            String collegeName = scanner.next();
            College college = new College(collegeName);
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                boolean type;
                int vahed, zarfiat;
                String teacher, nameCode, examTime, classDate, classTime, examDate, name;

                type = scanner.nextBoolean();

                vahed = scanner.nextInt();
                zarfiat = scanner.nextInt();

                teacher = scanner.next();
                nameCode = scanner.next();
                examTime = scanner.next();
                classDate = scanner.next();
                classTime = scanner.next();
                examDate = scanner.next();
                name = scanner.next();

                Course course = null;

                if (type) {
                    course = new SpecializedCourse(teacher, nameCode, zarfiat, vahed, examTime, classDate, classTime, examDate, name);
                } else {
                    course = new CoreCourse(teacher, nameCode, zarfiat, vahed, examTime, classDate, classTime, examDate, name);
                }

                int m = scanner.nextInt();
                for (int j = 0; j < m; j++) {
                    String studentName;
                    studentName = scanner.next();
                    Student student = null;

                    for (Student student1 : students)
                        if (student1.getUserName().equals(studentName))
                            student = student1;

                    student.addCourse(course);
                }

                college.addCourseToCollege(course);

            }
            colleges.add(college);
        }
    }
    public void save(ArrayList<College> colleges, ArrayList<Student> students){
        File file = new File("src\\Base\\Files\\Colleges.txt");
        FileOutputStream fileOutputStream = null;
        PrintStream printWriter = null;
        try {
            file.delete();
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            printWriter = new PrintStream(fileOutputStream);
        }catch (Exception e){

        }

        printWriter.println(students.size());
        for(Student student : students){
            printWriter.println(student.getUserName() + " " + student.getPassword());
        }

        printWriter.println(colleges.size());
        for(College college : colleges){
            printWriter.println(college.getName());
            printWriter.println(college.getCourses().size());
            for(Course course : college.getCourses()){
                if(course instanceof SpecializedCourse)
                    printWriter.println(true);
                else printWriter.println(false);
                printWriter.println(course.getCredit() + " " +
                        course.getCapacity() + " " +
                        course.getTeacher() + " " +
                        course.getNameCode() + " " +
                        course.getExamTime() + " " +
                        course.getClassDate() + " " +
                        course.getClassTime() + " " +
                        course.getExamDate() + " " +
                        course.getName());
                printWriter.println(course.getStudents().size());
                for(Student student : course.getStudents()){
                    printWriter.println(student.getUserName());
                }
            }
        }
    }
}
