package Base.Accounts;

import Base.Units.Course;
import Base.University.College;

import java.util.ArrayList;

public class Student extends Account{

    private ArrayList<Course> courses;
    public Student(String userName, String password) {
        super(userName, password);
        courses = new ArrayList<>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void addCourse(Course course){
        courses.add(course);
    }
}
