package Base.Accounts;

import Base.Units.Course;
import Base.University.College;

import java.util.ArrayList;

public interface AdminWorks {
    void addCourseTOCollege(Course course, College college);
    void removeCourseFromCollege(Course course, College college);
    void increaseCapacity(Course course, int number);
    void addStudentsToCourse(Course course, Student student);
    void removeStudentsFromCourse(Course course, Student student);

    //check if we are in this college,
    // we dont change other courses from othe college

    ArrayList showAllStudents(Course course);
    ArrayList showAllCourses(College college);
}
