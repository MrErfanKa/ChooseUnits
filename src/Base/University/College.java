package Base.University;

import Base.Units.Course;

import java.util.ArrayList;

public class College {
    private final ArrayList<Course> courses;
    //check final :
    private final String name;
    public College(String name){
        courses = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addCourseToCollege(Course course){
        courses.add(course);
    }
    public void removeCourseFromCollege(Course course){
        courses.remove(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
