package Base.Accounts;

import Base.Units.CoreCourse;
import Base.Units.Course;
import Base.Units.SpecializedCourse;
import Base.University.College;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public ArrayList<Student> getStudents(ArrayList<College> colleges){
        File file = new File("src\\Base\\Files\\accounts.txt");
        Scanner scanner = null;
        ArrayList<Student> arrayList = new ArrayList<>();
        try {
            scanner = new Scanner(file);
        }catch (Exception e){

        }
        while(scanner.hasNextLine()){
            Scanner sc = new Scanner(scanner.nextLine());
            String name, pass, courseCode, collegeName;
            name = sc.next();
            pass = sc.next();
            collegeName = sc.next();
            Student student = new Student(name, pass);
            College college = null;
            for (College college1 : colleges) {
                if (college1.getName().equals(collegeName)) {
                    college = college1;
                    break;
                }
            }
            while (sc.hasNext()){
                courseCode = sc.next();
                Course course = null;
                for (Course course1 : college.getCourses()) {
                    if (course1.getNameCode().equals(courseCode)) {
                        course = course1;
                        break;
                    }
                }
                student.addCourse(course);
            }
            arrayList.add(student);
        }
        return  arrayList;
    }
    public ArrayList<College> getColleges(){
        File file = new File("src\\Base\\Files\\Colleges.txt");
        Scanner scanner = null;
        ArrayList<College> arrayList = new ArrayList<>();
        try {
            scanner = new Scanner(file);
        }catch (Exception e){

        }
        String Cname = "";
        while (scanner.hasNextLine()){
            String s = scanner.next();
            if(!Cname.equals(s)){
                arrayList.add(new College(s));
            }
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

            if(type) {
                SpecializedCourse specializedCourse = new SpecializedCourse(teacher, nameCode, zarfiat, vahed, examTime, classDate, classTime, examDate, name);
                College college = null;
                for(College college1 : arrayList)
                    if(college1.getName().equals(s)){
                        college = college1;
                        break;
                    }
                college.addCourseToCollege(specializedCourse);
            }else{
                CoreCourse coreCourse = new CoreCourse(teacher, nameCode, zarfiat, vahed, examTime, classDate, classTime, examDate, name);
                College college = null;
                for(College college1 : arrayList)
                    if(college1.getName().equals(s)){
                        college = college1;
                        break;
                    }
                college.addCourseToCollege(coreCourse);
            }
        }
        return arrayList;
    }
    public void save(){

    }
}
