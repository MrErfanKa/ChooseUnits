package Base.Accounts;

import Base.Units.Course;
import Base.University.College;

import java.util.ArrayList;

public class Admin extends Account implements AdminWorks{

    public Admin(String userName, String password) {
        super(userName, password);
    }

    @Override
    public void addCourseTOCollege(Course course, College college) {

    }

    @Override
    public void removeCourseFromCollege(Course course, College college) {

    }

    @Override
    public void increaseCapacity(Course course, College college) {

    }

    @Override
    public void addStudentsToCourse(Course course, College college) {

    }

    @Override
    public void removeStudentsFromCourse(Course course, College college) {

    }

    @Override
    public ArrayList showAllStudents(Course course, College college) {
        return null;
    }

    @Override
    public ArrayList showAllCourses(Course course, College college) {
        return null;
    }
}
