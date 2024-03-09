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
        college.addCourseToCollege(course);
    }

    @Override
    public void removeCourseFromCollege(Course course, College college) {
        college.removeCourseFromCollege(course);
    }

    @Override
    public void increaseCapacity(Course course, int number) {
        course.addCapacity(number);
    }

    @Override
    public void addStudentsToCourse(Course course, Student student) {
        course.addStudent(student);
    }

    @Override
    public void removeStudentsFromCourse(Course course, Student student) {
        course.removeStudent(student);
    }

    @Override
    public ArrayList showAllStudents(Course course) {
        return null;
    }

    @Override
    public ArrayList showAllCourses(College college) {
        return null;
    }
}
