package Base.Accounts;

import Base.Units.Course;
import Base.University.College;

import java.util.ArrayList;

public interface AdminWorks {
    void addCourseTOCollege(Course course, College college);
    void removeCourseFromCollege(Course course, College college);
    void increaseCapacity(Course course, College college);
    void addStudentsToCourse(Course course, College college);
    void removeStudentsFromCourse(Course course, College college);

    //check if we are in this college,
    // we dont change other courses from othe college

    ArrayList showAllStudents(Course course, College college);
    ArrayList showAllCourses(Course course, College college);
}
