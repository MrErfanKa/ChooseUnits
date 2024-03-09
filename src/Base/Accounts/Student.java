package Base.Accounts;

import Base.Units.Course;
import Base.University.College;

import java.util.ArrayList;

public class Student extends Account implements StudentsWorks{

    private ArrayList<Course> courses;
    public Student(String userName, String password) {
        super(userName, password);
        courses = new ArrayList<>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public void addCourse(Course course, College college) {

    }

    @Override
    public void removeCourse(Course course, College college) {

    }

    @Override
    public ArrayList showAllCourses(Course course, College college) {
        return null;
    }
}
